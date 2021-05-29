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

    @GetMapping("/waitList")
    public String lists(Model model) {
        List<Reservation> list= reservationService.listsReservation();
        model.addAttribute("list", list);
        return "/waitList";
    }

    @GetMapping("/reservations/new")
    public String createReservationForm() {
        return "Reservation";
    }

    @PostMapping("/reservations/new")
    public String createReservation(HttpSession session, ReservationForm reservationForm) {
        Reservation reservation = new Reservation();

        reservation.setCustomerID(String.valueOf(session.getAttribute("userID")));
        reservation.setCustomerName(String.valueOf(session.getAttribute("userName")));
        reservation.setCustomerEmail(String.valueOf(session.getAttribute("userEmail")));
        reservation.setTableNo(reservationForm.getTableNo());
        reservation.setNumberOfPeople(reservationForm.getNumberOfPeople());
        reservation.setHasCar(ReservationService.SToBConvert(reservationForm.getHasCar()));
        reservation.setReservationDate(reservationForm.getReservationDate());
        reservation.setNowString(reservationForm.getNowString());

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

//    @PostMapping("/reservations/arrival")
//    public String setArrival(@RequestParam(name = "customerId") String id, Model model) {
//        reservationService.customerArrival(id);
//        return "redirect:/";
//    }

    @GetMapping("/reservations/reallocate")
    public String createReallocationForm(HttpSession session, Model model) {
        List<Reservation> reservationList = reservationService.listReservationByCustomerId(String.valueOf(session.getAttribute("id")));
        model.addAttribute("reservations", reservationList);
        return "/booking/ReallocationList";
    }

    @PostMapping("/reservations/reallocate")
    public String reallocateTable(@RequestParam(name = "oid") Long oid) {
        System.out.println(oid);
        reservationService.tableReallocation(oid, "4");
        return "redirect:/";
    }

    @GetMapping("/reservations/update")
    public String forwardToUpdatePage() {
        return "updateReservation";
    }

    @PostMapping("/reservations/update")
    public String returnValidTables(@RequestParam(name = "customerID") String cid,
                                    @RequestParam(name = "sourceDate") String sourceDate,
                                    @RequestParam(name = "destDate") String destDate,
                                    @RequestParam(name = "guestCount") String guestCount,
                                    Model model,
                                    HttpSession session) {
        List<Boolean> validTables = reservationService.findValidTables(cid, sourceDate, guestCount);
        session.setAttribute("cid",cid);
        session.setAttribute("sourceDate",sourceDate);
        session.setAttribute("destDate",destDate);
        session.setAttribute("guestCount",guestCount);
        model.addAttribute("tableInfo", validTables);
        return "selectTable";
    }

    @GetMapping("/reservations/selectTable")
    public String updateReservation(@RequestParam(name = "tableNo") String tableNo, HttpSession session, Model model){
        String cid = String.valueOf(session.getAttribute("cid"));
        String sourceDate = String.valueOf(session.getAttribute("sourceDate"));
        String destDate = String.valueOf(session.getAttribute("destDate"));
        String guestCount = String.valueOf(session.getAttribute("guestCount"));
        model.addAttribute("result",reservationService.updateReservation(cid,sourceDate,destDate,guestCount,tableNo));
        return "UpdateResResultPage";
    }
}