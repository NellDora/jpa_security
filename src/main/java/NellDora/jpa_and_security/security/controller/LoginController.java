package NellDora.jpa_and_security.security.controller;

import NellDora.jpa_and_security.jpa.service.UserService;
import NellDora.jpa_and_security.security.domain.Member;
import NellDora.jpa_and_security.security.dto.LoginDTO;
import NellDora.jpa_and_security.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/security")
public class LoginController {

    private MemberService memberService;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String LoginGet(){

        return "/security/login";
    }

    @PostMapping("/login")
    public String LoginPost(@ModelAttribute LoginDTO loginDTO){

        Member findMember = memberService.findById(loginDTO.getLoginId());
        
        if(passwordEncoder.encode(loginDTO.getPassword()).equals(findMember.getPassword())){
            log.info("로그인 성공");
        }else{
            log.info("로그인 실패");
        }

        return "/security/main";
    }

}
