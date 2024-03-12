package springstudy.toyproject1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springstudy.toyproject1.member.Member;
import springstudy.toyproject1.repository.MemberRepository;
import springstudy.toyproject1.service.MemberService;

@RestController
public class LoginController {

    MemberService memberService;
    MemberRepository memberRepository;

    @Autowired
    public LoginController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }


    @PostMapping("/login")
    public Member login(@RequestParam("email") String email, @RequestParam("password") String password) throws Exception {
        return memberService.loginCheck(email, password);
    }
}
