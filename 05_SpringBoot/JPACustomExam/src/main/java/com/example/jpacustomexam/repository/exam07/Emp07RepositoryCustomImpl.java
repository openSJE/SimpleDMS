package com.example.jpacustomexam.repository.exam07;

import com.example.jpacustomexam.model.exam04.Department;
import com.example.jpacustomexam.model.exam04.QDepartment;
import com.example.jpacustomexam.model.exam04.QEmployee;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.repository.exam07
 * fileName : Dept07RepositoryCustomimpl
 * author : ds
 * date : 2022-10-27
 * description : Querydsl Custom 구현클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-27         ds          최초 생성
 */
public class Dept07RepositoryCustomImpl implements Dept07RepositoryCustom{

    //    JPAQueryFactory
    @Autowired
    private JPAQueryFactory queryFactory;

    //    Querydsl 을 위한 Q객체 가져오기
//    Querydsl 은 Q객체로 쿼리를 사용함
    private QDepartment department = QDepartment.department;
    private QEmployee employee = QEmployee.employee;

    //    1) dname like 검색하는 함수 정의
//   체이닝 이용: .함수().함수()
    @Override
    public List<Department> querydslByDname(String dname) {

        List<Department> list = queryFactory
                .selectFrom(department)
                .where(
                        department.dname.contains(dname)
                )
                .fetch(); // 마지막에 항상 실행(조회 실행)

        return list;
    }

//    2) 예제 : Dname & loc 로 like 검색하는 함수
    @Override
    public List<Department> querydslByDnameAndLoc(String dname, String loc){

//        select * from tb_department where dname like '%%' and loc like '%%';
//        querydsl 사용법 :
//        queryFactory
//        .select(DTO(컬럼1,컬럼2)) == select 컬럼1, 컬럼2...
//        .selectFrom == select *
//        .where(조건) == where
//          조건 -> department.속성.연산자(값) == where 컬럼 연산자(in, like, =, > 등)
//          연산자() : in(), gt() == >(크다) , eq() : 같다(==), lt() : < (작다)
//        .orderBy() : order by
//        .groupBy() : group by
//        구글 검색 생활화!!! 나머지는 구글 검색 참고.
//        to. 미래의 정은이에게 , 이걸 보고있니...힘들지?...화이팅..
        List<Department> list = queryFactory
                .selectFrom(department)
                .where(
                        department.dname.contains(dname)
                                .and(department.loc.contains(loc))
                )
                .fetch(); // 마지막에 항상 실행(조회 실행)

        return list;


    }
}
