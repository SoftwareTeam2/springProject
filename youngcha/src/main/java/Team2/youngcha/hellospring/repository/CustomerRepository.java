package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements MemberRepository {

    private final EntityManager em;

    public CustomerRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Customer save(Customer customer) {
        em.persist(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        Customer customer = em.find(Customer.class, id);
        return Optional.ofNullable(customer);
    }


    public Optional<Customer> findByCid(Customer customer) {
        try {
            Customer result = em.createQuery("select c from Customer c where c.cid=:cid", Customer.class)
                    .setParameter("cid", customer.getCid())
                    .getSingleResult();
            return Optional.ofNullable(result);
        } catch(Exception e){
            return Optional.empty();
        }
    }

    public Optional<Customer> findEmailByCid(String cid){
        Customer customer = em.createQuery("select c from Customer c where c.cid=:cid", Customer.class)
                .setParameter("cid", cid)
                .getSingleResult();

        return Optional.ofNullable(customer);
    }
    @Override
    public List<Customer> findAll(){
        return em.createQuery("select c from Customer c", Customer.class)
                .getResultList();
    }

    @Override
    public Boolean validateUser(String id, String pwd) {
        try {
            Customer customer = em.createQuery("select c from Customer c where c.cid=:cid", Customer.class)
                    .setParameter("cid", id)
                    .getSingleResult();
            return customer.getPsw().equals(pwd);
        }catch(NoResultException e){
            return false;
        }
    }


    @Override
    public Boolean isAdmin(String id) {
        return em.createQuery("select c from Customer c where c.cid=:cid",Customer.class)
                .setParameter("cid",id)
                .getSingleResult()
                .getAdmin();
    }

    @Override
    public Optional<Customer> findNameByCid(String cid) {
        Customer result = em.createQuery("select c from Customer c where c.cid=:cid", Customer.class)
                .setParameter("cid", cid)
                .getSingleResult();
        return Optional.ofNullable(result);
    }
}