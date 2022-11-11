package com.example.jpacustomexam.service.exam01;

import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.model.Emp;
import com.example.jpacustomexam.repository.EmpRepository;
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
public class EmpService {

    @Autowired
    EmpRepository empRepository;

    //    전체 사원 조회 함수
    public List<Emp> findAll() {
        List<Emp> list = empRepository.findAll();

        return list;
    }

    //    전체 사원 조회 함수
    public List<Emp> findAllByOrderByEnoDesc() {
        List<Emp> list = empRepository.findAllByOrderByEnoDesc();

        return list;
    }

    //    전체 사원 조회 함수
    public List<Emp> findAllByEnameContainingOrderByEnameDesc(String ename) {
        List<Emp> list = empRepository.findAllByEnameContainingOrderByEnameDesc(ename);

        return list;
    }

    //    전체 사원 조회 함수
    public List<Emp> findAllByJobContainingOrderByJobDesc(String ename) {
        List<Emp> list = empRepository.findAllByJobContainingOrderByJobDesc(ename);

        return list;
    }
    //    전체 사원 조회 함수
    public List<Emp> findAllByJobDno(String job, int dno) {
        List<Emp> list = empRepository.findAllByJobAndDno(job, dno);

        return list;
    }


    //    5)
    public List<Emp> findAllBySalaryBetween(int salary1, int salary2) {
        List<Emp> list = empRepository.findAllBySalaryBetweenOrderByEname(salary1, salary2);

        return list;
    }




    //    6)
    public List<Emp> findAllByJobIgnoreCase(String job) {
        List<Emp> list = empRepository.findAllByJobIgnoreCase(job);

        return list;
    }




    //    7)
    public List<Emp> findAllBynotnull() {
        List<Emp> list = empRepository.findAllByCommissionNotNull();

        return list;
    }



    //    8)
    public List<Emp> findAllByOrderBYDescAsc() {
        List<Emp> list = empRepository.findAllByOrderBySalaryDescEnameAsc();

        return list;
    }



    //    9)
    public List<Emp> LessThanSalaryGreaterThan(int first, int last) {
        List<Emp> list = empRepository.findAllBySalaryLessThanOrSalaryGreaterThan(first, last);

        return list;
    }




    //    10)
    public List<Emp> orCommission(int first, int middle, int last) {
        List<Emp> list = empRepository.findAllByCommissionOrCommissionOrCommission(first, middle, last);

        return list;
    }


}










