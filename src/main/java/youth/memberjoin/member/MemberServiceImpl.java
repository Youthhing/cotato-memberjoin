package youth.memberjoin.member;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    @Override
    public void join(Member member) {

    }

    @Override
    public Member Login(Member member) {
        //로그인하려는 회원의 id,pw가 memberRepository의 pw랑 동일
        Member member1 = memberRepository.findById(member.getId());
        if(member.getPw()==member1.getPw()){
            return member;
        }
        return member;//로그인 실패시?
    }

    @Override
    public Member findMember(String id) {
        return null;
    }


}
