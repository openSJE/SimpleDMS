
package com.example.simpledms2.controller;

import com.example.simpledms2.model.Dept;
import com.example.simpledms2.service.DeptService;
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
 * 요악 :
 *      쿼리 메소드 : 자동으로 자용자 정의 sql문을 생성해주는 함수
 *            목적 : 기본 함수보다 다양한 sql문을 작성하기 위해 사용
 *          사용법 : 함수 이름으로 sql 문장을 작성함 (Repository 안에 함수명만 작성)
 *          ex)  JPA 클래스 == 대상 테이블
 *               find == select
 *               all == *
 *               by == from
 *              속성 == where 컬럼
 *               orderBy == order by
 *              속성 desc == 컬럼 desc
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
// @RestController : return 값이 json 데이터 형태로 출력됨
@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용못함
// @CrossOrigin(허용할_사이트주소(Vue 사이트주소:포트)) : CORS 보안을 허용해주는 어노테이션
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DeptController {

    @Autowired
    DeptService deptService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    @GetMapping("/dept")
    public ResponseEntity<Object> getDeptAll() {

        try {
            List<Dept> list = deptService.findAll();

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("/dept/all")
    public ResponseEntity<Object> removeAll() {

        try {
            deptService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}



