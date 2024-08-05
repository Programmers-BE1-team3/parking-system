package services;

import domain.Member;

public interface MemberService {
    boolean registerMember(Member member);
    Member findMemberById(int user_id);
}
