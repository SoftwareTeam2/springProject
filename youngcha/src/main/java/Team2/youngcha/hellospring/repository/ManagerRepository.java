package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Menu;
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
        return result;
    }

    public List<TableInfo> getTables(){
        return entityManager.createQuery("select t from TableInfo t", TableInfo.class)
                .getResultList();
    }

    public Optional<Menu> isDishAlreadyExists(String dish) {
        try {
            Menu menu = entityManager.find(Menu.class, dish);
            return Optional.of(menu);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    public void saveMenu(Menu dish){
        entityManager.persist(dish);
    }

    @Modifying(clearAutomatically = true)
    public void changeDishPrice(Menu dish, int price) {
        dish.setPrice(price);
    }

    public List<Menu> listMenus() {
        List<Menu> result = entityManager.createQuery("select m from Menu m", Menu.class)
                .getResultList();
        return result;
    }

    public Optional<Menu> getMenuByDish(String dish){
        try {
            Menu result = entityManager.find(Menu.class, dish);
            return Optional.ofNullable(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
