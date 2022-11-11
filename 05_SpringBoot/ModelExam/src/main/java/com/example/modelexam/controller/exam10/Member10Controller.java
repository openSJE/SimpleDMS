package com.example.modelexam.controller.exam09;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam08.Member08Service;
import com.example.modelexam.service.exam09.Member09Service;
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
// @RequestMapping(공통url)
@RequestMapping("/exam09")
public class Member09Controller {

    @Autowired
    Member09Service memberService; // 스프링에서 생성된 객체 받아오기

    @GetMapping("/member")
    public ResponseEntity<Object> getMemberAll() {
        try {
            List<Member> list = memberService.findAll();

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

    //    멤버번호(eno)로 조회하기 함수
    @GetMapping("/member/{eno}")
    public ResponseEntity<Object> getMemberId(@PathVariable long eno) {

        try {
            Optional<Member> optionalMember = memberService.findById(eno);

            if (optionalMember.isPresent() == true) {
//                성공 메세지 + 객체 전송
//                optional객체.get() : optional 객체안에 들어있는 객체가 나옴
                return new ResponseEntity<>(optionalMember.get(), HttpStatus.OK);
            } else {
//                데이터가 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.info(e.getMessage()); // 에러 로그 찍기
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 내부 서버 에러 메세지
        }

    }

    //    새로운 멤버 정보 생성 함수 : insert 함수( @PostMapping )
//    @RequestBody : 클라이언트 쪽에서 전송한 객체정보를(json데이터) 매개변수로(부서객체) 전달
    @PostMapping("/member")
    public ResponseEntity<Object> createMember(@RequestBody Member member) {

        try {
//            .save(객체) : 객체에 키(부서번호)가 없으면 insert, 있으면 update 로직이 있음
            List<Member> list = memberService.save(member);

            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception e) {
            log.info(e.getMessage()); // 에러발생시 에러 메세지 콘솔 출력
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 서버 에러 메세지전송
        }
    }

}
