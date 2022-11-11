
package com.example.jpacustomexam.controller.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Dept03Controllder
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러
 * 요악 :

 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
// @RestController : return 값이 json 데이터 형태로 출력됨
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;


}











