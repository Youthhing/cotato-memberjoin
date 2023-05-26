package youth.memberjoin.member;

public interface MemberRepository {
    void save(Member member);//해당 회원을 DB에 저장한다.

    Member findById(String id);
}
