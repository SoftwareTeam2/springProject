package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Income;
import Team2.youngcha.hellospring.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "MainWeb";
    }
    private final CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/Menu")
    public String home(Model model){
        List<Income> incomeList = customerService.getFavoriteMenu();
        model.addAttribute("incomeList", incomeList);

        return "Menu";
    }
}