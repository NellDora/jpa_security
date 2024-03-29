package NellDora.jpa_and_security.security.service;

import NellDora.jpa_and_security.security.domain.Member;
import NellDora.jpa_and_security.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(Member member){
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member);

    }

    public Member findById(String memberId){
        return memberRepository.findById(memberId);
    }
}
