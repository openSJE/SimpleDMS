package com.example.jpacustomexam.service.exam03;


import com.example.jpacustomexam.dto.DeptGroup;
import com.example.jpacustomexam.model.Emp;
import com.example.jpacustomexam.repository.exam03.Emp03Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public class Emp03Service {

    @Autowired
    Emp03Repository empRepository;

//  1)
public Page<Emp> findAll(Pageable pageable) {
    Page<Emp> page = empRepository.findAll(pageable);

    return page;
}


//  2)
public Page<Emp> findAllByOrderByEnameDesc(Pageable pageable) {
    Page<Emp> page = empRepository.findAllByOrderByEnameDesc(pageable);

    return page;
}

//  3)
public Page<Emp> findAllBySalaryBetweenAndCommissionIsNotNull(int salary1, int salary2, Pageable pageable) {
    Page<Emp> page = empRepository.findAllBySalaryBetweenAndCommissionIsNotNull(salary1, salary2, pageable);

    return page;
}


//  4)
public Page<Emp> findAllByEnameContaining(String ename, Pageable pageable) {
    Page<Emp> page = empRepository.findAllByEnameContaining(ename, pageable);

    return page;
}


//  5)
public Page<Emp> findAllByDnoAndSalaryGreaterThan(int dno, int salary, Pageable pageable) {
    Page<Emp> page = empRepository.findAllByDnoAndSalaryGreaterThan(dno, salary, pageable);

    return page;
}


//  6)
public Page<Emp> selectBySalry(int salary1, int salary2, Pageable pageable) {
    Page<Emp> page = empRepository.selectBySalry(salary1, salary2, pageable);

    return page;
}



//  7)
public Page<Emp> selectByHiredate(String hire1, String hire2, Pageable pageable) {
    Page<Emp> page = empRepository.selectByHiredate(hire1, hire2, pageable);

    return page;
}



//  8)
public Page<Emp> selectBydno(int salary1, int salary2, int dno1, int dno2, Pageable pageable) {
    Page<Emp> page = empRepository.selectBydno(salary1, salary2, dno1, dno2, pageable);

    return page;
}



//  9)
public Page<Emp> selectByHire(String hire1, Pageable pageable) {
    Page<Emp> page = empRepository.selectByHire(hire1, pageable);

    return page;
}

//  10)
public Page<Emp> selectByCommission(int date1, Pageable pageable) {
    Page<Emp> page = empRepository.selectByCommission(date1, pageable);

    return page;
}

}










