package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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


    public Optional<Customer> findByName(Customer customer) {
        List<Customer> result = em.createQuery("select c from Customer c where c.cid=:cid")
                .setParameter("cid", customer.getCid())
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Customer> findAll(){
        return em.createQuery("select c from Customer c", Customer.class)
                .getResultList();
    }

    @Override
    public Boolean validateUser(String id, String pwd) {
        Optional<Customer> customer = Optional.ofNullable(em.createQuery("select c from Customer c where c.userID=:userID", Customer.class)
                .setParameter("userID", id)
                .getSingleResult());
        if(customer.isPresent()) {
            return pwd.equals(customer.get().getPsw());
        }
        else return false;
    }


    @Override
    public Boolean isAdmin(String id) {
        return em.createQuery("select c from Customer c where c.userID=:id",Customer.class)
                .setParameter("id",id)
                .getSingleResult()
                .getAdmin();
    }
}