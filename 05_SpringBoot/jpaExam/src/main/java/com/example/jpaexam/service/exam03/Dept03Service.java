package com.example.jpaexam.service.exam02;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.repository.DeptRepository;
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
public class Dept02Service {
    @Autowired
    DeptRepository deptRepository;

//    전체조회 함수
    public List<Dept> findAll(){
        List<Dept> list = deptRepository.findAll(); // JPA CRUD 함수가 있는 인터페이스

        return list;
    }

//    ID로 조회 함수
    public Optional<Dept> findById(int dno){
        Optional<Dept> optionalDept = deptRepository.findById(dno); // select문 자동생성 DB전송

        return optionalDept;
    }
}
