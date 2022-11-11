package com.example.modelexam.controller.exam08;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam08.Dept08Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.controller.exam07
 * fileName : Dept07Controller
 * author : ds
 * date : 2022-10-18
 * description : @RestController 이용, ResponseEntity, getDeptAll()
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-18         ds          최초 생성
 */
// @RestController : Vue + Springboot 연동 프로그램에서 사용
//    특징 : return 값 json 데이터임
// 참고 ) @Slf4j : (Simple Logging focade for java), focade 디자인 패턴을 이용해서 제작 됨.
@Slf4j
@RestController
@RequestMapping("/exam08")
public class Dept08Controller {

    @Autowired
    Dept08Service deptService; // 스프링에서 생성된 객체 받아오기 ( @Autowired )

    @GetMapping("/dept")
    public ResponseEntity<Object> getDeptAll() {

        try {
            List<Dept> list = deptService.findAll(); // 전체 부서 정보 조회

            if(list.isEmpty() == false) {
//                성공 메세지 + 객체 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터가 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.info(e.getMessage()); // 에러 로그 찍기
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    부서번호 (dno)로 조회하기 함수
    @GetMapping("/dept/{dno}")
    public ResponseEntity<Object> getDeptId(@PathVariable long dno){

        try {
            Optional<Dept> optionalDept = deptService.findById(dno); // 전체 부서 정보 조회

            if(optionalDept.isPresent() == true) {
//                성공 메세지 + 객체 전송
//                옵셔널 객체.get() : 옵셔널 객체 안에 들어있는
                return new ResponseEntity<>(optionalDept.get(), HttpStatus.OK);
            } else {
//                데이터가 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.info(e.getMessage()); // 에러 로그 찍기
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}


