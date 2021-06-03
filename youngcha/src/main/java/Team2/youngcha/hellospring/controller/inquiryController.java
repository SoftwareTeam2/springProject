package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.repository.CustomerRepository;
import Team2.youngcha.hellospring.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class inquiryController {
    @Autowired
    private ReservationRepository reservationRepository;

    public inquiryController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping("/inquiry")
    public String list(Model model){
        List<Reservation> rlist  = reservationRepository.findAll();
        model.addAttribute("inqList",rlist);

        return "Inquiry";
    }
}