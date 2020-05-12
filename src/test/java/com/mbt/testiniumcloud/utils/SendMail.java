package com.mbt.testiniumcloud.utils;

import com.mbt.testiniumcloud.driver.DriverCreater;
import org.graphwalker.java.test.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
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

    public SendMail(){

        slash = DriverCreater.osName.equals("WINDOWS") ? "\\" : "/";
        testPlatform = DriverCreater.isTestinium ? "Testinium" : "Local";
    }

    private void sendMail(String toMail, String value, String testRunFlow, String testResultTxt) {

        Properties props = new Properties();
        props.put("mail.user", "yourgmail");
        props.put("mail.password", "yourpassword");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("yourgmail", "yourpassword");
            }
        });
        try {
            MimeMessage msg = new MimeMessage(session);

            String to = toMail;
            InternetAddress[] address = InternetAddress.parse(to, true);

            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm").format(new Date());
            msg.setSubject("TestiniumCloudMBT: " + timeStamp + "  " + testPlatform);
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart bodyPart = new MimeBodyPart();
            //bodyPart.setContent(a,"text/html; charset=utf-8");
            //multipart.addBodyPart(bodyPart);
            String b = "Test Result\r\n\r\n" + value;
            bodyPart.setText(b,"utf-8");
            multipart.addBodyPart(bodyPart);
            MimeBodyPart attachPart = new MimeBodyPart();

            try {
                attachPart.attachFile(System.getProperty("user.dir")+ slash + testRunFlow);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            multipart.addBodyPart(attachPart);
            MimeBodyPart attachPart2 = new MimeBodyPart();

            try {
                attachPart2.attachFile(System.getProperty("user.dir")+ slash + testResultTxt);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            multipart.addBodyPart(attachPart2);
            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("Mail has been sent successfully");
        } catch (MessagingException ditttt) {
            System.out.println("Unable to send an email" + ditttt);
        }

        // https://myaccount.google.com/lesssecureapps
 // ayarı yap

    }

    public void sendMailTestResult(Result testResult, List<String> listExecution, String mail){

        try {
            String testResultInfo = "Test Başarılı";
            List<String> list = new ArrayList<String>();
            if (testResult.hasErrors()) {
                testResultInfo = "Test Başarısız";
                list = testResult.getErrors();
            }
            list.add("\r\n\r\nDone: [" + testResult.getResults().toString(2) + "]");
            BufferedWriter writer = createWriter("testRunFlow.txt",false);
            for (int i=0; i < listExecution.size() ; i++){
                writer.append(listExecution.get(i));
                writer.newLine();
            }
            Thread.sleep(1000);
            writer.close();
            Thread.sleep(2000);
            BufferedWriter writer2 = createWriter("testResult.txt",false);
            for (int i=0; i < list.size() ; i++){
                writer2.append(list.get(i));
                writer2.newLine();
            }
            Thread.sleep(1000);
            writer2.close();
            Thread.sleep(2000);
            sendMail(mail,testResultInfo,"testRunFlow.txt","testResult.txt");
        }catch (Exception e){
            logger.info("Mail yollanamadı.");
        }
    }

    public BufferedWriter createWriter(String dir, boolean appendCondition) {
       BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + slash + dir,appendCondition));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }

    public BufferedReader createReader(String dir) {
       BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + slash + dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }


}