
package com.example.jpaexam.controller.exam05;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.service.exam05.Dept05Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam01
 * fileName : DeptContoroller
 * author : ds
 * date : 2022-10-20
 * description : 부서 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam05")
public class Dept05Controller {

    @Autowired
    Dept05Service deptService;

    @GetMapping("/dept")
    public String getDeptAll(Model model){
        List<Dept> list = deptService.findAll();
        model.addAttribute("List",list);

        log.debug(list.toString());
        return "exam05/dept_all.html";
    }

//    ID로 조회하는 컨트롤러 함수
    @GetMapping("/dept/{dno}")
    public String getDeptId(@PathVariable int dno, Model model){

//        Optional : null 체크하는 객체
        Optional<Dept> optionalDept = deptService.findById(dno);
//        옵셔널 객체 .get() : 옵셔널 객체 안에 있는 부서 객체가 나옴(꺼내기)
        model.addAttribute("dept", optionalDept.get());
        log.debug(optionalDept.get().toString());

        return "exam05/dept_id.html";
    }

//    부서 추가 페이지 (form 양식 있는 홈페이지)
    @GetMapping("/dept/addition")
    public String addDept() {
        return "exam05/add_dept.html"; // 부서 추가 페이지 열기

    }

//    insert 컨트롤러 함수
//    @ResponseBody : return 값이 json 데이터 값 나오는 함수, 주로, 함수 위에 정의
//    @ModelAttribute : 객체를 url의 매개변수로받아서 함수의 매개변수 전송
@PostMapping("/dept/add")
public RedirectView createDept(@ModelAttribute Dept dept) {

        try {
            deptService.save(dept); // insert문 실행
        }catch (Exception e){
            log.debug(e.getMessage()); // 에러로그 콘솔 출력
        }

        return new RedirectView("/exam05/dept");
    }

//    수정페이지 열기
//    첫페이지에서 부서번호를 클릭하면 아래 함수가 실행
    @GetMapping ("/dept/edition/{dno}")
    public String editDept(@PathVariable int dno, Model model) {
//        부서번호에 해당하는 정보를 검색하기
        Optional<Dept> optionalDept = deptService.findById(dno);

//        부서정보를 홈페이지로 전송
        model.addAttribute("dept", optionalDept.get());

        return "exam05/update_dept.html"; // 수정페이지 열기
    }

//    수정 버튼 클릭 후 실행되는 함수
    @PutMapping("/dept/edit/{dno}")
    public RedirectView updateDept(@PathVariable int dno, @ModelAttribute Dept dept){

        try {
            deptService.save(dept); // update 호출
        }catch (Exception e) {
            log.debug(e.getMessage()); // update 시 에러 로그 출력
        }

        return new RedirectView("/exam05/dept");

    }
}
