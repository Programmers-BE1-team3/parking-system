package repositories;

import domain.Member;

import java.util.List;

public interface MemberRepository {

    int insert(Member member);
    Member select();
    Member select(int id);
    List<Member> selectAll();
}
