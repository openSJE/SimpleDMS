
package com.example.jpacustomexam.controller.exam07;


import com.example.jpacustomexam.dto.DeptEmpCDto;
import com.example.jpacustomexam.dto.DeptEmpDto;
import com.example.jpacustomexam.model.exam04.Department;
import com.example.jpacustomexam.service.exam04.Dept04Service;
import com.example.jpacustomexam.service.exam07.Dept07Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/exam07")
public class Dept07Controller {

    @Autowired
    Dept07Service deptService;


//    1)
//    URL 테스트 : http://localhost:8000/exam03/dept/desc/paging?page=0&size=2
    @GetMapping("/dept/querydsl/dname/{dname}")
    public ResponseEntity<Object> querydslByDname(@PathVariable String dname) {

        try {
            List<Department> list = deptService.querydslByDname(dname);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



//    2)
//    URL 테스트 : http://localhost:8000/exam03/dept/desc/paging?page=0&size=2
    @GetMapping("/dept/querydsl/dname/{dname}/loc/{loc}")
    public ResponseEntity<Object> querydslByDnameAndLoc(@PathVariable String dname,
                                                        @PathVariable String loc) {

        try {
            List<Department> list = deptService.querydslByDnameAndLoc(dname,loc);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}











