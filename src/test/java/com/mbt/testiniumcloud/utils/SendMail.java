package com.mbt.testiniumcloud.utils;

import com.mbt.testiniumcloud.driver.Driver;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.graphwalker.java.test.Result;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

public class SendMail {

    private static final Logger logger = LogManager.getLogger(SendMail.class);

    String slash;
    String testPlatform;
    String sendMailActive;
    String senderMail;
    String senderPassword;
    String sendMailProjectName;
    String userDir;

    public SendMail(){

        slash = Driver.osName.equals("WINDOWS") ? "\\" : "/";
        testPlatform = "Local";
        sendMailActive = Driver.ConfigurationProp.getString("sendMailActive");
        senderMail = Driver.ConfigurationProp.getString("senderMail");
        senderPassword = Driver.ConfigurationProp.getString("senderPassword");
        sendMailProjectName = Driver.ConfigurationProp.getString("sendMailProjectName");
        userDir = System.getProperty("user.dir");
    }

    private void sendMail(String toMail, String testResultInfo, String testFailInfo, String testResultTxt, String excelPath) {

        if(!sendMailActive.equals("true") || toMail.equals("") || senderMail.equals("") || senderPassword.equals("")){

            System.out.println(!sendMailActive.equals("true") ? "Mail atma aktif değil" : "toMail, SenderMail ve SenderPassword boş bırakılamaz");
        }else {
            Properties props = new Properties();
            props.put("mail.user", senderMail);
            props.put("mail.password", senderPassword);
            // props.put("mail.debug", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            //properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderMail, senderPassword);
                }
            });

            try {
                //Transport bus = session.getTransport("smtp");
                Message msg = new MimeMessage(session);
                // msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
                msg.setFrom(new InternetAddress(senderMail));

                String to = toMail;
                InternetAddress[] address = InternetAddress.parse(to,true);

                msg.setRecipients(Message.RecipientType.TO, address);
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss XXX").format(new Date());
                msg.setSubject(sendMailProjectName + ": " + timeStamp + "  " + testPlatform);
                MimeMultipart multipart = new MimeMultipart();
                MimeBodyPart bodyPart = new MimeBodyPart();
                //bodyPart.setContent(a,"text/html; charset=utf-8");
                //multipart.addBodyPart(bodyPart);
                String b = "Platform Name: " + Driver.platformName + "\r\n\r\n"
                        + "Browser Name: " + Driver.browserName + "\r\n\r\n"
                        + "Class Name: " + Driver.TestClassName + "\r\n\r\n"
                        + "Test Case:  " + Driver.TestCaseName + "\r\n\r\n"
                        + "Test Result:  " + testResultInfo;
                bodyPart.setText(b, "utf-8");
                multipart.addBodyPart(bodyPart);
                if (testResultInfo.equals("Test Failed")) {
                    MimeBodyPart attachPart = new MimeBodyPart();
                    try {
                        attachPart.attachFile(userDir + slash + testFailInfo);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    multipart.addBodyPart(attachPart);
                }

                MimeBodyPart attachPart2 = new MimeBodyPart();

                try {
                    attachPart2.attachFile(userDir + slash + testResultTxt);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                multipart.addBodyPart(attachPart2);

                MimeBodyPart attachPart3 = new MimeBodyPart();

                try {
                    attachPart3.attachFile(excelPath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                multipart.addBodyPart(attachPart3);
                msg.setContent(multipart);
                Transport.send(msg);
                System.out.println("Mail has been sent successfully");
            } catch (MessagingException ditttt) {
                System.out.println("Unable to send an email");
                ditttt.printStackTrace();
            }
            // https://myaccount.google.com/lesssecureapps
            // ayarı yap
        }

    }

    public void sendMailTestResult(Result testResult, String mail, String excelPath){

        try {
            String testResultInfo = "Test Successfull";
            List<String> list = new ArrayList<String>();
            if (testResult.hasErrors()) {
                testResultInfo = "Test Failed";
                BufferedWriter writer3 = createWriter("testFailInfo.txt",false);
                for (int i=0; i < testResult.getErrors().size() ; i++){
                    writer3.append(testResult.getErrors().get(i));
                    writer3.newLine();
                }
                Thread.sleep(1000);
                writer3.close();
            }
            list.add("Done: [" + "\r\n" + "  \"totalFailedNumberOfModels\"" + testResult.getResults()
                    .toString(2).split("\"totalFailedNumberOfModels\"")[1] + "]");

            Thread.sleep(2000);
            BufferedWriter writer2 = createWriter("testResult.txt",false);
            for (int i=0; i < list.size() ; i++){
                writer2.append(list.get(i));
                writer2.newLine();
            }
            Thread.sleep(1000);
            writer2.close();
            Thread.sleep(2000);
            sendMail(mail,testResultInfo,"testFailInfo.txt","testResult.txt", excelPath);
        }catch (Exception e){
            logger.info("Mail yollanamadı.");
            e.printStackTrace();
        }
    }

    public BufferedWriter createWriter(String dir, boolean appendCondition) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriterWithEncoding(userDir + slash + dir, StandardCharsets.UTF_8, appendCondition));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }

    public BufferedReader createReader(String dir) {
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(new File(userDir + slash + dir).toPath(), StandardCharsets.UTF_8);
        //new BufferedReader(new FileReader(userDir + slash + dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }

}