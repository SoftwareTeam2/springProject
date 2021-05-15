package Team2.youngcha.hellospring.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class WalkIn extends Booking{

    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:MM-ss") @Column(name = "walkInDate")
    private LocalDateTime walkInDate;

    public LocalDateTime getWalkInDate() {
        return walkInDate;
    }

    public void setWalkInDate(LocalDateTime walkInDate) {
        this.walkInDate = walkInDate;
    }
}
