package springstudy.toyproject1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springstudy.toyproject1.member.Member;
import springstudy.toyproject1.repository.MemberRepository;

@Service
public class MemberService {
    MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member loginCheck(String email, String password) throws Exception {
        if (memberRepository.findByEmail(email).getPassword().equals(password)) {
            return memberRepository.findByEmail(email);
        } else {
            throw new Exception("Login failed");
        }
    }
}
