package com.example.modelexam.controller.exam01;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam01.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller
 * fileName : MemberController
 * author : ds
 * date : 2022-10-17
 * description : 회원 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-17         ds          최초 생성
 */
@Controller
//@RequestMapping(공통 url)
@RequestMapping("/exam01")
public class MemberController {
//    연습문제 1) 부서클래스를 참고하여
//    MemberService 클래스를 만들고, findAll() 함수를 정의하세요.
//    MemberController 클래스를 만들고 getMemberAll() 함수를 정의하세요.
//    결과를 뷰로(member_all.html)로 전송해보세요.
@Autowired
MemberService memberService; // 스프링부트 컨테이너의 객체 하나 받아오기

    @GetMapping("/member")
    public String getMemberAll(Model model) {

        List<Member> list = memberService.findAll(); // 모든 부서 정보를 배열에 저장
        model.addAttribute("list", list);

        return "exam01/member_all.html"; // .html 홈페이지 이동
    }

}
