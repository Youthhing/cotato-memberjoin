package youth.memberjoin.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youth.memberjoin.web.dto.LoginDto;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    @Override
    public void join(Member member) {
        if(memberRepository.findById(member.getId())==null){
            //해당 id가 이미 존재하는지 확인
            memberRepository.save(member);
        }

    }

    @Override
    public Optional<Member> Login(LoginDto loginDto) {
        //로그인하려는 회원의 id,pw가 memberRepository의 pw랑 동일
        Member member = memberRepository.findById(loginDto.getId());
        if(member.getPw().equals(loginDto.getPw())){
            return Optional.of(member);
        }
        else{
            return Optional.empty();
        }

    }

    @Override
    public Member LoginMember(LoginDto loginDto) {
        Member member = memberRepository.findById(loginDto.getId());
        if(member.getPw().equals(loginDto.getPw())){
            return member;
        }
        else return null;
    }

    @Override
    public Member findMember(String id) {
        Member member = memberRepository.findById(id);
        return member;
    }


}
