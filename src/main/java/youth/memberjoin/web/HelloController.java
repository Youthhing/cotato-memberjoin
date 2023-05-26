package youth.memberjoin.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import youth.memberjoin.web.dto.MemberForm;
import youth.memberjoin.member.Member;
import youth.memberjoin.member.MemberService;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final MemberService memberService;
    @GetMapping("/")
    public String hello(){
        return "hello!";
    }

    @GetMapping("/login")
    public String Login(@RequestBody MemberForm memberForm){

        Member member = memberService.findMember(memberForm.getId());
        memberService.Login(member);

        return "/members/afterLogin";
    }
}
