package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/manager/tableSetting")
    public String tablePage() {
        return "tableSetting";
    }

    @PostMapping("/manager/tableSetting")
    public String tableSetting(@RequestParam(name = "tableCount") Integer tableCount) {

        return "";
    }

    @GetMapping("/manager/tableReallocation")
    public String changeTable(@RequestParam(name = "customerID") String cid, @RequestParam(name = "tableNo") String tableNo, Model model) {
        if (managerService.changeTable(cid, tableNo))
            model.addAttribute("result", true);
        else
            model.addAttribute("result", false);
        return "TodayReservation";
    }
}
