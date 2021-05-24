package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.WalkIn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class WalkInRepository {
    private final EntityManager em;

    public WalkInRepository(EntityManager em) {
        this.em = em;
    }

    public Long save(WalkIn walkIn) {
        //validateDuplicateTable(reservation); // 중복 시간대에 예약인지 확인 나중에는 아예 안보이게 하는 것도 가능??

        em.persist(walkIn);
        return walkIn.getOid();
    }

    /*
    private void validateDuplicateTable(Reservation reservation) {

        // 로직
    }
    */

    public List<WalkIn> findAll() {
        return em.createQuery("select w from WalkIn w", WalkIn.class)
                .getResultList();
    }

    public List<WalkIn> findByCustomerID(String id) {
        List<WalkIn> result = em.createQuery("select w from WalkIn w where w.customerId=:customerId",WalkIn.class)
                .setParameter("customerId", id)
                .getResultList();
        return result;
    }
}
