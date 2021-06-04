package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Income;
import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/manager")
    public String managerPage() {
        return "Management";
    }

    @GetMapping("/waitList")
    public String lists() {
        return "/waitList";
    }

    @GetMapping("/waitList/getList")
    @ResponseBody
    public List<Reservation> getWaitList() {
        return managerService.callWaitList();
    }

    @PostMapping("/waitList")
    @ResponseBody
    public boolean todo(@RequestBody ReservationForm form) {
            managerService.reservationCountReallocation(form.getCustomerID());
            managerService.rankReallocation(form.getCustomerID());
            LocalDateTime now = managerService.setArrivalTime(form.getCustomerID(), form.getReservationDate());
            managerService.enrollIncome(form.getCustomerID(), form.getDishes(), form.getDishCounts(), now);
            managerService.editSaleCount(form.getCustomerID(), form.getReservationDate());

            return true;
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
    public String createPage() {
        return "tableManage";
    }

    @PostMapping("/manager/tableManage")
    public String tableSetting(@RequestParam(name = "tableList") List<Integer> tableList) {
        managerService.joinTable(tableList);
        return "tableManage";
    }

    @GetMapping("/manager/dishManage")
    public String createDishPage() {
        return "dishManage";
    }

    @PostMapping("/manager/dishManage")
    public String editDishes(@RequestParam(name = "dishInfo") Map<String, String> dishInfo) {
        managerService.editDishes(dishInfo);
        return "dishManage";
    }

    @GetMapping("/manager/Income")
    public String createIncomePage(Model model) {
        List<Income> incomeList = managerService.getIncome();
        model.addAttribute("totalIncome", incomeList);
        model.addAttribute("incomeWithDishAndProfit", managerService.getDishWithProfit(incomeList));
        model.addAttribute("incomeWithDishAndDishCount", managerService.getDishWithCount(incomeList));

        return "StatisticsGraph";
    }
}