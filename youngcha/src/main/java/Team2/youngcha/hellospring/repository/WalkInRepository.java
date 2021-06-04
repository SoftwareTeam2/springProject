package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import Team2.youngcha.hellospring.domain.WalkIn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
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

    public List<Reservation> findByResDate(LocalDateTime localDateTime) {
        List<Reservation> result = em.createQuery("select r from Reservation r where r.reservationDate between :minusHour and :plusHour", Reservation.class)
                .setParameter("minusHour", localDateTime.minusHours(2))
                .setParameter("plusHour", localDateTime.plusHours(2))
                .getResultList();
        return result;
    }

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

    public List<TableInfo> getTables(){
        return em.createQuery("select t from TableInfo t", TableInfo.class)
                .getResultList();
    }
}
