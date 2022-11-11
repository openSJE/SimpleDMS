package com.example.modelexam.service.exam01;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam01
 * fileName : DeptService
 * author : ds
 * date : 2022-10-17
 * description : 부서 업무 로직을 작성할 함수가 있는 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-17         ds          최초 생성
 */
// Service : 업무로직(Business logic) 실행할 클래스,
//    주로 DAO(DB 접속 함수들 모임 클래스(CRUD) ) 객체를 이용해서 업무로직을 코딩함
//    DAO(Repository) : DB에 직접 접근해서 정보를 추가/검색/수정/삭제하는 함수들이 있는 클래스 
//    @Service : 스프링 컨테이너 박스에 대상 객체를 생성함 (스프링 서버가 가동될 때)
//    참고) 만들어진 객체들은 전부 싱글톤(공유 객체)
//    메모리 절약 / 성능 향상 -> 싱글톤으로 만듦
    @Service
public class DeptService {

//   부서 DAO 객체가 필요함 : 부서 DB에 접근하기 위해
    @Autowired
    DeptDao deptDao; // 스프링부트 컨테이너에 생성된 deptDao 이름의(객체자료형) 객체를 하나 받아옴

//    모든 부서 데이터를 조회하는 함수
    public List<Dept> findAll() {
        List<Dept> list = deptDao.selectAll(); // db접근 모든 데이터 가져오기 함수 실행

//        다른 업무로직이 들어갈 수 있으나 지금은 생략
        return list;
    }
}
