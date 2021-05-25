package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerService {

    private final MemberRepository memberRepository;

    public CustomerService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public void join(Customer customer) {
        validateDuplicateName(customer); // 중복회원 검증

        memberRepository.save(customer);
    }

    private void validateDuplicateName(Customer customer) {
        memberRepository.findByName(customer)
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

    public Boolean LogIn(String id, String psw) {
        return memberRepository.validateUser(id, psw);
    }

    public Boolean isAdmin(String id) {
        return memberRepository.isAdmin(id);
    }

    public static Boolean SToBConvert(String string) {
        return (string.equals("Y")) ? true : false;
    }
}