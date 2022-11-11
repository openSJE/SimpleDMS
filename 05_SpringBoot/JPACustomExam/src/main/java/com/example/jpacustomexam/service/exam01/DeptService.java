package com.example.jpaexam.service.exam11;

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
public class Dept11Service {

    @Autowired
    DeptRepository deptRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수
    public List<Dept> findAll() {
        List<Dept> list = deptRepository.findAll();

        return list;
    }

    //    id로 조회 함수
    public Optional<Dept> findById(int dno) {
        Optional<Dept> optionalDept = deptRepository.findById(dno); // select 문 자동 생성 DB 전송

        return optionalDept;
    }

    //    insert 함수
//    update 함수
    public Dept save(Dept dept) {
//        JPA .save() 함수의 특징
//        1) 기본키값이(부서번호) 없으면 insert
//        2) 기본키값이(부서번호) 있으면 update
        Dept dept2 = deptRepository.save(dept); // insert 함수

        return dept2;
    }

    //    id로(부서번호) 삭제 delete 함수
    public boolean removeById(int id) {

//        먼저 id에 해당하는 값이 있는 지 select 해서 있으면 delete , true
        if(deptRepository.existsById(id) == true) {
            deptRepository.deleteById(id);
            return true;
        } else {
            //        없으면 스킵 , false
            return false;
        }
    }
}



