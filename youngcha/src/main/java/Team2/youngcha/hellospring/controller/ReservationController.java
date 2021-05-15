package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public String lists(Model model) {
        List<Reservation> reservations = reservationService.listsReservation();
        model.addAttribute("reservations", reservations);
        return "/booking/ListReservation";
    }

    @GetMapping("/reservations/new")
    public String createReservationForm() {
        return "booking/newReservation";
    }

    @PostMapping("reservations/new")
    public String createReservation(ReservationForm reservationForm) {
        Reservation reservation = new Reservation();
        reservation.setCustomerId(reservationForm.getCustomerID());
        reservation.setTableNo(reservationForm.getTableNo());
        reservation.setReservationDate(reservationForm.getReservationDate());

        reservationService.join(reservation);
        return "redirect:/";
    }


}