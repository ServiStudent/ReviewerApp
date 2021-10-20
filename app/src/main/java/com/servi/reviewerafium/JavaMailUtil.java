package com.servi.reviewerafium;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaMailUtil {

    public static void sendMail(String recepient, String text) throws Exception {
        System.out.println("Preparing to send email");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = Global.email;
        String password = Global.emailPassword;
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient, text);

        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String text) {
        Message message = new MimeMessage(session);
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE dd-MM-yyyy 'om' HH:mm");
        Date date = new Date(System.currentTimeMillis());
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Review received");
            String HTMLCode = "<h2>In-store review ontvangen:</h2>" + "<div style=\"height:100px; background:#c9c9c9\">" + text + "</div>" + "<br/><br/><br/><br/><h4> Ontvangen op: </h4>" + formatter.format(date);
            message.setContent(HTMLCode, "text/html");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
