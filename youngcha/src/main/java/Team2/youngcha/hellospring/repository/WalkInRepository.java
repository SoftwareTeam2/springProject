package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.WalkIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkInRepository extends JpaRepository<WalkIn,Long> {
}
