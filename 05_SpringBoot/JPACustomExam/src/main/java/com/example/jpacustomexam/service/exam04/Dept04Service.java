package com.example.jpacustomexam.service.exam03;


import com.example.jpacustomexam.dto.Dept02GroupDto;
import com.example.jpacustomexam.dto.DeptGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.repository.exam03.Dept03Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public class Dept03Service {

    @Autowired
    Dept03Repository deptRepository; // JPA CRUD 함수가 있는 인터페이스

    //    0)
    public Page<Dept> findAllByOrderByDnoDesc(Pageable pageable) {
        Page<Dept> page = deptRepository.findAllByOrderByDnoDesc(pageable);

        return page;
    }


    //    1)
    public Page<Dept> findAll(Pageable pageable) {
        Page<Dept> page = deptRepository.findAll(pageable);

        return page;
    }


    //    2)
    public Page<Dept> findAllByDnameContaining(String dname, Pageable pageable) {
        Page<Dept> page = deptRepository.findAllByDnameContaining(dname, pageable);

        return page;
    }


    //    3) @Query 이용 페이징 처리 함수
    public Page<Dept> selectByDnameAndLocPage(String dname,
                                              String loc,
                                              Pageable pageable) {

        Page<Dept> page = deptRepository.selectByDnameAndLocPage(dname, loc, pageable);

        return page;
    }



    public Page<Dept02GroupDto> selectByConcat(Pageable pageable) {

        Page<Dept02GroupDto> page = deptRepository.selectByConcat(pageable);

        return page;
    }


//    4)
    public Page<DeptGroupDto> selectByCase(Pageable pageable) {

        Page<DeptGroupDto> page = deptRepository.selectByCase(pageable);

        return page;
    }
}





