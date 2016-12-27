package vn.smartdev.product.manager;

/**
 * Created by Nhat on 12/12/2016.
 */
public interface SendEmailServices {
    public boolean setProperties(String userName,String password);
    public boolean setMessage(String from,String to,String subject,String body);
    public boolean sendEmail(String toEmail);
}