package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.WalkIn;
import Team2.youngcha.hellospring.service.WalkInService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class WalkInController {
    private final WalkInService walkInService;

    public WalkInController(WalkInService walkInService) {
        this.walkInService = walkInService;
    }

    @GetMapping("/walkIn/new")
    public String createWalkInPage(){
        return "WalkIn";
    }

    @GetMapping("/walkIn/guestCount")
    public String receiveGuestCount(){
        return "newWalkIn";
    }

    @PostMapping("/walkIn/validTables")
    @ResponseBody
    public List<Boolean> checkValidTables(@RequestBody WalkInForm walkInForm) {
        return walkInService.checkTable(walkInForm.getGuestCount());
    }

    //@GetMapping("/walkIn/new")
    public String serviceWalkIn(@RequestParam(name = "tableNo") int tableNo, HttpSession session){
        WalkIn walkIn = new WalkIn();
        walkIn.setGuestCount(Integer.getInteger(String.valueOf(session.getAttribute("guestCount"))));
        walkIn.setWalkInDate(LocalDateTime.now());
        walkIn.setTableNo(Integer.toString(tableNo));

        walkInService.join(walkIn);
        return "confirm";
    }

    @GetMapping("/walkIn")
    public String lists(Model model){
        List<WalkIn> walkIns = walkInService.listsWalkIn();
        model.addAttribute("walkIns", walkIns);
        return "/booking/ListWalkIn";
    }

}
