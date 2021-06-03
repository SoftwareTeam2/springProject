package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    Optional<Customer> findByCid(Customer customer);
    List<Customer> findAll();
    Boolean validateUser(String id, String pwd);
    Boolean isAdmin(String id);
    Optional<Customer> findEmailByCid(String cid);
    Optional<Customer> findNameByCid(String cid);
    Optional<Customer> findIdByNameAndEmail(String name, String email);
    Optional<Customer> findByEmailAndNameAndCid(String email, String name, String cid);
    Boolean changePSW(String cid, String psw);
}