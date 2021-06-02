package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    private final EntityManager em;

    public ReservationRepository(EntityManager em) {
        this.em = em;
    }

    public Long save(Reservation reservation) {
        em.persist(reservation);
        return reservation.getOid();
    }

    public List<Reservation> findAll() {
        return em.createQuery("select r from Reservation r where :now < r.reservationDate", Reservation.class)
                .setParameter("now",LocalDateTime.now())
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

    public Optional<Reservation> findResByResDateAndCid(String cid, LocalDateTime resDate){
        Reservation result = em.createQuery("select r from Reservation r where r.customerID=:cid and r.reservationDate=:resDate", Reservation.class)
                .setParameter("cid", cid)
                .setParameter("resDate", resDate)
                .getSingleResult();
        return Optional.ofNullable(result);
    }

    public List<Reservation> findResByResDate(LocalDateTime startRange, LocalDateTime endRange){
        List<Reservation> resultList = em.createQuery("select r from Reservation r where r.reservationDate between :startRange and :endRange", Reservation.class)
                .setParameter("startRange", startRange)
                .setParameter("endRange", endRange)
                .getResultList();

        return resultList;
    }

    public List<TableInfo> getTables(){
        return em.createQuery("select t from TableInfo t", TableInfo.class)
                .getResultList();
    }

    @Modifying(clearAutomatically = true)
    public Boolean update(Reservation reservation,LocalDateTime resDate, String guestCount, String tableNo) {
        try {
            reservation.setReservationDate(resDate);
            reservation.setTableNo(tableNo);
            reservation.setNumberOfPeople(guestCount);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Modifying(clearAutomatically = true)
    public void reservationCountReallocation(String ID){
        Customer customer = em.find(Customer.class, ID);
        customer.setReservation_count(customer.getReservation_count()+1);
    }
}