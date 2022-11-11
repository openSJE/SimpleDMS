
package com.example.jpacustomexam.controller.exam04;


import com.example.jpacustomexam.dto.Dept02GroupDto;
import com.example.jpacustomexam.dto.DeptEmpCDto;
import com.example.jpacustomexam.dto.DeptEmpDto;
import com.example.jpacustomexam.dto.DeptGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.service.exam03.Dept03Service;
import com.example.jpacustomexam.service.exam04.Dept04Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/exam04")
public class Dept04Controller {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    Dept04Service deptService;


    //  1)
    @GetMapping("/dept/native/join")
    public ResponseEntity<Object> selectNativeJoin() {

        try {
            List<DeptEmpDto> list = deptService.selectNativeJoin();

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


    //  2) 객체쿼리 이용 조인 함수
    @GetMapping("/dept/join")
    public ResponseEntity<Object> selectJoin() {

        try {
            List<DeptEmpCDto> list = deptService.selectJoin();

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










