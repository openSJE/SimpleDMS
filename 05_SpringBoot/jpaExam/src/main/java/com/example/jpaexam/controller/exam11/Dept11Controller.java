
package com.example.jpaexam.controller.exam10;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.service.exam09.Dept09Service;
import com.example.jpaexam.service.exam10.Dept10Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Dept07Controllder
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러 @RestController, ResponseEntity, getDeptAll()
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
// @RestController : return 값이 json 데이터 형태로 출력됨
@Slf4j
@RestController
@RequestMapping("/exam10")
public class Dept10Controller {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    Dept10Service dept10Service; // @Autowired : Springboot 가 가동될 때 생성된 객체를 하나 받아오기

    //    1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @@GetMapping("url") -> 3) DB: select 요청
    @GetMapping("/dept")
    public ResponseEntity<Object> getDeptAll() {

        try {
            List<Dept> list = dept10Service.findAll();

            if (list.isEmpty() == false) {
//                데이터 + 성공메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송 (클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//            서버에서 발생 메세지 전송 (클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    id로 조회(select) 하는 함수
    @GetMapping("/dept/{dno}")
    public ResponseEntity<Object> getDeptId(@PathVariable int dno) {

        try {
            Optional<Dept> ooptionalDelpt = dept10Service.findById(dno);

            if (ooptionalDelpt.isPresent() == true) {
//                데이터 + 성공메세지 전송
//                옵셔널객체.get() : 안에 있는 객체 꺼내기 함수
                return new ResponseEntity<>(ooptionalDelpt, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송 (클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//            서버에서 발생 메세지 전송 (클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    부서 정보 추가하는 함수(insert)
//    @RequestBody : 클라이언트에서 json 객체를 전송하면 스프링부트 함수에서 매개변수로 전달받음
    @PostMapping("/dept")
    public ResponseEntity<Object> createDept(@RequestBody Dept dept) {

        try {
            Dept dept2 = dept10Service.save(dept); // insert 문 호출

            return new ResponseEntity<>(dept2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    수정 실행 함수
    //    1) 클라이언트 : (form태그) Put 방식(url) -> 2) 서버 : @@PutMapping("url") -> 3) DB: update 요청
    @PutMapping("/dept/edit/{dno}")
    public ResponseEntity<Object> updateDept(@PathVariable int dno, @RequestBody Dept dept) {
        try {
//            매개변수 dept 안에 부서번호(기본키) 값이 있음 -> update 문 실행
            Dept dept2 = dept10Service.save(dept); // update 문 호출

            return new ResponseEntity<>(dept2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
