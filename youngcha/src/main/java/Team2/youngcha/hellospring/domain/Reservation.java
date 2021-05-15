package Team2.youngcha.hellospring.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Reservation extends Booking {


    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:MM-ss")
    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;
    @Column(name = "customer_id")
    private String customerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:MM-ss")
    @Column(name = "arrival_time", columnDefinition = "datetime default null")
    private LocalDateTime arrivalTime;

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
