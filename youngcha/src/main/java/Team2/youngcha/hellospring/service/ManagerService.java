package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.Menu;
import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import Team2.youngcha.hellospring.repository.ManagerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public int setTable(int tableCount) {
        int tableNo = 0;
        for (int i = 0; i < tableCount; i++) {
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableNumber(i + 1);
            tableInfo.setPeople(4);
            tableInfo.setPlaces(1);
            tableNo = managerRepository.saveTableInfo(tableInfo);
        }
        return tableNo;
    }

    public Optional<Reservation> findReservationByCidOnToday(String cid) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startRange = now.minusHours(now.getHour());
        LocalDateTime endRange = now.plusHours(24 - now.getHour());

        return managerRepository.getReservationByCidOnToday(cid, startRange, endRange);
    }

    public Boolean changeTable(String cid, String tableNo) {
        Optional<Reservation> result = findReservationByCidOnToday(cid);
        if (result.isPresent()) {
            Reservation reservation = result.get();
            List<Boolean> booleans = validateDuplicateTable(reservation,Integer.valueOf(reservation.getNumberOfPeople()));
            if (booleans.get(Integer.valueOf(tableNo)-1)) {
                managerRepository.changeTableNo(reservation, tableNo);
                return true;
            }
        }
        return false;
    }


    private Boolean[] validateGuestCountTable(int guestCount, List<TableInfo> tables, Boolean[] validAry) {
        for (TableInfo tableInfo : tables) {
            if (tableInfo.getPeople() < guestCount) {
                validAry[tableInfo.getTableNumber() - 1] = false;
            }
        }
        return validAry;
    }

    public List<Boolean> validateDuplicateTable(Reservation targetReservation, int guestCount) {
        List<Reservation> reservationList = managerRepository.findByResDate(targetReservation.getReservationDate());
        List<TableInfo> tables = managerRepository.getTables();
        Boolean[] validAry = new Boolean[tables.size()];
        Arrays.fill(validAry, true);
        for (Reservation reservation : reservationList) {
            validAry[Integer.valueOf(reservation.getTableNo()) - 1] = false;
        }

        validateGuestCountTable(guestCount, tables, validAry);
        return Arrays.asList(validAry);
    }

    public void joinTable(List<Integer> tableList) {
        for (int i = 0; i < tableList.size(); i++) {
            TableInfo newTable = new TableInfo();
            newTable.setTableNumber(i+1);
            newTable.setPeople(tableList.get(i));
            newTable.setPlaces(1);

            managerRepository.saveTableInfo(newTable);
        }
    }

    public void editDishes(Map<String,String> dishInfo) {
        for(String dish : dishInfo.keySet()) {
            Optional<Menu> result = managerRepository.isDishAlreadyExists(dish);
            if(result.isPresent())
                managerRepository.changeDishPrice(result.get(),Integer.valueOf(dishInfo.get(dish)));
            else {
                Menu newMenu = new Menu();
                newMenu.setDish(dish);
                newMenu.setPrice(Integer.valueOf(dishInfo.get(dish)));
                managerRepository.saveMenu(newMenu);
            }
        }
    }
}
