package youth.memberjoin.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MemoryMemberRepository implements MemberRepository{

    Map<String, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(String id) {
        return store.get(id);
    }

    @Override
    public Member delete(Member member) {
        return store.remove(member.getId());
        //해당 키에 맞는 value를 반환함.
    }
}
