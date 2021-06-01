package Team2.youngcha;

import Team2.youngcha.hellospring.MainApplication;
import Team2.youngcha.hellospring.domain.Menu;
import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import Team2.youngcha.hellospring.repository.ManagerRepository;
import Team2.youngcha.hellospring.repository.ReservationRepository;
import Team2.youngcha.hellospring.repository.WalkInRepository;
import Team2.youngcha.hellospring.service.ManagerService;
import Team2.youngcha.hellospring.service.ReservationService;
import Team2.youngcha.hellospring.service.WalkInService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest(classes = MainApplication.class)
@Transactional
class YoungchaApplicationTests {

    @Autowired
    EntityManager em;

    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ManagerService managerService;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    WalkInService walkInService;

    @Autowired
    WalkInRepository walkInRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void compareLocalDateTime() {
        // given
        LocalDateTime parse = LocalDateTime.parse("2020-10-25T13:25:30");

        // when
        boolean before = parse.isBefore(LocalDateTime.now());

        // then
        assertThat(before).isEqualTo(true);
    }

    @Test
    void testDuplicateReservationDate() {

        // given
        Reservation reservation = new Reservation();
        reservation.setReservationDate(LocalDateTime.of(2013, 11, 25, 16, 50));
        reservation.setTableNo("3");
        reservation.setCustomerID("go");

        // when
        reservationService.join(reservation);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> reservationService.join(reservation));
        assertThat(e.getMessage()).isEqualTo("존재하는게 맞음");
    }

    @Test
    @Commit
    void testTableCreation() {
        int tableCount = 5;

        int result = managerService.setTable(tableCount);

        assertThat(result).isEqualTo(tableCount);
    }

    @Test
    void 워크인가능테이블() {

        // given, when
        List<Boolean> booleans = walkInService.checkTable(3);

        // then
        assertThat(Collections.frequency(booleans, false)).isEqualTo(1);
    }

    @Test
    void 예약테이블변경테스트됨() {

        // given, when
        Boolean hyeonho9877 = managerService.changeTable("hyeonho9877", "3");

        // then
        assertThat(hyeonho9877).isEqualTo(true);
    }

    @Test
    void 예약테이블변경테스트안됨() {
        Boolean hyeonho9877 = managerService.changeTable("hyeonho9877", "2");

        // then
        assertThat(hyeonho9877).isEqualTo(false);
    }

    @Test
    void 유효테이블개수맞음() {

        // given, when
        List<Boolean> hyeonho9877 = reservationService.findValidTables("hyeonho9877", "2021-05-29-13:20", "3");

        // then
        assertThat(Collections.frequency(hyeonho9877,true)).isEqualTo(4);
    }

    @Test
    void 유효테이블자리맞음(){
        // given, when
        List<Boolean> hyeonho9877 = reservationService.findValidTables("hyeonho9877", "2021-05-29-13:20", "3");

        // then
        assertThat(hyeonho9877.get(1)).isEqualTo(false);
    }

    @Test
    void 유효테이블자리틀림() {

        // given, when
        List<Boolean> hyeonho9877 = reservationService.findValidTables("hyeonho9877", "2021-05-29-14:20", "3");

        // then
        assertThat(hyeonho9877.get(0)).isEqualTo(false);
    }

    @Test
    void 업데이트결과성공(){

        // given
        reservationService.updateReservation("hyeonho9877", "2021-05-29-13:20", "2021-05-29-17:20", "3", "1");
        LocalDateTime parse = LocalDateTime.parse("2021-05-29-17:20", DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm"));

        // when
        try {
            Reservation result = em.createQuery("select r from Reservation r where r.reservationDate=:resDate", Reservation.class)
                    .setParameter("resDate", parse)
                    .getSingleResult();

            // then
            assertThat(result.getTableNo()).isEqualTo("1");
        }catch (Exception e){
            fail();
        }
    }

    @Test
    void 테이블설정하기(){

        //given
        List<Integer> tableList = new ArrayList<Integer>();
        tableList.add(2);
        tableList.add(4);
        tableList.add(4);
        tableList.add(4);
        tableList.add(2);
        tableList.add(3);
        tableList.add(3);
        tableList.add(4);
        tableList.add(4);

        managerService.joinTable(tableList);
        List<TableInfo> result = em.createQuery("select t from TableInfo t", TableInfo.class).getResultList();

        assertThat(result.size()).isEqualTo(tableList.size());
    }


    @Test
    void 메뉴추가하기(){
        Map<String, String> testMap = new HashMap<>();
        testMap.put("Seafood Platter","18000");
        testMap.put("Soup of the Day","8000");
        testMap.put("Grilled Salmon","13000");
        testMap.put("Mixed Green Salad","10000");
        testMap.put("Lobster Cocktail","18000");

        managerService.editDishes(testMap);
        List<Menu> menus = managerRepository.listMenus();
        assertThat(menus.size()).isEqualTo(5);
    }

    @Test
    void 메뉴가격만바뀜(){
        Map<String, String> testMap = new HashMap<>();
        testMap.put("Seafood Platter","18000");
        testMap.put("Soup of the Day","8000");
        testMap.put("Grilled Salmon","13000");
        testMap.put("Mixed Green Salad","10000");
        testMap.put("Seafood Platter","15000");

        managerService.editDishes(testMap);
        Optional<Menu> result = managerRepository.getMenuByDish("Seafood Platter");
        assertThat(result.get().getPrice()).isEqualTo(15000);
    }
}
