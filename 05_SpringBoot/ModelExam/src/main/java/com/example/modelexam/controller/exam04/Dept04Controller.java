package com.example.modelexam.controller.exam03;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam02.Dept02Service;
import com.example.modelexam.service.exam03.Dept03Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
// @RequestMapping(공통 url)
@RequestMapping("/exam03")
public class Dept03Controller {

    //    컨트롤러 역할 : 서비스 와 웹브라우저의 중간 역할
    @Autowired
    Dept03Service deptService; // 스프링부트 컨테이너의 deptService 객체 하나 받아오기

    @GetMapping("/dept")
    public String getDeptAll(Model model) {

        List<Dept> list = deptService.findAll(); // 모든 부서 정보를 배열에 저장
        model.addAttribute("list", list);

        return "exam03/dept_all.html"; // dept_all.html 홈페이지로 이동
    }

    //    id 조회하는 함수
    @GetMapping("/dept/{dno}")
    public String getDeptId(@PathVariable long dno, Model model) {

        Dept dept = deptService.findById(dno);
        model.addAttribute("dept", dept);

        return "exam03/dept_id.html"; // dept_id.html 홈페이지로 이동
    }

    //    새로운 부서 정보를 요청받아 db에 저장하는 함수
//    service 쪽 저장함수 호출
//    참고) 함수 -> Rest API 출력
    @PostMapping("/dept")
//    @ResponseBody : json 형태의 데이터를 리턴할 수 있게하는 어노테이션
    @ResponseBody
    public List<Dept> createDept(@RequestBody Dept dept) {

        List<Dept> list = deptService.save(dept);

        return list;
    }
}



