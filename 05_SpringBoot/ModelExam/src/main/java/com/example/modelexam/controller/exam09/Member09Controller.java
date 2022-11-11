package com.example.modelexam.controller.exam08;

import com.example.modelexam.model.Dept;
import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam07.Member07Service;
import com.example.modelexam.service.exam08.Member08Service;
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
 * fileName : Member07Controller
 * author : ds
 * date : 2022-10-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-18         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/exam08")
public class Member08Controller {
    @Autowired
    Member08Service memberService; // 스프링에서 생성된 객체 받아오기 ( @Autowired )

    @GetMapping("/member")
    public ResponseEntity<Object> getMemberAll() {

        try {
            List<Member> list = memberService.findAll(); // 전체 부서 정보 조회

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
    @GetMapping("/member/{eno}")
    public ResponseEntity<Object> getMemberId(@PathVariable long eno){

        try {
            Optional<Member> optionalMember = memberService.findById(eno); // 전체 부서 정보 조회

            if(optionalMember.isPresent() == true) {
//                성공 메세지 + 객체 전송
//                옵셔널 객체.get() : 옵셔널 객체 안에 들어있는
                return new ResponseEntity<>(optionalMember.get(), HttpStatus.OK);
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
