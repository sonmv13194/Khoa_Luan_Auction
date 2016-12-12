package vn.smartdev.product.manager;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * Created by Nhat on 12/12/2016.
 */
@Service
public class SendEmailServicesImpl implements SendEmailSevices{
    private Properties properties;
    private String username;
    private String password;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean setProperties(String userName, String password) {
        try {
            this.username = userName;
            this.password = password;
            Properties properties = new Properties();
            properties.put("mail.transport.protocol", "smtp");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.ssl.enable", "true");
            this.properties = properties;
            return true;
        }
        catch (Exception e)
        {
           throw e;
        }

    }
    @Override
    public boolean setMessage(String from, String to, String subject, String body) {
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        //initiazlied message
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            //transport Email
            Transport transport = session.getTransport("smtp");
            transport.connect();
            transport.send(message, message.getAllRecipients());
            transport.close();
            return true;
        }
        catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean sendEmail(String toEmail) {
        String subjectEmail = "Ban da dat hang thanh cong ...!!!";
        String textEmail = "Chung toi se lien he ban truoc khi hang duoc van chuyen...!!!";
        if(toEmail == null)
        {
            return false;
        }
        else
        {
            String username = "nhatnv7192@gmail.com";
            String password ="nhat1234";
            boolean checkProperties = setProperties(username,password);
            boolean setMessage = setMessage(username,toEmail,subjectEmail, textEmail);
            return true;
        }
    }
}
