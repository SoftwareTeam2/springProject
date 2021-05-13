package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class CustomerService {

    private final MemberRepository memberRepository;

    public CustomerService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Customer customer) {
        validateDuplicateName(customer); // 중복회원 검증

        memberRepository.save(customer);
        return customer.getSystemID();
    }

    private void validateDuplicateName(Customer customer) {
        System.out.println(customer.getUserName());
        memberRepository.findByName(customer.getUserName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Customer> findMember() {
        return memberRepository.findAll();
    }

    /*
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

     */

    public String LogIn(String id, String psw) {
        Optional<Customer> result = memberRepository.findByUserID(id);
        if (result.isPresent() && result.get().getUserPSW().equals(psw))
            return "success";
        else return "failed";
    }
}
