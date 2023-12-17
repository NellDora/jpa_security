package NellDora.jpa_and_security.security.service;

import NellDora.jpa_and_security.security.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
class MemberServiceTest {

    private final MemberService memberService;

    @Autowired
    public MemberServiceTest(MemberService memberService){
        this.memberService = memberService;
    }

    @Test
    public void Test1(){

        Member member = new Member();
        member.setId("Test1");
        member.setName("운영자");
        member.setPassword("abcdef");
        member.setDepartment("IT");

        memberService.save(member);


    }

    @Test
    public void Test(){
        Member member = memberService.findById("Test1");
        System.out.println("인코딩된 비밀번호 : "  + member.getPassword());
    }

}