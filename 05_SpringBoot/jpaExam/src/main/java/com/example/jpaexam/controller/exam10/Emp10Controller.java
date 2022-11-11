

package com.example.jpaexam.controller.exam09;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.model.Emp;
import com.example.jpaexam.service.exam09.Emp09Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
@RestController
@RequestMapping("/exam09")
public class Emp09Controller {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    Emp09Service emp09Service; // @Autowired : Springboot 가 가동될 때 생성된 객체를 하나 받아오기

    //    1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @@GetMapping("url") -> 3) DB: select 요청
    @GetMapping("/emp")
    public ResponseEntity<Object> getEmpAll() {

        try {
            List<Emp> list = emp09Service.findAll();

            if (list.isEmpty() == false){
//                데이터 + 성공메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
            }else {
//                데이터 없음 메세지 전송 (클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            log.debug(e.getMessage());
//            서버에서 발생 메세지 전송 (클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //    id로 조회(select) 하는 함수
    @GetMapping("/emp/{eno}")
    public ResponseEntity<Object> getEmpId(@PathVariable int eno) {

        try {
            Optional<Emp> ooptionalDelpt = emp09Service.findById(eno);

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
    @PostMapping("/emp")
    public ResponseEntity<Object> createEmp(@RequestBody Emp emp) {

        try {
            Emp emp2 = emp09Service.save(emp); // insert 문 호출

            return new ResponseEntity<>(emp2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
