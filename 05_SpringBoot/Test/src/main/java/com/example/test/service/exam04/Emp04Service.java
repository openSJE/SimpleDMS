package com.example.jpacustomexam.service.exam04;


import com.example.jpacustomexam.dto.DeptEmpCDto;
import com.example.jpacustomexam.dto.DeptEmpDto;
import com.example.jpacustomexam.model.Emp;
import com.example.jpacustomexam.repository.exam03.Emp03Repository;
import com.example.jpacustomexam.repository.exam04.Emp04Repository;
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
public class Emp04Service {

    @Autowired
    Emp04Repository empRepository;


    public List<DeptEmpCDto> selectJoinEname(String ename1) {
        List<DeptEmpCDto> list = empRepository.selectJoinEname(ename1);

        return list;
    }

}










