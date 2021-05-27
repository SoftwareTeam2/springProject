package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.TableInfo;
import Team2.youngcha.hellospring.repository.ManagerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public int setTable(int tableCount){
        int tableNo=0;
        for(int i=0;i<tableCount;i++){
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableNumber(i+1);
            tableInfo.setPeople(4);
            tableInfo.setPlaces(1);
            tableNo = managerRepository.saveTableInfo(tableInfo);
        }
        return tableNo;
    }
}
