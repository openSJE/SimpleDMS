package com.example.modelexam.controller.exam03;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam03.Member03Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam02
 * fileName : Member02Controller
 * author : ds
 * date : 2022-10-17
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-17         ds          최초 생성
 */
@Controller
@RequestMapping("/exam03")
public class Member03Controller {
//    연습문제 1) 부서클래스를 참고하여
//    MemberService 클래스를 만들고, findById() 함수를 정의하세요.
//    MemberController 클래스를 만들고 getMemberId() 함수를 정의하세요. (/member/{eno})
//    결과를 뷰로(exam02/member_id.html)로 전송해보세요.

    @Autowired
    Member03Service memberService; // 스프링부트 컨테이너의 객체 하나 받아오기

    @GetMapping("/member")
    public String getMemberAll(Model model) {

        List<Member> list = memberService.findAll(); // 모든 부서 정보를 배열에 저장
        model.addAttribute("list", list);

        return "exam03/member_all.html"; // .html 홈페이지 이동
    }


    //    id 조회하는 함수
    @GetMapping("/member/{eno}")
    public String getMemberId(@PathVariable long eno, Model model){

        Member member = memberService.findById(eno);
        model.addAttribute("member",member);
        return "exam03/member_id.html"; // dept_id.html 홈페이지로 이동
    }

    @PostMapping("/member")
    @ResponseBody
    public List<Member> createMember(@RequestBody Member member) {

        List<Member> list = memberService.save(member);

        return list;
    }


}
