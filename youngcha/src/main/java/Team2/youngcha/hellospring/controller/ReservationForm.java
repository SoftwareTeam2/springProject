package Team2.youngcha.hellospring.controller;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ReservationForm {
    private String tableNo;
    private String numberOfPeople;
    private String hasCar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    private String startTime;
    private String dishes;
    private String dishCounts;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public String getDishCounts() {
        return dishCounts;
    }

    public void setDishCounts(String dishCounts) {
        this.dishCounts = dishCounts;
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

    public String getHasCar() {
        return hasCar;
    }

    public void setHasCar(String hasCar) {
        this.hasCar = hasCar;
    }

    public void printAll() {
        System.out.println("테이블 번호: "+
                tableNo +"인원수: "+
                numberOfPeople +"자차: "+
                hasCar +"예약날짜: "+
                startDate.toString() +"예약 시간: "+
                startTime +"메뉴: "+
                dishes +"수량: "+
                dishCounts);
    }
}
