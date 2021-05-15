package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
