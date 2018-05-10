/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.bl.utility;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author shakil
 */
public class MailSender {

    private Session sessionNormal;
    private Properties properties = System.getProperties();
    private String mailHost;
    private static MailSender mailSender = new MailSender(StaticConfigurations.SMTPhost);

    public static MailSender getInstance() {
        return mailSender;
    }

    protected MailSender(String mailHost) {

        this.mailHost = mailHost;
        initializeSessionNormal(this.mailHost);
    }

    public boolean sendMail(String to, String subject, String text){
        return sendMail(StaticConfigurations.FROM_EMAIL_ADDRESS,StaticConfigurations.FROM_EMAIL_NAME, to, subject, text);
    }
    public boolean sendMail(String fromEmail, String fromName, String to, String subject, String text) {

        if (this.sessionNormal == null) {
            initializeSessionNormal(this.mailHost);
        }

        boolean issentMailSuccess = false;
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(this.sessionNormal);

            // Set From: header field of the header.
            //message.setFrom(new InternetAddress());
            message.setFrom(new InternetAddress(fromEmail, fromName));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            //message.setText(text);
            message.setContent(text, "text/html; charset=utf-8");

            // Send message
            Transport.send(message);
            issentMailSuccess = true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (Exception ex){
        	ex.printStackTrace();
            System.out.println("Could not Send Email for this Email ID.");
        }
        return issentMailSuccess;
    }

    public boolean sendMail(List<String> to, List<String> cc, List<String> bcc, String subject, String body) {
        return sendMail(StaticConfigurations.FROM_EMAIL_ADDRESS, StaticConfigurations.FROM_EMAIL_NAME, to, cc, bcc, subject, body);
    }

    private boolean sendMail(String fromEmail, String fromName, List<String> to, List<String> cc, List<String> bcc, String subject, String body) {

        if (this.sessionNormal == null) {
            initializeSessionNormal(this.mailHost);
        }

        boolean issentMailSuccess = false;
        try {
            // Create a default MimeMessage object.
            MimeMessage msg = new MimeMessage(this.sessionNormal);

            // Set From: header field of the header.
            msg.setFrom(new InternetAddress(fromEmail, fromName));

            if (to != null) {
                for (String email : to) {
                    msg.addRecipient(Message.RecipientType.TO,
                            new InternetAddress(email));
                }

            }
            if (cc != null) {
                for (String email : cc) {
                    msg.addRecipient(Message.RecipientType.CC,
                            new InternetAddress(email));
                }
            }

            if (bcc != null) {
                for (String email : bcc) {
                    msg.addRecipient(Message.RecipientType.BCC,
                            new InternetAddress(email));
                }
            }

            // Set Subject: header field
            msg.setSubject(subject);

            // Now set the actual message
            //msg.setText(body);
            msg.setContent(body, "text/html; charset=utf-8");

            // Send message
            Transport.send(msg);
            issentMailSuccess = true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
        return issentMailSuccess;
    }

    public boolean sendMail(String fromEmail, String fromName, List<String> to, List<String> cc, List<String> bcc, String subject, String body, String pathToAttachement, String nameToAttachement) {

        if (this.sessionNormal == null) {
            initializeSessionNormal(this.mailHost);
        }

        boolean issentMailSuccess = false;
        try {
            // Create a default MimeMessage object.
            MimeMessage msg = new MimeMessage(this.sessionNormal);

            // Set From: header field of the header.
            msg.setFrom(new InternetAddress(fromEmail, fromName));
            if (to != null) {
                for (String email : to) {
                    msg.addRecipient(Message.RecipientType.TO,
                            new InternetAddress(email));
                }

            }
            if (cc != null) {
                for (String email : cc) {
                    msg.addRecipient(Message.RecipientType.CC,
                            new InternetAddress(email));
                }
            }

            if (bcc != null) {
                for (String email : bcc) {
                    msg.addRecipient(Message.RecipientType.BCC,
                            new InternetAddress(email));
                }
            }

// Set Subject: header field
            msg.setSubject(subject);

            BodyPart messageBodyPart = new MimeBodyPart();
// Fill the message
            messageBodyPart.setText(body);
            messageBodyPart.setContent(body, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(pathToAttachement);
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setFileName(fds.getName());
            multipart.addBodyPart(messageBodyPart);

            // Send message
            msg.setContent(multipart);
            Transport.send(msg);
            issentMailSuccess = true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return issentMailSuccess;
    }

    private void initializeSessionNormal(String host) {
        // Setup mail server
        this.properties.setProperty("mail.smtp.host", host);

        this.sessionNormal = Session.getDefaultInstance(this.properties);

        //System.out.println("session done");
    }
}
