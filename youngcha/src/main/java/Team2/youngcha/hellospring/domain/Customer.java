package Team2.youngcha.hellospring.domain;

import Team2.youngcha.hellospring.util.BooleanToYNConverter;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemID;
    @Column(name = "user_id")
    private String userID;
    @Column(name = "user_psw")
    private String userPSW;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_phone_number")
    private String userPhoneNumber;
    @Convert(converter = BooleanToYNConverter.class) @Column(name = "is_admin",columnDefinition = "boolean default false")
    private boolean isAdmin;

    public Long getSystemID() {
        return systemID;
    }

    public void setSystemID(Long systemID) {
        this.systemID = systemID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPSW() {
        return userPSW;
    }

    public void setUserPSW(String userPSW) {
        this.userPSW = userPSW;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}