package youth.memberjoin.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import youth.memberjoin.member.Member;
import youth.memberjoin.member.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/create")
    public String create(@RequestBody Member member){
        //id,pw 만 받는 클래스만들어서 관리해봐라
        Member member1 = new Member(member.getId(), member.getPw(), member.getName());
        memberService.join(member);

        return "회원가입 완료.";
    }

    @GetMapping("/afterLogin")
    public String afterLogin(@RequestBody Member member){

        return "index.html";
    }


}
