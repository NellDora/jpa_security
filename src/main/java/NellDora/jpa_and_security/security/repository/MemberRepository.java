package NellDora.jpa_and_security.security.repository;

import NellDora.jpa_and_security.security.domain.Member;

public interface MemberRepository {

    public void save(Member member);

    public Member findById(String memberId);
}
