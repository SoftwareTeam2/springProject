package Team2.youngcha.hellospring.controller;

public class CustomerForm {
    private String userID;
    private String userPSW;
    private String userName;
    private String userPhoneNumber;

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
