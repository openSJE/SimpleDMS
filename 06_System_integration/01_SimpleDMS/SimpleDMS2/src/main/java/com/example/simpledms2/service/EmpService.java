package com.example.simpledms2.service;

import com.example.simpledms2.model.Dept;
import com.example.simpledms2.repository.DeptRepository;
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
public class DeptService {

    @Autowired
    DeptRepository deptRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수
    public List<Dept> findAll() {
        List<Dept> list = deptRepository.findAll();

        return list;
    }
    
    public void removeAll(){
        deptRepository.deleteAll(); // 전체삭제
    }

}



