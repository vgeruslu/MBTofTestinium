package com.mbt.testiniumcloud.utils;

import com.mbt.testiniumcloud.driver.DriverCreater;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.graphwalker.java.test.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {


    private static final Logger logger = LoggerFactory.getLogger(SendMail.class);

    String slash;
    String testPlatform;
    String senderMail;
    String senderPassword;
    String sendMailProjectName;
    String userDir;

    public SendMail(){

        slash = DriverCreater.osName.equals("WINDOWS") ? "\\" : "/";
        testPlatform = DriverCreater.isTestinium ? "Testinium" : "Local";
        senderMail = DriverCreater.ConfigurationProp.getString("senderMail");
        senderPassword = DriverCreater.ConfigurationProp.getString("senderPassword");
        sendMailProjectName = DriverCreater.ConfigurationProp.getString("sendMailProjectName");
        userDir = System.getProperty("user.dir");
    }

    private void sendMail(String toMail, String testResultInfo, String testFailInfo, String testResultTxt, String excelPath) {

        Properties props = new Properties();
        props.put("mail.user", senderMail);
        props.put("mail.password", senderPassword);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, senderPassword);
            }
        });
        try {
            MimeMessage msg = new MimeMessage(session);

            String to = toMail;
            InternetAddress[] address = InternetAddress.parse(to, true);

            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss XXX").format(new Date());
            msg.setSubject(sendMailProjectName + ": " + timeStamp + "  " + testPlatform);
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart bodyPart = new MimeBodyPart();
            //bodyPart.setContent(a,"text/html; charset=utf-8");
            //multipart.addBodyPart(bodyPart);
            String b = "Platform Name: " + DriverCreater.platformName + "\r\n\r\n"
                    + "Browser Name: " + DriverCreater.browserName + "\r\n\r\n"
                    + "Test Case:  " + DriverCreater.TestCaseName + "\r\n\r\n"
                    + "Test Result:  " + testResultInfo;
            bodyPart.setText(b,"utf-8");
            multipart.addBodyPart(bodyPart);
            if(testResultInfo.equals("Test Failed")) {
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
            System.out.println("Unable to send an email" + ditttt);
        }

        // https://myaccount.google.com/lesssecureapps
        // lesssecureapps must be true for sender mail account

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
            logger.info("Could not send mail.");
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