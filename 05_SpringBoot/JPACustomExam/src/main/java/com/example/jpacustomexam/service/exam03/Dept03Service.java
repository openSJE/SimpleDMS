package com.example.jpacustomexam.service.exam02;

import com.example.jpacustomexam.dto.Dept02GroupDto;
import com.example.jpacustomexam.dto.DeptGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.repository.DeptRepository;
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
public class Dept02Service {

    @Autowired
    DeptRepository deptRepository; // JPA CRUD 함수가 있는 인터페이스

//    1)
    public List<Dept> selectByDname(String dname){
        List<Dept> list = deptRepository.selectByDname(dname);

        return list;
    }

//    2)
    public List<Dept> selectDnameLoc(String dname, String loc){
        List<Dept> list = deptRepository.selectByDnameAndLoc(dname,loc);

        return list;
    }

//    3)
    public List<DeptGroupDto> selectByGroupFunc(){
        List<DeptGroupDto> list = deptRepository.selectByGroupFunc();

        return list;
    }


//    4)
    public List<Dept02GroupDto> selectByConcat(){
        List<Dept02GroupDto> list = deptRepository.selectByConcat();

        return list;
    }


//    5)
    public List<DeptGroupDto> selectByBasicFunc(){
        List<DeptGroupDto> list = deptRepository.selectByBasicFunc();

        return list;
    }


//    6)
    public List<DeptGroupDto> selectByCase(){
        List<DeptGroupDto> list = deptRepository.selectByCase();

        return list;
    }
}



