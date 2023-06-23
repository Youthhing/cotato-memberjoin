package youth.memberjoin.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import youth.memberjoin.AutoConfig;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
        memberService = ac.getBean(MemberService.class);
    }
    @Test
    void 회원가입_확인(){
        //given
        Member member = new Member("Youthing","1234","youth");

        //when
        memberService.join(member);
        Member youthing = memberService.findMember("Youthing");

        //then
        assertThat(member).isEqualTo(youthing);


    }

    @Test
    void 회원조회(){
        //given
        Member member = new Member("Youthing", "1234", "youth");

        //when
        memberService.join(member);
        Member findMember = memberService.findMember("Youthing");

        //then
        assertThat(member.getId()).isEqualTo(findMember.getId());

    }

    @Test
    void 회원탈퇴(){
        //given
        Member member = new Member("Youthing","1234","Youth");
        memberService.join(member);

        //when
        memberService.deleteMember(member);
        Member member1 = memberService.findMember("Youthing");

        //then
        assertThat(member1).isNull();

    }
}
