package com.example.jpaexam.controller.exam01;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.service.exam01.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
@RequestMapping("/exam01")
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept")
    public String getDeptAll(Model model){
        List<Dept> list = deptService.findAll();
        model.addAttribute("List",list);

        log.debug(list.toString());
        return "exam01/emp_all.html";
    }
}
