package Team2.youngcha.hellospring.controller;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ReservationForm {
    private String customerID;
    private int tableNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm:ss")
    private LocalDateTime reservationDate;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
}
