package Team2.youngcha.hellospring.domain;

import javax.persistence.*;

@Entity
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "systemID")
    private Long systemID;
    @Column(name = "userID")
    private String userID;
    @Column(name="userPSW")
    private String userPSW;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userPhoneNumber")
    private String userPhoneNumber;

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

    public void printAll(){
        System.out.println("ID : "+userID+"\nPSW : "+userPSW+"\nName : "+userName+"\nPhoneNumber : "+userPhoneNumber);
    }
}