package com.example.test.service.test;



import com.example.test.model.Dept;
import com.example.test.model.test.Test;
import com.example.test.repository.test.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class TestService {

    @Autowired
    TestRepository testRepository;


//   A. 게시판 글

    //	1) insert 함수 (글쓰기)
    public Test saveInsert(Test test) {

        Test test2 = TestRepository.save(test); // insert 함수

        return test2;
    }

    //    2) 전체조회 함수 (목록보기)
    public List<Test> findAll(){
        List<Test> list = testRepository.findAll();

        return list;
    }


    //    3) ID로 조회 함수 (상세목록보기)
    public Optional<Test> findById(int tno){
        Optional<Test> optionalTest = testRepository.findById(tno); // select문 자동생성 DB전송

        return optionalTest;
    }





    //   4) id로(번호) 삭제 delete 함수(글삭제)
    public boolean removeById(int id) {

        if(testRepository.existsById(id) == true) {
            testRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    //    5)update 함수 (글수정)
    public Test saveUpdate(Test test) {

        Test test2 = testRepository.save(test);

        return test2;
    }


//    6)제목검색
    public List<Test> selectByTnameAndContent(String tname, String content){
        List<Test> list = testRepository.selectByTnameAndContent(tname,content);

        return list;
    }





//    B. 게시판 덧글


    //	1) insert 함수 (덧글쓰기)
    public Test commentsave(Test test) {

        Test test2 = TestRepository.save(test); // insert 함수

        return test2;
    }


    //    2) 전체조회 함수 (목록보기)
//    public Page<Test> findAll(){
//        Page<Test> page = testRepository.findAll();
//
//        return page;
//    }




//   3) id로(번호) 삭제 delete 함수(덧글삭제)
    public boolean removeByComment(int id) {

        if(testRepository.existsById(id) == true) {
            testRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


//    4)update 함수 (덧글수정)
    public Test saveCommentUpdate(Test test) {

        Test test2 = testRepository.save(test);

        return test2;
    }

}

