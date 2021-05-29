package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import Team2.youngcha.hellospring.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Long join(Reservation reservation) {
        //validateDuplicateTable(reservation); // 중복 시간대에 예약인지 확인 나중에는 아예 안보이게 하는 것도 가능??

        reservationRepository.save(reservation);
        return reservation.getOid();
    }

    /*
    private void validateDuplicateTable(Reservation reservation) {

        // 로직
    }
    */

    public List<Reservation> listsReservation() {
        return reservationRepository.findAll();
    }

    public List<Reservation> cancel(String id) {
        List<Reservation> result = reservationRepository.findByCustomerID(id);
        return result;
    }

//    public String customerArrival(String id) {
//        return reservationRepository.customerArrival(id);
//    }

    public Long tableReallocation(Long oid,String tableNo) {
        return reservationRepository.tableReallocation(oid,tableNo);

    }

    public List<Reservation> listReservationByCustomerId(String id){
        List<Reservation> byCustomerID = reservationRepository.findByCustomerID(id);
        return byCustomerID;
    }

    public static Boolean SToBConvert(String string) {
        return (string.equals("Y")) ? true : false;
    }

    public void cancel(Long oid){
        reservationRepository.cancelReservation(oid);
    }

    public List<Boolean> findValidTables(String cid, String reservationDate,String guestCount){
        LocalDateTime parse = LocalDateTime.parse(reservationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm"));
        List<Reservation> resList = reservationRepository.findResByResDate(parse.minusHours(2), parse.plusHours(2));
        List<Boolean> booleans = validateDuplicateTable(resList, guestCount);

        return booleans;
    }

    private Boolean[] validateGuestCountTable(String guestCount, List<TableInfo> tables, Boolean[] validAry) {
        for (TableInfo tableInfo : tables) {
            if (tableInfo.getPeople() < Integer.valueOf(guestCount)) {
                validAry[tableInfo.getTableNumber() - 1] = false;
            }
        }
        return validAry;
    }

    public List<Boolean> validateDuplicateTable(List<Reservation> reservationList, String guestCount) {
        List<TableInfo> tables = reservationRepository.getTables();
        Boolean[] validAry = new Boolean[tables.size()];
        Arrays.fill(validAry, true);
        for (Reservation reservation : reservationList) {
            validAry[Integer.valueOf(reservation.getTableNo()) - 1] = false;
        }
        validateGuestCountTable(guestCount, tables, validAry);
        return Arrays.asList(validAry);
    }

    public Boolean updateReservation(String cid, String sourceDate, String destDate, String guestCount, String tableNo){
        LocalDateTime source = LocalDateTime.parse(sourceDate, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm"));
        LocalDateTime dest = LocalDateTime.parse(destDate, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm"));
        Optional<Reservation> result = reservationRepository.findResByResDateAndCid(cid, source);
        if(result.isPresent()) {
            return reservationRepository.update(result.get(), dest, guestCount, tableNo);
        }
        return false;
    }
}
