package com.example.modelexam.service.exam08;

import com.example.modelexam.dao.MemberDao;
import com.example.modelexam.model.Dept;
import com.example.modelexam.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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
public class Member08Service {

    @Autowired
    MemberDao memberDao;

    public List<Member> findAll() {
        List<Member> list = memberDao.selectAll(); // db접근 모든 데이터 가져오기 함수 실행

//        다른 업무로직이 들어갈 수 있으나 지금은 생략
        return list;
    }

    //    부서 id로 조회하는 함수
    public Optional<Member> findById(long eno) {

        Member member = memberDao.selectById(eno);

//       null 체크 객체 사용
//        of : null이 없는게 확실
//        ofNullable : null이 없을수도 있을 수도
        Optional<Member> optionalMember = Optional.ofNullable(member);

        return optionalMember;
    }

//    public List<Member> save(Member member) {
//        List<Member> list = memberDao.insert(member); // 새로운 부서 정보 db 저장
//
//        return list;
//    }

    //    부서 정보를 저장하는 함수
    public List<Member> save(Member member) {

        List<Member> list = null;

//       .getDno() 없으면 insert 문 실행
//       있으면 update문 실행
        if(member.getEno() == null) {
//            1)부서번호 자동생성
            int count = memberDao.selectAll().size(); // list 배열의 전체 크기(건수)
            int newEno = (count + 8000);
            member.setEno(newEno); // 객체에 새로운 부서번호 저장

//            2) 생성 날짜 추가

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//          dept 객체의 insertTime 속성에 현재 날짜 저장
            member.setInsertTime(LocalDateTime.now().format(dtf)); // 현재 데이터 생성시간 넣기

            list = memberDao.insert(member); // 새로운 부서 정보 db 저장
        } else{
//            1) 수정 날짜 추가
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//          dept 객체의 updateTime 속성에 현재 날짜 저장
            member.setUpdateTime((LocalDateTime.now().format(dtf))); // 현재 데이터 생성시간 넣기

            list = memberDao.update(member); // 부서 정보 db 수정

        }

        return list;
    }
    //   eno로부터 부서 정보 삭제 함수
    public boolean removeById(int eno){

        int iCount = memberDao.deleteById(eno); // db삭제함수 호출, 리턴값 : 삭제 건수

        return (iCount>0)? true : false;
    }


}
