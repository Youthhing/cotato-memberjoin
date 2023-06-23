package youth.memberjoin.web;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import youth.memberjoin.member.Member;
import youth.memberjoin.member.MemberService;
import youth.memberjoin.web.dto.AfterLoginDto;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    
    //로그인 후의 화면
    //id, name을 띄워야함
    @GetMapping("/afterLogin")
    @ResponseBody
    public AfterLoginDto afterLogin(HttpSession session){
        Member loggedInMember = (Member) session.getAttribute("loggedInMember");

        AfterLoginDto afterLoginDto = new AfterLoginDto(loggedInMember.getId(), loggedInMember.getName());
        return afterLoginDto;

    }

    @DeleteMapping("/deleteMember")
    @ResponseBody
    public String deleteMember(HttpSession session){
        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
        memberService.deleteMember(loggedInMember);
        return "you are deleted!!";

    }



}
