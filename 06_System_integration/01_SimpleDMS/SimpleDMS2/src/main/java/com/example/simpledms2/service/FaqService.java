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

//    부서 정보 저장/수정 함수
    public Dept save(Dept dept) {
        Dept dept2 = deptRepository.save(dept);

        return dept2;
    }
    
    
//    부서번호로 조회하는 함수
    public Optional<Dept> findById(int dno){

//        findById(기본키)
        Optional<Dept> optionalDept = deptRepository.findById(dno);

        return optionalDept;
    }



//  dno로 삭제하는 함수
    public boolean removeById(int dno){

//        findById(기본키)
        if (deptRepository.existsById(dno) == true){
            deptRepository.deleteById(dno);
            return true;
        }
//        없으면 그냥 false
        return false;
    }


    //    dname like 검색 함수
    public List<Dept> findAllByDnameContaining(String dname) {
        List<Dept> list = deptRepository.findAllByDnameContaining(dname);

        return list;
    }
}




