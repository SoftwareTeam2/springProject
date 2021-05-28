package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
