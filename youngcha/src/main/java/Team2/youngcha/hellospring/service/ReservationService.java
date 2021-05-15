package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final BookingRepository bookingRepository;

    public ReservationService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Long join(Reservation reservation) {
        //validateDuplicateTable(reservation); // 중복 시간대에 예약인지 확인 나중에는 아예 안보이게 하는 것도 가능??

        bookingRepository.save(reservation);
        return reservation.getOid();
    }

    /*
    private void validateDuplicateTable(Reservation reservation) {

        // 로직
    }
    */

    public List<Reservation> listsReservation() {
        return bookingRepository.findAll();
    }

    public String cancel(Reservation reservation) {
        Optional<Reservation> result = bookingRepository.findById(reservation.getOid());
        if(result.isPresent()){
            bookingRepository.delete(reservation);
            return "Reservation Canceled";
        } else return "There is no reservation with that information";
    }

    public Long customerArrival(Long id) {
        return null;
    }

    public Long tableReallocation(Long id) {
        return null;
    }
}
