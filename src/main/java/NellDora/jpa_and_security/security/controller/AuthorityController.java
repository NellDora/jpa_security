package NellDora.jpa_and_security.security.controller;

import NellDora.jpa_and_security.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/authority")
public class AuthorityController {

    private MemberService memberService;

    @GetMapping("/auth")
    public String AuthorityMemberGET(){
        //뷰 페이지

        return null;
    }

//    @PostMapping("/auth")
//    public String AuthorityMemberPOST(@ModelAttribute("authDTO")){
//
//        return null;
//    }

}
