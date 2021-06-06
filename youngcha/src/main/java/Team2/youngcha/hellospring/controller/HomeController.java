package Team2.youngcha.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session){
        System.out.println(String.valueOf(session.getAttribute("userID")));
        return "MainWeb";
    }
}