package Team2.youngcha.hellospring.controller;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class WalkInForm {
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm:ss")
    private LocalDateTime walkInDate;
    private int tableNo;

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
}
