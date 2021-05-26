package Team2.youngcha;

import Team2.youngcha.hellospring.MainApplication;
import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.repository.ReservationRepository;
import Team2.youngcha.hellospring.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = MainApplication.class)
@Transactional
class YoungchaApplicationTests {

	@Autowired
	ReservationService reservationService;
	@Autowired
	ReservationRepository reservationRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void compareLocalDateTime(){
		// given
		LocalDateTime parse = LocalDateTime.parse("2020-10-25T13:25:30");

		// when
		boolean before = parse.isBefore(LocalDateTime.now());

		// then
		assertThat(before).isEqualTo(true);
	}

	@Test
	void testDuplicateReservationDate(){

		// given
		Reservation reservation = new Reservation();
		reservation.setReservationDate(LocalDateTime.of(2013,11,25,16,50));
		reservation.setTableNo(3);
		reservation.setCustomerId("go");

		// when
		reservationService.join(reservation);

		// then
		IllegalStateException e = assertThrows(IllegalStateException.class,()->reservationService.join(reservation));
		assertThat(e.getMessage()).isEqualTo("존재하는게 맞음");
	}

}
