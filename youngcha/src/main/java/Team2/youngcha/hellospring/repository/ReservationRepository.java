package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Reservation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    private final EntityManager em;

    public ReservationRepository(EntityManager em) {
        this.em = em;
    }

    public Long save(Reservation reservation) {
        //validateDuplicateTable(reservation); // 중복 시간대에 예약인지 확인 나중에는 아예 안보이게 하는 것도 가능??

        em.persist(reservation);
        return reservation.getOid();
    }

    /*
    private void validateDuplicateTable(Reservation reservation) {

        // 로직
    }
    */

    public List<Reservation> findAll() {
        return em.createQuery("select r from Reservation r", Reservation.class)
                .getResultList();
    }

    public List<Reservation> findByCustomerID(String id) {
        List<Reservation> result = em.createQuery("select r from Reservation r where r.customerId=:customerId",Reservation.class)
                .setParameter("customerId", id)
                .getResultList();
        return result;
    }

//    @Modifying(clearAutomatically = true)
//    public String customerArrival(String customerId) {
//        Reservation reservation = em.createQuery("select r from Reservation r where r.customerId=:customerId", Reservation.class)
//                .setParameter("customerId", customerId)
//                .getSingleResult();
//        reservation.setArrivalTime();
//        return reservation.getArrivalTime().toString();
//    }

    @Modifying(clearAutomatically = true)
    public Long tableReallocation(Long oid,String tableNo) {
        Reservation reservation = em.find(Reservation.class, oid);
        reservation.setTableNo(tableNo);
        return reservation.getOid();
    }

    @Modifying(clearAutomatically = true)
    public void cancelReservation(Long oid){
        Optional<Reservation> reservation = Optional.ofNullable(em.find(Reservation.class, oid));
        reservation.ifPresent(selectedReservation ->{em.remove(selectedReservation);});
    }
}
