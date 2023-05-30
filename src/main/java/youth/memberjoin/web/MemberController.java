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


    //로그인 후의 화면
    @GetMapping("/")
    public String afterLogin(@RequestBody Member member){

        return "you are login!";
    }





}
