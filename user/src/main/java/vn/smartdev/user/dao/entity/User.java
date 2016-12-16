package vn.smartdev.user.dao.entity;

import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the user database table.
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends AbstractAuditableEntity<String> implements Serializable {
    private static final long serialVersionUID = 1L;


    private String address;

    //@Temporal(TemporalType.DATE)
    private Date birthday;


    private String email;

    private String password;

    private String phone;

    public User(String username) {
        this.username = username;
    }


    private String username;

    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "account_non_expired")
    private boolean accountNonExpired;
    @Column(name = "account_non_locked")
    private boolean accountNonLocked;
    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    //bi-directional many-to-many association to Role
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinTable(
            name = "role_user"
            , joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")
    }

            , inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")
    }
    )
    private List<Role> roles;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
        setId(UUID.randomUUID().toString());
    }

    public User(String address, Date birthday, String email, String password, String phone, String huy, boolean enabled, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, Role admin) {
        setId(UUID.randomUUID().toString());
    }

    public User(String address, Date birthday, String email, String password, String phone,
                String username) {
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.username = username;
        setId(UUID.randomUUID().toString());
    }

    public java.sql.Date getBirthday() {
        return birthday;
    }


    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }
}