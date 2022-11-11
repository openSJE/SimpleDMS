
package com.example.test.controller.test;

import com.example.test.model.test.Test;
import com.example.test.model.test.TestComment;
import com.example.test.repository.test.CommentRepository;
import com.example.test.service.test.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Dept03Controllder
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러
 * 요악 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
// @RestController : return 값이 json 데이터 형태로 출력됨
@Slf4j
@RestController
@RequestMapping("/test")
public class CommentController {

    @Autowired
    CommentService commentService;


//  B. 게시판 덧글




//    1) 글쓰기 (insert)
@PostMapping("/api/boards/comments")
public ResponseEntity<Object> createComment(@RequestBody Test test) {

    try {
        Test test2 = commentService.commentsave(test); // insert 문 호출

        return new ResponseEntity<>(test2, HttpStatus.OK);

    } catch (Exception e) {
        log.debug(e.getMessage());
        // 서버에러 발생 메세지 전송(클라이언트)
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    //    2) 조회하기
    @GetMapping("/api/boards/comments/{tno}")
    public ResponseEntity<Object> getTestId(@PathVariable int tno) {

        try {
            Optional<Test> ooptionalTest = commentService.findById(tno);

            if (ooptionalTest.isPresent() == true) {
//                데이터 + 성공메세지 전송
//                옵셔널객체.get() : 안에 있는 객체 꺼내기 함수
                return new ResponseEntity<>(ooptionalTest, HttpStatus.OK);
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



    //    3)삭제하기
    @DeleteMapping("/api/boards/comments/deletion/{id}")
    public ResponseEntity<Object> deleteComment ( @PathVariable int id){
        try {
//          id에 해당하는 부서정보를 삭제하는 함수 호출
            boolean bSuccess = commentService.removeByComment(id); // Delete 문 호출

            if (bSuccess == true) {
//            성공메세지 전송 (클라이언트)
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//            실패했을 경우 : id값이 존재하지 않을 때
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    //    4) update
    @PutMapping("/api/boards/comments/{id}")
    public ResponseEntity<Object> updateEmp ( @PathVariable int id, @RequestBody Test test){

        try {
//            매개변수 emp 안에 부서번호(기본키)값이 있음 -> update 문 실행
            Test test2 = commentService.saveCommentUpdate(test); // update 문 호출

            return new ResponseEntity<>(test2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}












