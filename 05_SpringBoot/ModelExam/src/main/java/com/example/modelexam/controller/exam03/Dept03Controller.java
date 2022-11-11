package com.example.modelexam.controller.exam02;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam01.DeptService;
import com.example.modelexam.service.exam02.Dept02Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
//@Slf4j
@Controller
//@RequestMapping(공통 url)
@RequestMapping("/exam02")
public class Dept02Controller {

//    컨트롤러 역할 : 서비스와 웹브라우저의 중간 역할
    @Autowired
    Dept02Service deptService; // 스프링부트 컨테이너의 객체 하나 받아오기

    @GetMapping("/dept")
    public String getDeptAll(Model model) {

        List<Dept> list = deptService.findAll(); // 모든 부서 정보를 배열에 저장
        model.addAttribute("list", list);

        return "exam01/dept_all.html"; // .html 홈페이지 이동
    }

//    id 조회하는 함수
    @GetMapping("/dept/{dno}")
    public String getDeptId(@PathVariable long dno, Model model){

        Dept dept = deptService.findById(dno);
        model.addAttribute("dept",dept);
        return "exam02/dept_id.html"; // dept_id.html 홈페이지로 이동
    }
}
