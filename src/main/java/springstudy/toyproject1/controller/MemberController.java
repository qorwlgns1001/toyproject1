package springstudy.toyproject1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springstudy.toyproject1.member.Member;
import springstudy.toyproject1.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    MemberRepository memberRepository;
    Member member;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/member/{id}")
    public Optional<Member> findMember(@PathVariable("id") Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }

    @GetMapping("/member/all")
    public List findAll() {
        List<Member> memberList = memberRepository.findAll();
        return memberList;
    }

    @PostMapping("/member/join")
    public void saveMember(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("nickname") String nickname) throws Exception {
        member = new Member(email, password, nickname);
        memberRepository.save(member);
    }

}
