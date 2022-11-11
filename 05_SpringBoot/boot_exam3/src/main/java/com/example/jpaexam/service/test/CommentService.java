package com.example.test.service.test;



import com.example.test.model.test.Test;
import com.example.test.repository.test.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : Dept02Service
 * author : ds
 * date : 2022-10-20
 * description : 부서업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;



//    B. 게시판 덧글


    //	1) insert 함수 (덧글쓰기)
    public Test commentsave(Test test) {

        Test test2 = commentRepository.save(test); // insert 함수

        return test2;
    }


    //    2) 전체조회 함수 (목록보기)
    public Optional<Test> findById(int tno){
        Optional<Test> optionalTest = commentRepository.findById(tno); // select문 자동생성 DB전송

        return optionalTest;
    }




//   3) id로(번호) 삭제 delete 함수(덧글삭제)
    public boolean removeByComment(int id) {

        if(commentRepository.existsById(id) == true) {
            commentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


//    4)update 함수 (덧글수정)

        public Test saveCommentUpdate(Test test) {

            Test test2 = commentRepository.save(test);

            return test2;
        }


    }

