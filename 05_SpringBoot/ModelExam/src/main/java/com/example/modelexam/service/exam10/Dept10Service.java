package com.example.modelexam.service.exam09;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.service.exam01
 * fileName : DeptService
 * author : ds
 * date : 2022-10-17
 * description : 부서 업무 로직을 작성할 함수가 있는 클래스, save() 함수 추가
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
// Service : 업무로직(Business logic) 실행할 클래스,
//    주로 DAO( DB 접속 함수들 모임 클래스(CRUD) ) 객체를 이용해서 업무 로직을 코딩함
// DAO(Repository) : DB에 직접 접근해서 정보를 추가/검색/수정/삭제하는(CRUD) 함수들이 있는 클래스
// @Service : 스프링 컨테이너 박스에 대상 객체를 생성함 ( 스프링 서버가 가동될 때 )
//    참고) 만들어진 객체들은 전부 싱글톤(공유 객체)
//    메모리 절약 / 성능 향상 -> 싱글톤으로 만듬
// Service : 업무로직(Business logic) 실행할 클래스,
//    주로 DAO( DB 접속 함수들 모임 클래스(CRUD) ) 객체를 이용해서 업무 로직을 코딩함
// DAO(Repository) : DB에 직접 접근해서 정보를 추가/검색/수정/삭제하는(CRUD) 함수들이 있는 클래스
// @Service : 스프링 컨테이너 박스에 대상 객체를 생성함 ( 스프링 서버가 가동될 때 )
//    참고) 만들어진 객체들은 전부 싱글톤(공유 객체)
//    메모리 절약 / 성능 향상 -> 싱글톤으로 만듬
@Service
public class Dept09Service {

    // 부서 DAO 객체가 필요함 : 부서 DB에 접근하기 위해
    @Autowired
    DeptDao deptDao; // 스프링부트 컨테이너에 생성된 deptDao 이름의(객체자료형) 객체를 하나 받아옴

    //    모든 부서 데이터를 조회하는 함수
    public List<Dept> findAll() {
        List<Dept> list = deptDao.selectAll(); // db 접근 모든 데이터 가져오기 함수 실행

//        다른 업무로직 들어갈 수 있으나 지금은 생략
        return list;
    }

    //    부서 ID로 조회하는 함수
    public Optional<Dept> findById(long dno) {

        Dept dept = deptDao.selectById(dno);

//       null 체크 객체 사용
//        of : null이 없는게 확실
//        ofNullable : null이 없을수도 있을 수도
        Optional<Dept> optionalDept = Optional.ofNullable(dept);

        return optionalDept;
    }

    //    부서 정보를 저장하는 함수
    public List<Dept> save(Dept dept) {

        List<Dept> list = null;

//       .getDno() 없으면 insert 문 실행
//       있으면 update문 실행
        if(dept.getDno() == null) {
//            1)부서번호 자동생성
            int count = deptDao.selectAll().size(); // list 배열의 전체 크기(건수)
            int newDno = (count + 1) * 10; // 10씩 증가하게 만듬 (새로운 부서번호)
            dept.setDno(newDno); // 객체에 새로운 부서번호 저장

//            2) 생성 날짜 추가

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//          dept 객체의 insertTime 속성에 현재 날짜 저장
            dept.setInsertTime(LocalDateTime.now().format(dtf)); // 현재 데이터 생성시간 넣기

            list = deptDao.insert(dept); // 새로운 부서 정보 db 저장
        } else{
//            1) 수정 날짜 추가
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//          dept 객체의 updateTime 속성에 현재 날짜 저장
            dept.setUpdateTime((LocalDateTime.now().format(dtf))); // 현재 데이터 생성시간 넣기

            list = deptDao.update(dept); // 부서 정보 db 수정

        }

        return list;
    }

//   dno로부터 부서 정보 삭제 함수
    public boolean removeById(int dno){

        int iCount = deptDao.deleteById(dno); // db삭제함수 호출, 리턴값 : 삭제 건수

        return (iCount>0)? true : false;
    }
}



