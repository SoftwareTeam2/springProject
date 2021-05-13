package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers/new")
    public String createForm(){
        return "customers/createCustomerForm";
    }

    @PostMapping("customers/new")
    public String create(CustomerForm form){
        Customer customer = new Customer();
        customer.setUserName(form.getUserName());
        customer.setUserID(form.getUserID());
        customer.setUserPSW(form.getUserPSW());
        customer.setUserPhoneNumber(form.getUserPhoneNumber());
        //member.printAll();
        customerService.join(customer);

        return "redirect:/";
    }

    @GetMapping("/customers")
    public String list(Model model){
        List<Customer> customers = customerService.findMember();
        model.addAttribute("customers", customers);
        return "customers/customerList";
    }
    @GetMapping("/customers/login")
    public String enterInfo(){
        return "customers/customerLogin";
    }

    @PostMapping("/customers/login")
    @ResponseBody
    public String logIn(LogInForm form){
        System.out.println(form.getUserID());
        System.out.println(form.getUserPSW());
        return customerService.LogIn(form.getUserID(), form.getUserPSW());
    }
}
