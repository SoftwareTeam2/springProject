package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Customer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements MemberRepository {
    private final EntityManager em;

    public CustomerRepository(EntityManager em) {
        this.em = em;
    }

    public Customer save(Customer customer) {
        em.persist(customer);
        return customer;
    }
/*
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
*/
    public List<Customer> findAll() {
        return em.createQuery("select c from Customer c", Customer.class)
                .getResultList();
    }

    @Override
    public Optional<Customer> findByUserID(String id) {
        Optional<Customer> member = Optional.ofNullable(em.createQuery("select c from Customer c where c.userID = :userID", Customer.class)
                .setParameter("userID", id)
                .getSingleResult());
        return member;
    }

    public Optional<Customer> findByName(String name) {
        List<Customer> result = em.createQuery("select c from Customer c where c.userName = :name", Customer.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Boolean validateUser(String id, String pwd) {
        Customer customer = em.createQuery("select m from Member m", Customer.class)
                .getSingleResult();
        return pwd.equals(customer.getUserPSW());
    }
    /*
    public Optional<Member> testUser(String id, String pwd){
        System.out.println("testUser enter");
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
     */

}