package youth.memberjoin.member;

import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface MemberRepository {
    void save(Member member);//해당 회원을 DB에 저장한다.

    Member findById(String id);

    void delete(Member member);
}
