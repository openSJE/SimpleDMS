package com.example.jpaexam.service.exam01;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    DeptRepository deptRepository;

//    전체조회 함수
    public List<Dept> findAll(){
        List<Dept> list = deptRepository.findAll();

        return list;
    }
}
