package Team2.youngcha.hellospring.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
public class Reservation extends Booking {

    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;
    @Column(name = "customer_id")
    private String customerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
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

    @PreUpdate
    public void setArrivalTime() {
        this.arrivalTime = LocalDateTime.now();
    }
}
