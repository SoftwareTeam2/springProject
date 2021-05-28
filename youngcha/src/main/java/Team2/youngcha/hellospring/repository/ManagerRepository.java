package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ManagerRepository {
    private final EntityManager entityManager;

    public ManagerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public int saveTableInfo(TableInfo tableInfo) {
        entityManager.persist(tableInfo);
        TableInfo tableNo = entityManager.createQuery("select t from TableInfo t where t.tableNumber=:tableNo", TableInfo.class)
                .setParameter("tableNo", tableInfo.getTableNumber())
                .getSingleResult();

        return tableNo.getTableNumber();
    }

    public Optional<Reservation> getReservationByCidOnToday(String cid, LocalDateTime startRange, LocalDateTime endRange){
        try {
            Reservation result = entityManager.createQuery("select r from Reservation r where r.reservationDate between :startRange and :endRange and r.customerID=:cid", Reservation.class)
                    .setParameter("cid", cid)
                    .setParameter("startRange", startRange)
                    .setParameter("endRange", endRange)
                    .getSingleResult();
            return Optional.of(result);
        } catch(EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Modifying(clearAutomatically = true)
    public void changeTableNo(Reservation reservation, String tableNo){
        reservation.setTableNo(tableNo);
    }

    public List<Reservation> findByResDate(LocalDateTime localDateTime) {
        List<Reservation> result = entityManager.createQuery("select r from Reservation r where r.reservationDate between :minusHour and :plusHour", Reservation.class)
                .setParameter("minusHour", localDateTime.minusHours(2))
                .setParameter("plusHour", localDateTime.plusHours(2))
                .getResultList();
        System.out.println(localDateTime.minusHours(2));
        System.out.println(localDateTime.plusHours(2));
        System.out.println(result.size());
        return result;
    }

    public List<TableInfo> getTables(){
        return entityManager.createQuery("select t from TableInfo t", TableInfo.class)
                .getResultList();
    }
}
