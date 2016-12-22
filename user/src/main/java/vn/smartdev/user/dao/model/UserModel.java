package vn.smartdev.user.dao.model;


import org.springframework.format.annotation.DateTimeFormat;
import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;
import vn.smartdev.user.dao.validator.Phone;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


/**
 * Created by levuhuy on 12/14/16.
 */
public class UserModel extends AbstractAuditableEntity<String> implements Serializable {
    private static final long serialVersionUID = 1L;


    @NotNull
    private String address;

    //@Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "MM-dd-yyyy")
    @NotNull
    private java.sql.Date birthday;

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    @NotNull

    private String email;

    UserModel() {
    }

    @NotNull
    @Size(min = 5, max = 30)
    private String username;

    @NotNull

    private String confirmPassword;

    @NotNull
    @Size(min = 5, max = 30)
    private String password;

    @NotNull
    @Phone
    private String phone;
    @Pattern(regexp="^[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}$")

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



}
