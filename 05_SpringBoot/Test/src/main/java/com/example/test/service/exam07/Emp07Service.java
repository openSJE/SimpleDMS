package com.example.jpacustomexam.service.exam07;



import com.example.jpacustomexam.model.exam04.Employee;
import com.example.jpacustomexam.repository.exam07.Emp07Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class Emp07Service {

    @Autowired
    Emp07Repository empRepository;

//    1)
//    조인 결과 쿼리 함수
    public List<Employee> querydslByEname(String ename) {
        List<Employee> list = empRepository.querydslByEname(ename);

        return list;
    }


//    2)
//    조인 결과 쿼리 함수
    public List<Employee> querydslByEnameAndJob(String ename, String job) {
        List<Employee> list = empRepository.querydslByEnameAndJob(ename, job);

        return list;
    }

}

