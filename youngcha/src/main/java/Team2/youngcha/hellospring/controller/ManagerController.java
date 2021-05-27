package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.service.ManagerService;
import org.springframework.stereotype.Controller;
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
    public String tableSetting(@RequestParam(name = "tableCount") Integer tableCount){

        return "";
    }
}
