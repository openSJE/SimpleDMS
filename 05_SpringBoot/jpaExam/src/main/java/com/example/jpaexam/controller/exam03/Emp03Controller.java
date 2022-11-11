
package com.example.jpaexam.controller.exam02;

import com.example.jpaexam.model.Emp;
import com.example.jpaexam.service.exam02.Emp02Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/exam02")
public class Emp02Controller {
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
//         dno (int)
    @Autowired
    Emp02Service empService;

    @GetMapping("/emp")
    public String getEmptAll(Model model) {
        List<Emp> list = empService.findAll();
        model.addAttribute("List", list);

        log.debug(list.toString());
        return "exam01/emp_all.html";
    }

    //    ID로 조회하는 컨트롤러 함수
    @GetMapping("/emp/{eno}")
    public String getEmpId(@PathVariable int eno, Model model) {

//        Optional : null 체크하는 객체
        Optional<Emp> optionalEmp = empService.findById(eno);
//        옵셔널 객체 .get() : 옵셔널 객체 안에 있는 부서 객체가 나옴(꺼내기)
        model.addAttribute("emp", optionalEmp.get());
        log.debug(optionalEmp.get().toString());

        return "exam02/emp_id.html";

    }
}
