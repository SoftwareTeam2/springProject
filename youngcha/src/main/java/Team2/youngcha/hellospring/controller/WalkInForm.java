package Team2.youngcha.hellospring.controller;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class WalkInForm {
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
    private LocalDateTime walkInDate;
    private int tableNo;
    private int guestCount;

    public LocalDateTime getWalkInDate() {
        return walkInDate;
    }

    public void setWalkInDate(LocalDateTime walkInDate) {
        this.walkInDate = walkInDate;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }
}
