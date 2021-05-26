package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
        return "Reservation";
    }

    @PostMapping("/reservations/new")
    public String createReservation(HttpSession session, ReservationForm reservationForm) {
        Reservation reservation = new Reservation();
        reservation.setCustomerId(String.valueOf(session.getAttribute("userID")));
        reservation.setTableNo(reservationForm.getTableNo());
        reservation.setReservationDate(reservationForm.getReservationDate());

        reservationService.join(reservation);
        return "redirect:/";
    }

    @GetMapping("/reservations/cancel")
    public String lists(HttpSession session, Model model) {
        List<Reservation> reservationList = reservationService.cancel(String.valueOf(session.getAttribute("id")));
        model.addAttribute("reservationList", reservationList);
        return "booking/CancelReservation";
    }

    @PostMapping("/reservations/cancel")
    public String cancelReservation(@RequestParam(name = "cancelOid") Long oid) {
        reservationService.cancel(oid);
        return "redirect:/";
    }

    @GetMapping("/reservations/arrival")
    public String arrival(Model model) {
        List<Reservation> reservations = reservationService.listsReservation();
        model.addAttribute("reservations", reservations);
        return "booking/ListTodayReservation";
    }

    @PostMapping("/reservations/arrival")
    public String setArrival(@RequestParam(name = "customerId") String id, Model model) {
        reservationService.customerArrival(id);
        return "redirect:/";
    }

    @GetMapping("/reservations/reallocate")
    public String createReallocationForm(HttpSession session, Model model) {
        List<Reservation> reservationList = reservationService.listReservationByCustomerId(String.valueOf(session.getAttribute("id")));
        model.addAttribute("reservations", reservationList);
        return "/booking/ReallocationList";
    }

    @PostMapping("/reservations/reallocate")
    public String reallocateTable(@RequestParam(name = "oid") Long oid) {
        System.out.println(oid);
        reservationService.tableReallocation(oid, 4);
        return "redirect:/";
    }
}