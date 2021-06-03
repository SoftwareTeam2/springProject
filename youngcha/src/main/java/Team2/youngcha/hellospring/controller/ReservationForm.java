package Team2.youngcha.hellospring.controller;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ReservationForm {
    private String customerID;
    private String tableNo;
    private String numberOfPeople;
    private String customerName;
    private String customerEmail;
    private String hasCar;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
    private LocalDateTime reservationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
    private LocalDateTime arrivalTime = LocalDateTime.now();

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerID(){
        return customerID;
    }

    public void setCustomerID(String customerID){
        this.customerID = customerID;
    }


    public String getHasCar() {
        return hasCar;
    }

    public void setHasCar(String hasCar) {
        this.hasCar = hasCar;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
}
