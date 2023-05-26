package youth.memberjoin.member;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {


    void join(Member member);//해당 회원을 회원 가입한다.

    Member findMember(String id);//해당 id를 가진 회원을 찾는다.

    //로그인
    Member Login(Member member);//해당id에 해당하는 pw가 일치하는지 확인한다.

}
