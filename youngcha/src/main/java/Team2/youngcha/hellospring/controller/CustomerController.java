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

    @GetMapping("/customers/new")
    public String createForm() {
        return "SignUp";
    }

    @PostMapping("/customers/new")
    public String create(CustomerForm form) {
        Customer customer = new Customer();
        customer.setCid(form.getCid());
        customer.setEmail(form.getEmail());
        customer.setEmailReceive(CustomerService.SToBConvert(form.getEmailReceiveYn()));
        customer.setGender(form.getGender());
        customer.setName(form.getName());
        customer.setMessageReceive(CustomerService.SToBConvert(form.getSmsReceiveYn()));
        customer.setPsw(form.getPsw());
        customer.setPhoneNumber(form.getPhoneNumber());

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
        return "Login";
    }

    @PostMapping("/customers/login")
    public String logIn(HttpSession session, LogInForm form) {
        if (customerService.LogIn(form.getUserID(), form.getUserPW())) {
            if (customerService.isAdmin(form.getUserID()))
                session.setAttribute("admin", true);
            else session.setAttribute("admin", false);
            session.setAttribute("loginCheck", true);
            session.setAttribute("userID", form.getUserID());
            return "redirect:/";
        } else return "Login";
    }

    @GetMapping("/customers/logout")
    public String logOut(HttpSession session) {
        session.setAttribute("loginCheck", false);
        session.setAttribute("userID", null);

        return "redirect:/";
    }

    @GetMapping("/customers/findID")
    public String findID(){
        return "FindID";
    }

    @GetMapping("/customers/findPW")
    public String findPW(){
        return "FindPW";
    }

}