package com.example.jpaexam.service.exam02;

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
public class Emp02Service {
    @Autowired
    EmpRepository empRepository;

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

}
