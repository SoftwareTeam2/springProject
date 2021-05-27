package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.TableInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

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
}
