
package com.example.jpaexam.controller.exam03;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.service.exam03.Dept03Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/exam03")
public class Dept03Controller {

    @Autowired
    Dept03Service deptService;

    @GetMapping("/dept")
    public String getDeptAll(Model model){
        List<Dept> list = deptService.findAll();
        model.addAttribute("List",list);

        log.debug(list.toString());
        return "exam03/dept_all.html";
    }

//    ID로 조회하는 컨트롤러 함수
    @GetMapping("/dept/{dno}")
    public String getDeptId(@PathVariable int dno, Model model){
        
//        Optional : null 체크하는 객체
        Optional<Dept> optionalDept = deptService.findById(dno);
//        옵셔널 객체 .get() : 옵셔널 객체 안에 있는 부서 객체가 나옴(꺼내기)
        model.addAttribute("dept", optionalDept.get());
        log.debug(optionalDept.get().toString());

        return "exam03/dept_id.html";
    }

//    insert 컨트롤러 함수
//    @ResponseBody : return 값이 json 데이터 값 나오는 함수, 주로, 함수 위에 정의
@PostMapping("/dept")
@ResponseBody
public Dept createDept(@RequestBody Dept dept) {
        Dept dept2 = null;
        try {
            dept2 = deptService.save(dept); // insert문 실행
        }catch (Exception e){
            log.debug(e.getMessage()); // 에러로그 콘솔 출력
        }

        return dept2;
    }
}
