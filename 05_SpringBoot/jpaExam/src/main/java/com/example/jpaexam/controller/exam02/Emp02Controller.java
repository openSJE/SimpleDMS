package com.example.jpaexam.controller.exam01;

import com.example.jpaexam.model.Emp;
import com.example.jpaexam.service.exam01.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
@RequestMapping("/exam01")
public class EmpController {
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
    EmpService empService;

    @GetMapping("/emp")
    public String getEmptAll(Model model) {
        List<Emp> list = empService.findAll();
        model.addAttribute("List", list);

        log.debug(list.toString());
        return "exam01/emp_all.html";
    }

}
