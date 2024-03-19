package springstudy.toyproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springstudy.toyproject1.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    Boolean existsByEmail(String email);
}
