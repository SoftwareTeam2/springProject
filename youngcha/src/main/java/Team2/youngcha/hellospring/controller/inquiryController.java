package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.domain.Reservation;
import org.apache.jasper.util.UniqueAttributesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inquiryController {

    private UniqueAttributesImpl model;

    @GetMapping("/inquiry")
    public String showInquiry (Reservation reservation, Customer customer) {
        return "Inquiry";
    }


    @GetMapping("/notInquiry")
    public String notInquiry(){
        return "NotInquiry";
    }
}
