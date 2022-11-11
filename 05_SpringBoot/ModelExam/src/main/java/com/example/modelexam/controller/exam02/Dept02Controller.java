package com.example.modelexam.controller.exam01;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam01.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller
 * fileName : DeptController
 * author : ds
 * date : 2022-10-17
 * description : 부서 컨트롤러 findAll() 함수, @Slf4j
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-17         ds          최초 생성
 */
@Controller
//@RequestMapping(공통 url)
@RequestMapping("/exam01")
public class DeptController {

//    컨트롤러 역할 : 서비스와 웹브라우저의 중간 역할
    @Autowired
    DeptService deptService; // 스프링부트 컨테이너의 객체 하나 받아오기

    @GetMapping("/dept")
    public String getDeptAll(Model model) {

        List<Dept> list = deptService.findAll(); // 모든 부서 정보를 배열에 저장
        model.addAttribute("list", list);

        return "exam01/dept_all.html"; // .html 홈페이지 이동
    }
}
