package springstudy.toyproject1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springstudy.toyproject1.dto.MemberDTO;
import springstudy.toyproject1.member.Member;
import springstudy.toyproject1.repository.MemberRepository;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // 회원 가입
    public boolean join(MemberDTO memberDTO) {
        String email = memberDTO.getEmail();
        String password = memberDTO.getPassword();
        String nickname = memberDTO.getNickname();

        Boolean isExist = memberRepository.existsByEmail(email);

        if (isExist) {
            return false;
        }

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(bCryptPasswordEncoder.encode(password));
        member.setNickname(nickname);
        member.setRole("ROLE_ADMIN");

        memberRepository.save(member);
        return true;
    }


    public Member loginCheck(String email, String password) throws Exception {
        if (memberRepository.findByEmail(email).getPassword().equals(password)) {
            return memberRepository.findByEmail(email);
        } else {
            throw new Exception("Login failed");
        }
    }
}
