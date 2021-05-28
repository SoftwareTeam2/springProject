package Team2.youngcha.hellospring.domain;

import Team2.youngcha.hellospring.util.BooleanToYNConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Reservation extends Booking {

    @Column(name = "customer_id")
    private String customerID;
    @Column(name = "table_no")
    private String tableNo;
    private String numberOfPeople;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_email")
    private String customerEmail;
    @Convert(converter = BooleanToYNConverter.class)
    private Boolean hasCar;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime = LocalDateTime.now();
    transient DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
    private String nowString = arrivalTime.format(dateTimeFormatter);

    public String getNowString() {
        return nowString;
    }

    public void setNowString(String nowString) {
        this.nowString = nowString;
    }

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


    public Boolean getHasCar() {
        return hasCar;
    }

    public void setHasCar(Boolean hasCar) {
        this.hasCar = hasCar;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }


}
