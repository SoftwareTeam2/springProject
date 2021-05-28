package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import Team2.youngcha.hellospring.domain.WalkIn;
import Team2.youngcha.hellospring.repository.WalkInRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class WalkInService {
    private final WalkInRepository walkInRepository;

    public WalkInService(WalkInRepository walkInRepository) {
        this.walkInRepository = walkInRepository;
    }

    public Long join(WalkIn walkIn) {
        walkInRepository.save(walkIn);
        return walkIn.getOid();
    }

    public List<Boolean> validateDuplicateTable(int guestCount) {
        List<Reservation> reservationList = walkInRepository.findByResDate(LocalDateTime.now());
        List<TableInfo> tables = walkInRepository.getTables();
        Boolean[] validAry = new Boolean[tables.size()];
        Arrays.fill(validAry,true);
        for(Reservation reservation : reservationList){
            validAry[Integer.getInteger(reservation.getTableNo())-1] = false;
        }

        validateGuestCountTable(guestCount,tables,validAry);
        return Arrays.asList(validAry);
    }
    private Boolean[] validateGuestCountTable(int guestCount, List<TableInfo> tables, Boolean[] validAry){
        for(TableInfo tableInfo : tables){
            if(tableInfo.getPeople()<guestCount){
                validAry[tableInfo.getTableNumber()-1] = false;
            }
        }
        return validAry;
    }

    public List<WalkIn> listsWalkIn() {
        return walkInRepository.findAll();
    }

    public List<Boolean> checkTable(int guestCount){
        return validateDuplicateTable(guestCount);
    }
}
