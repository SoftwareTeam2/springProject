package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Customer save(Customer customer);

    Optional<Customer> findByUserID(String id);
    //Optional<Member> findById(Long id);

    Optional<Customer> findByName(String name);

    List<Customer> findAll();

    Boolean validateUser(String id, String pwd);
}
