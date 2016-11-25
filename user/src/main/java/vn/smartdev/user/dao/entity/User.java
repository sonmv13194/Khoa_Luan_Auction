package vn.smartdev.user.dao.entity;

import com.java.training.core.jpa.auditing.AbstractAuditableEntity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends AbstractAuditableEntity<String> {


    private static final long serialVersionUID = 5600408164912924646L;

    public enum Gender {
        OTHER, MALE, FEMALE
    }


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private PasswordHistory passwordHistory;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "day_of_birth")
    private Date dayOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.OTHER;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "phone_number2")
    private String phoneNumber2;
    @Column(name = "phone_number3")
    private String phoneNumber3;
    @Column(name = "email")
    private String email;
    @Column(name = "email2")
    private String email2;
    @Column(name = "email3")
    private String email3;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "phone_code")
    private String phoneCode;
    private String languageCode;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked = true;
    private boolean enabled = false;
    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired = true;
    @Column(name = "account_non_expired")
    private boolean accountNonExpired = true;


    public User() {
        this.setId(UUID.randomUUID().toString());
        passwordHistory = new PasswordHistory();
        passwordHistory.setId(this.getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + getId() + '\'' +
                ", passwordHistory=" + passwordHistory +
                ", username='" + username + '\'' +
                ", password='******'" +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", phoneNumber3='" + phoneNumber3 + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", accountNonLocked=" + accountNonLocked +
                ", enabled=" + enabled +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", accountNonExpired=" + accountNonExpired +
                ", auditing=" + super.toString() +
                '}';
    }


    public PasswordHistory getPasswordHistory() {
        return passwordHistory;
    }

    public void setPasswordHistory(PasswordHistory passwordHistory) {
        this.passwordHistory = passwordHistory;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getPhoneNumber3() {
        return phoneNumber3;
    }

    public void setPhoneNumber3(String phoneNumber3) {
        this.phoneNumber3 = phoneNumber3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }


}
