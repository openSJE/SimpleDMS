package com.example.jpaexam.service.exam08;

import com.example.jpaexam.model.Emp;
import com.example.jpaexam.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : DeptService
 * author : ds
 * date : 2022-10-20
 * description : 부서업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class Emp08Service {
    @Autowired
    EmpRepository empRepository;

//    3) 연습문제 :
//    Emp 컨트롤러/서비스 클래스의 .save() 함수를 추가하세요.
//    컨트롤러에서 Rest Client 테스트하세요.
//    단, 컨트롤러 함수는 json 데이터로 리턴하세요.

//    전체조회 함수
    public List<Emp> findAll(){
        List<Emp> list = empRepository.findAll();

        return list;
    }

    //    ID로 조회 함수
    public Optional<Emp> findById(int eno){
        Optional<Emp> optionalEmp = empRepository.findById(eno); // select문 자동생성 DB전송

        return optionalEmp;
    }

    //    insert 함수 만들기
    public Emp save(Emp emp) {
//        JPA .save() 함수의 특징
//        1) 키값이(부서번호) 없으면 insert
//        2) 키값이(부서번호) 있으면 update
        Emp emp2 = empRepository.save(emp); // insert 함수

        return emp2;
    }

    //   id로(부서번호) 삭제 delete 함수
    public void removeById(int id){
        empRepository.deleteById(id);
    }

}
