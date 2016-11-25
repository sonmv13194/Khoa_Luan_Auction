package vn.smartdev.user.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.java.training.core.usertype.Blob2List;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.java.training.core.jpa.auditing.AbstractAuditableEntity;

@Entity
@Table(name = "password_history")
@TypeDef(typeClass = Blob2List.class, name = "serializedList")
public class PasswordHistory extends AbstractAuditableEntity<String> {


    private static final long serialVersionUID = 5690492304821834950L;
    @OneToOne()
    @JoinColumn( name = "id",insertable = false, updatable = false)
    private User user;

    private Integer size = 5;
    @Column(name = "failed_login_attempts")
    private Integer failedLoginAttempts = 0;
    @Column(name = "last_password_failed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordFailed;
    @Column(name = "old_passwords")
    @Type(type = "serializedList")
    private List<String> oldPasswords = new ArrayList<>();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_password_changed")
    private Date lastPasswordChanged;

    @Override
    public String toString() {
        return "PasswordHistory{" +
                "userId='" + getId() + '\'' +
                ", size=" + size +
                ", failedLoginAttempts=" + failedLoginAttempts +
                ", lastPasswordFailed=" + lastPasswordFailed +
                ", lastPasswordChanged=" + lastPasswordChanged +
                ", oldPasswords=" + oldPasswords +
                '}';
    }

    public void increaseFailedLoginAttempts() {
        this.failedLoginAttempts++;
    }

    public void resetFailedLoginAttempts() {
        this.failedLoginAttempts = 0;
    }

    public void addPassword(String currentPassword) {
        this.oldPasswords.add(currentPassword);
        if (this.oldPasswords.size() > size) {
            this.oldPasswords.remove(0);
        }
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public Date getLastPasswordFailed() {
        return lastPasswordFailed;
    }

    public void setLastPasswordFailed(Date lastPasswordFailed) {
        this.lastPasswordFailed = lastPasswordFailed;
    }

    public List<String> getOldPasswords() {
        return oldPasswords;
    }

    public void setOldPasswords(List<String> oldPasswords) {
        this.oldPasswords = oldPasswords;
    }

    public Date getLastPasswordChanged() {
        return lastPasswordChanged;
    }

    public void setLastPasswordChanged(Date lastPasswordChanged) {
        this.lastPasswordChanged = lastPasswordChanged;
    }

}
