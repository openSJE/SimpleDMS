package com.example.jpacustomexam.service.exam02;

import com.example.jpacustomexam.dto.Dept03GroupDto;
import com.example.jpacustomexam.dto.DeptGroup;
import com.example.jpacustomexam.model.Emp;
import com.example.jpacustomexam.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
public class Emp02Service {

    @Autowired
    EmpRepository empRepository;



    //    1)
    public List<Emp> selectByEname(String ename){
        List<Emp> list = empRepository.selectByEname(ename);

        return list;
    }




    //    2)
    public List<Emp> selectByEnameSalary(){
        List<Emp> list = empRepository.selectByEnameSalary();

        return list;
    }




    //    3)
    public List<Emp> selectByCommission(int value){
        List<Emp> list = empRepository.selectByCommission(value);

        return list;
    }




    //    4)
    public List<Emp> selectByHiredate(){
        List<Emp> list = empRepository.selectByHiredate();

        return list;
    }


    //    5)
    public List<DeptGroup> selectByEnoJob(){
        List<DeptGroup> list = empRepository.selectByEnoJob();

        return list;
    }



    //    )
    public List<DeptGroup> selectByavg(){
        List<DeptGroup> list = empRepository.selectByavg();

        return list;
    }


    //    7)
    public List<DeptGroup> selectByEno(){
        List<DeptGroup> list = empRepository.selectByEno();

        return list;
    }



    //    8)
    public List<DeptGroup> selectByNotManager(){
        List<DeptGroup> list = empRepository.selectByNotManager();

        return list;
    }


    //    9)
    public List<DeptGroup> selectByCount(){
        List<DeptGroup> list = empRepository.selectByCount();

        return list;
    }


    //    10)
    public List<DeptGroup> selectByHire(){
        List<DeptGroup> list = empRepository.selectByHire();

        return list;
    }


}










