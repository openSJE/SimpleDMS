

package com.example.jpaexam.controller.exam07;

import com.example.jpaexam.model.Emp;
import com.example.jpaexam.service.exam07.Emp07Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
@RequestMapping("/exam07")
public class Emp07Controller {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    Emp07Service emp07Service; // @Autowired : Springboot 가 가동될 때 생성된 객체를 하나 받아오기

    //    1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @@GetMapping("url") -> 3) DB: select 요청
    @GetMapping("/emp")
    public ResponseEntity<Object> getEmpAll() {

        try {
            List<Emp> list = emp07Service.findAll();

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


}
