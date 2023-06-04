package youth.memberjoin.web;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import youth.memberjoin.member.Member;
import youth.memberjoin.member.MemberService;
import youth.memberjoin.web.dto.LoginDto;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final MemberService memberService;
    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return "hello!";
    }

    @GetMapping("/loginSuccess")
    @ResponseBody
    public String success(){
        return "login Success!";
    }

    @PostMapping("/create")
    public String create(@RequestBody Member member){

        Member member1 = new Member(member.getId(), member.getPw(), member.getName());
        memberService.join(member);

        //문자열로 회원가입 성공메시지 띄우고 싶음
        //이후 로그인 url로 redirect하고 싶음
        return "redirect:/loginSuccess";
    }
    @GetMapping("/login")
    public String Login(@RequestBody LoginDto loginDto, HttpSession session){
        //id,pw 만 받는 클래스만들어서 관리해봐라
        Optional<Member> member = memberService.Login(loginDto);
        if(member.isPresent()){
            session.setAttribute("loggedInMember",member.get());
            return "/members/afterLogin";
        }

        return "redirect:/login";
    }

    @PostMapping("/loginMember")
    public String Login1(@RequestBody LoginDto loginDto, HttpSession session){
        Member member = memberService.LoginMember(loginDto);
        session.setAttribute("loggedInMember",member);
        System.out.println("session = " + session.getAttribute("loggedInMember"));
        return "redirect:/members/afterLogin";
        //return "/";
    }



}
