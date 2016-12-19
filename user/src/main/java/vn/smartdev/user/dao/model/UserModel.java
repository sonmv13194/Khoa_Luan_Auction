package vn.smartdev.user.dao.model;


import org.springframework.format.annotation.DateTimeFormat;
import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


/**
 * Created by levuhuy on 12/14/16.
 */
public class UserModel extends AbstractAuditableEntity<String> implements Serializable {
    private static final long serialVersionUID = 1L;



    private String address;

    //@Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "MM-dd-yyyy")
    private java.sql.Date birthday;

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    private String email;

    public UserModel() {
    }

    private String password;

    private String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserModel(String address, java.sql.Date birthday, String email, String password, String phone, String username, String confirmPassword) {
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.confirmPassword = confirmPassword;
        setId(UUID.randomUUID().toString());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    private String username;

    private String confirmPassword;

}
