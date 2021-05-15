package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.WalkIn;
import Team2.youngcha.hellospring.service.WalkInService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WalkInController {
    private final WalkInService walkInService;

    public WalkInController(WalkInService walkInService) {
        this.walkInService = walkInService;
    }

    @GetMapping("/walkIn/new")
    public String createWalkInForm(){
        return "booking/newWalkIn";
    }

    @PostMapping("/walkIn/new")
    public String createWalkIn(WalkInForm walkInForm) {
        WalkIn walkIn = new WalkIn();
        walkIn.setWalkInDate(walkInForm.getWalkInDate());
        walkIn.setTableNo(walkInForm.getTableNo());

        walkInService.join(walkIn);
        return "redirect:/";

    }

    @GetMapping("/walkIn")
    public String lists(Model model){
        List<WalkIn> walkIns = walkInService.listsWalkIn();
        model.addAttribute("walkIns", walkIns);
        return "/booking/ListWalkIn";
    }
}
