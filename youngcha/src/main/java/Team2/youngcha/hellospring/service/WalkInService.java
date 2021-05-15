package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.WalkIn;
import Team2.youngcha.hellospring.repository.WalkInRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalkInService {
    private final WalkInRepository walkInRepository;

    public WalkInService(WalkInRepository walkInRepository) {
        this.walkInRepository = walkInRepository;
    }

    public Long join(WalkIn walkIn) {
        //validateDuplicateTable(reservation); // 중복 시간대에 예약인지 확인 나중에는 아예 안보이게 하는 것도 가능??

        walkInRepository.save(walkIn);
        return walkIn.getOid();
    }

    /*
    private void validateDuplicateTable(Reservation reservation) {
        // 로직
    }
    */

    public List<WalkIn> listsWalkIn() {
        return walkInRepository.findAll();
    }
}
