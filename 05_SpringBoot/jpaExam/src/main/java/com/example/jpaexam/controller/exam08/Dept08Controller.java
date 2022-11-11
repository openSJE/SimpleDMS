package com.example.jpaexam.controller.exam07;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.service.exam07.Dept07Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/exam07")
public class Dept07Controller {

//    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    Dept07Service dept07Service; // @Autowired : Springboot 가 가동될 때 생성된 객체를 하나 받아오기

//    1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @@GetMapping("url") -> 3) DB: select 요청
    @GetMapping("/dept")
    public ResponseEntity<Object> getDeptAll() {

        try {
            List<Dept> list = dept07Service.findAll();

            if (list.isEmpty() == false){
//                데이터 + 성공메세지 전송
                return new ResponseEntity<>(list,HttpStatus.OK);
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
