package com.example.modelexam.controller.exam05;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam05.Dept05Service;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
// @RequestMapping(공통 url)
@RequestMapping("/exam05")
public class Dept05Controller {

    //    컨트롤러 역할 : 서비스 와 웹브라우저의 중간 역할
    @Autowired
    Dept05Service deptService; // 스프링부트 컨테이너의 deptService 객체 하나 받아오기

    @GetMapping("/dept")
    public String getDeptAll(Model model) {

        List<Dept> list = deptService.findAll(); // 모든 부서 정보를 배열에 저장
        model.addAttribute("list", list);

        return "exam05/dept_all.html"; // dept_all.html 홈페이지로 이동
    }

    //    id 조회하는 함수
    @GetMapping("/dept/{dno}")
    public String getDeptId(@PathVariable long dno, Model model) {

        Dept dept = deptService.findById(dno);
        model.addAttribute("dept", dept);

        return "exam05/dept_id.html"; // dept_id.html 홈페이지로 이동
    }

    //    html 부서 정보 추가 페이지 링크 생성
    @GetMapping("/dept/addition")
    public String addDept() {
        return "exam05/add_dept.html"; // 부서정보 추가 페이지 경로
    }

    //  새로운 부서 객체 정보 db 저장 함수
    @PostMapping("/dept/add")
    public RedirectView createDept(@ModelAttribute Dept dept) {
        deptService.save(dept); // db 저장 서비스 호출

        return new RedirectView("/exam05/dept"); // 전체 부서 정보 페이지로 강제 이동
    }

//    수정 페이지 열기 함수
    @GetMapping("/dept/edition/{dno}")
    public String editDept(@PathVariable long dno, Model model){
//        부서번호(dno)에 해당하는 정보 요청
        Dept dept = deptService.findById(dno);
        model.addAttribute("dept", dept);

        return "exam05/update_dept.html";
    }
    
//    수정페이지에서 제출(submit)버튼을 눌렀을 때 실행되는 함수
//    @PutMapping : Update 문이 실행될 때 사용하는 어노테이션
//    클라이언트 쪽에서 키값 + 객체를 모두 전송함
    @PutMapping("/dept/edit/{dno}")
    public RedirectView updateDept(@PathVariable int dno, @ModelAttribute Dept dept){
        deptService.save(dept);
        
        return new RedirectView("/exam05/dept"); // 부서정보 첫페이지 강제 이용
    }
}




