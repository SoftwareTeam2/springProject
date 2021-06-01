package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/manager/tableManage")
    public String createPage(){
        return "tableManage";
    }

    @PostMapping("/manager/tableManage")
    public String tableSetting(@RequestParam(name = "tableList") List<Integer> tableList) {
        managerService.joinTable(tableList);
        return "tableManage";
    }

    @GetMapping("/manager/dishManage")
    public String createDishPage(){
        return "dishManage";
    }

    @PostMapping("/manager/dishManage")
    public String editDishes(@RequestParam(name = "dishInfo") Map<String,String> dishInfo) {
        managerService.editDishes(dishInfo);
        return "dishManage";
    }
}
