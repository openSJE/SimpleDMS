

package com.example.jpaexam.controller.exam04;

import com.example.jpaexam.model.Emp;
import com.example.jpaexam.service.exam04.Emp04Service;
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
 * fileName : EmpController
 * author : ds
 * date : 2022-10-20
 * description : 사원 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam04")
public class Emp04Controller {
    //    1) 연습문제 : Emp 클래스를 만들고, repository, service, controller 클래스를 정의하세요.
//    함수는 findAll() 정의하세요.
//    데이터를 확인할 수 있는 html 만들어주세요.
//    단, 부서 클래스를 참고하고, Emp 속성은 아래를 참고하세요.
//    Emp :
//         eno (int) , 시퀀스 1부터 1증가, 기본키 설정
//         ename (String)
//         jab (String)
//         manager (int)
//         hiredate (String)
//         salary (int)
//         commission (int)
//         eno (int)
    @Autowired
    Emp04Service empService;

    @GetMapping("/emp")
    public String getEmptAll(Model model) {
        List<Emp> list = empService.findAll();
        model.addAttribute("List", list);

        log.debug(list.toString());
        return "exam04/emp_all.html";
    }

    //    ID로 조회하는 컨트롤러 함수
    @GetMapping("/emp/{eno}")
    public String getEmpId(@PathVariable int eno, Model model){

//        Optional : null 체크하는 객체
        Optional<Emp> optionalEmp = empService.findById(eno);
//        옵셔널 객체 .get() : 옵셔널 객체 안에 있는 부서 객체가 나옴(꺼내기)
        model.addAttribute("emp", optionalEmp.get());
        log.debug(optionalEmp.get().toString());

        return "exam04/emp_id.html";
    }

    //    부서 추가 페이지 (form 양식 있는 홈페이지)
    @GetMapping("/emp/addition")
    public String addEmp() {
        return "exam04/add_emp.html"; // 부서 추가 페이지 열기

    }

    //    insert 컨트롤러 함수
//    @ResponseBody : return 값이 json 데이터 값 나오는 함수, 주로, 함수 위에 정의
//    @ModelAttribute : 객체를 url의 매개변수로받아서 함수의 매개변수 전송
    @PostMapping("/emp/add")
    public RedirectView createEmp(@ModelAttribute Emp emp) {

        try {
            empService.save(emp); // insert문 실행
        }catch (Exception e){
            log.debug(e.getMessage()); // 에러로그 콘솔 출력
        }

        return new RedirectView("/exam04/emp");
    }

}
