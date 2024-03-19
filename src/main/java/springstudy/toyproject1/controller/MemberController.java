package springstudy.toyproject1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springstudy.toyproject1.dto.MemberDTO;
import springstudy.toyproject1.member.Member;
import springstudy.toyproject1.repository.MemberRepository;
import springstudy.toyproject1.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    MemberRepository memberRepository;
    MemberService memberService;

    @Autowired
    public MemberController(MemberRepository memberRepository, MemberService memberService) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
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

    @PostMapping("/join")
    public String join(MemberDTO memberDTO) {
        if (memberService.join(memberDTO)) {
            return "OK";
        }
        return "Join Failed";
    }

}
