package com.example.jpacustomexam.repository.exam03;

import com.example.jpacustomexam.dto.Dept02GroupDto;
import com.example.jpacustomexam.dto.DeptGroup;
import com.example.jpacustomexam.dto.DeptGroupDto;
import com.example.jpacustomexam.model.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : DeptRepository
 * author : ds
 * date : 2022-10-20
 * description : JPA 페이징 처리 함수 만들기
 * 페이징 처리 ? 한번에 화면에 보여줄 개수를 1페이지로 정해서 프로그램에서 나타냄
 * page : 현재 페이지
 * size : 전체 페이지 수
 * currentpage : 현재 페이지 번호
 * totalItems : 전체 데이터 총건수
 * totalpages : 전체 페이지 수
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Repository
public interface Dept03Repository extends JpaRepository<Dept, Integer> {
//    exam03
//    1 : 쿼리 메소드 방식 이용
//    페이지 이용하는법 : 페이지 객체를 사용하면 jpa쿼리를 자동 생성함
//      1) pageable : 매개변수 객체 사용
//      2) page : 리턴값 사용
//    사용법 ex) page<클래스명> 함수명(Pageable pageable)
//    1) 전체 부서 정보 조회 시 페이징 처리 함수

    Page<Dept> findAllByOrderByDnoDesc(Pageable pageable);

    //    문제1) findall: 전체 부서조회 함수에 페이징 처리 로직을 추가하세요.
    Page<Dept> findAll(Pageable pageable);

    //    문제2) dname으로 like검색. 부서정보 조회 페이징 처리

    Page<Dept> findAllByDnameContaining(String dname, Pageable pageable);


//    #######################################################################
//    @Query를 이용한 페이징 처리
//    #######################################################################

    //    예제 : dname, loc로 like 검색을 하고, dname으로 정렬한 데이터를 페이징 처리하는 함수
//    1) nativeQuery = true 일 경우 : 일반 sql 문 사용할 경우
//     페이징 처리를 위해 옵션을 추가 countQuery = "카운트 쿼리"
//    3-1
    @Query(value = "select d.*  " +
            "from tb_dept d " +
            "where d.dname like %:dname% " +
            "and d.loc like %:loc% " +
            "order by d.dname"
            , countQuery = "select count(*)  " +
            "from tb_dept d " +
            "where d.dname like %:dname% " +
            "and d.loc like %:loc% " +
            "order by d.dname"
            , nativeQuery = true)
    Page<Dept> selectByDnameAndLocPage(@Param("dname") String dname,
                                       @Param("loc") String loc,
                                       Pageable pageable
    );


//    참고) 3-2 객체 쿼리
//    객체 쿼리 페이징 처리 : countQuery 옵션 생략(안씀)
//    객체 쿼리 : 테이블명 -> 클래스명, 컬럼명 -> 속성(필드)명, * 안씀, 대소문자 구분
//    @Query(value = "select d  " +
//            "from Dept d " +
//            "where d.dname like %:dname% " +
//            "and d.loc like %:loc% " +
//            "order by d.dname")
//    Page<Dept> selectByDnameAndLocPage(@Param("dname") String dname,
//                                       @Param("loc") String loc,
//                                       Pageable pageable
//    );


    //     문제 3)
//    결과출력 :
//    부서번호는 10
//    부서명은 ACCOUNTING
//    부서위치는 뉴욕
//    모든 부서정보를 출력했습니다.
    @Query(value = "select concat('부서번호는 ',d.dno) as dnoVar, " +
            "concat('부서명은 ',d.dname) as dnameVar, " +
            "concat('부서위치는 ',d.loc) as locVar, " +
            "'모든 부서정보를 출력했습니다.' as textVar " +
            "from tb_dept d "
            , countQuery = "select concat(*) " +
            "from tb_dept d "
            , nativeQuery = true)
    Page<Dept02GroupDto> selectByConcat(Pageable pageable);


    //    문제4) 아리 쿼리를 페이징 처리 로직을 추가해서 함수를 수정하세요.
    @Query(value = "select d.dno" +
            "     ,case when d.dno < 20 then '연말 보너스 : 100%'" +
            "     when d.dno > 20 then '연말 보너스 : 200%'" +
            "     else '연말 보너스 : 없음'" +
            "     end as incentive " +
            "from tb_dept d"
            , countQuery = "select * from tb_dept d"
            , nativeQuery = true)
    Page<DeptGroupDto> selectByCase(Pageable pageable);

}