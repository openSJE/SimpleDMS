package com.example.modelexam.controller.exam09;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam08.Dept08Service;
import com.example.modelexam.service.exam09.Dept09Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/exam09")
public class Dept09Controller {

    @Autowired
    Dept09Service deptService; // 스프링에서 생성된 객체 받아오기 ( @Autowired )

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

//   새로운 부서 정보 생성 함수 : insert 함수 (@PostMapping)
//    @RequestBody : 클라이언트 쪽에서 전송한 객체정보를 (json 데이터) 매개변수로 (부서객체) 전달
    @PostMapping("/dept")
    public ResponseEntity<Object> createDept(@RequestBody Dept dept) {

        try {
//            .save(객체) : 객체에 키(dno)가 없으면 insert , 있으면 update 로직이 있음
            List<Dept> list = deptService.save(dept);
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        }catch (Exception error) {
            log.info(error.getMessage()); // 에러 발생시 에러 메세지 콘솔 출력
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 서버 에러 메세지 전송
        }
    }

}


