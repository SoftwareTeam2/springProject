package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class inquiryController {
    @Autowired
    private ReservationService reservationService;

    public inquiryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping("/inquiry")
    public String list(Model model, HttpSession session) {
        String userID = String.valueOf(session.getAttribute("userID"));
        List<Reservation> resultList = reservationService.findResByCid(userID);
        model.addAttribute("inqList", resultList);

        return "CustomerInquiry";
    }

    @PostMapping("/inquiry")
    public String delete(@RequestParam(name = "resDate") LocalDateTime resDate) {
        System.out.println("enter");
        //reservationService.cancelReservation(customerID);
        return "redirect:/inquiry";
    }
}