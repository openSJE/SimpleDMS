package com.example.modelexam.controller.exam10;

import com.example.modelexam.model.Dept;
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
// @RestController : Vue + Springboot 연동 프로그램에서 사용
//    특징 : return 값이 json 데이터임
// @Slf4j : Simple Logging facade for java : facade 디자인 패턴이용해서 제작됨
@Slf4j
@RestController
@RequestMapping("/exam10")
public class Dept10Controller {

    @Autowired
    Dept10Service deptService; // 스프링에서 생성된 객체 받아오기

    @GetMapping("/dept")
    public ResponseEntity<Object> getDeptAll() {
        try {
            List<Dept> list = deptService.findAll();

            if (list.isEmpty() == false) {
//                성공 메세지 + 객체 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터가 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.info(e.getMessage()); // 에러 로그 찍기
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 내부 서버 에러 메세지
        }
    }

    //    부서번호(dno)로 조회하기 함수
    @GetMapping("/dept/{dno}")
    public ResponseEntity<Object> getDeptId(@PathVariable long dno) {

        try {
            Optional<Dept> optionalDept = deptService.findById(dno);

            if (optionalDept.isPresent() == true) {
//                성공 메세지 + 객체 전송
//                optional객체.get() : optional 객체안에 들어있는 객체가 나옴
                return new ResponseEntity<>(optionalDept.get(), HttpStatus.OK);
            } else {
//                데이터가 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.info(e.getMessage()); // 에러 로그 찍기
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 내부 서버 에러 메세지
        }
    }

    //    새로운 부서 정보 생성 함수 : insert 함수( @PostMapping )
//    @RequestBody : 클라이언트 쪽에서 전송한 객체정보를(json데이터) 매개변수로(부서객체) 전달
    @PostMapping("/dept")
    public ResponseEntity<Object> createDept(@RequestBody Dept dept) {

        try {
//            .save(객체) : 객체에 키(부서번호)가 없으면 insert, 있으면 update 로직이 있음
            List<Dept> list = deptService.save(dept);

            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception e) {
            log.info(e.getMessage()); // 에러발생시 에러 메세지 콘솔 출력
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 서버 에러 메세지전송
        }
    }

    //    부서번호에 해당하는 부서를 수정하는 함수( update -> @PutMapping )
//    클라이언트 전송할 데이터 : 부서번호 + 수정된 객체
//    PathVariable : 1개의 변수값을 받는 어노테이션
//    서비스 클래스의 .save(객체) : 매개변수의 객체안에 키값(부서번호)이 없으면 insert 호출
//                                           있으면 update 호출되는 로직으로 코딩됨
    @PutMapping("/dept/edit/{dno}")
    public ResponseEntity<Object> updateDept(@PathVariable int dno, @RequestBody Dept dept) {

        try {
//            .save(객체) : 객체에 키(부서번호)가 없으면 insert, 있으면 update 로직이 있음
//            현재 매개변수 : 키값이 있음(부서번호가 있음) -> update 실행
            List<Dept> list = deptService.save(dept);

            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception e) {
            log.info(e.getMessage()); // 에러발생시 에러 메세지 콘솔 출력
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 서버 에러 메세지전송
        }

    }
}