package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers/new")
    public String createForm() {
        return "customers/createCustomerForm";
    }

    @PostMapping("customers/new")
    public String create(CustomerForm form) {
        Customer customer = new Customer();
        customer.setUserName(form.getUserName());
        customer.setUserID(form.getUserID());
        customer.setUserPSW(form.getUserPSW());
        customer.setUserPhoneNumber(form.getUserPhoneNumber());

        customerService.join(customer);

        return "redirect:/";
    }

    @GetMapping("/customers")
    public String list(Model model) {
        List<Customer> customers = customerService.findMember();
        model.addAttribute("customers", customers);
        return "customers/customerList";
    }

    @GetMapping("/customers/login")
    public String enterInfo() {
        return "customers/customerLogin";
    }

    @PostMapping("/customers/login")
    public String logIn(HttpSession session, LogInForm form) {
        if (customerService.LogIn(form.getUserID(), form.getUserPSW())) {
            if (customerService.isAdmin(form.getUserID()))
                session.setAttribute("admin", true);
            else session.setAttribute("admin", false);
            session.setAttribute("loginCheck", true);
            session.setAttribute("id", form.getUserID());
            return "redirect:/";
        } else return "/customers/customerLogin";
    }

    @GetMapping("/customers/logout")
    public String logOut(HttpSession session) {
        session.setAttribute("loginCheck", false);
        session.setAttribute("id", null);

        return "redirect:/";
    }

}