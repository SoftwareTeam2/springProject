package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository<T extends Booking> extends JpaRepository<Booking,Long> {
}
