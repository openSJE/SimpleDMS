package com.example.jpacustomexam.repository.exam03;


import com.example.jpacustomexam.dto.DeptGroup;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.model.Emp;
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
 * description : JPA CRUD를 위한 인터페이스(==DAO)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Repository
public interface Emp03Repository extends JpaRepository<Emp, Integer> {

    //    1) Emp 테이블을 전체 조회하는 findAll() 함수에 페이징 처리 로직을 추가하세요.
    Page<Emp> findAll(Pageable pageable);

//    2) ename 으로 내림차순 정렬해서 전체 사원 정보를 출력하는 함수를 정의하세요.
//    단, 페이징 처리 로직을 추가하세요.

    Page<Emp> findAllByOrderByEnameDesc(Pageable pageable);


//    3) salary 가 1000 ~ 1500 사이이고 Commission 이 not null 일 때 함수를 정의하세요.
//    단, 페이징 처리 로직을 추가하세요.

    Page<Emp> findAllBySalaryBetweenAndCommissionIsNotNull(int salary1, int salary2, Pageable pageable);


//    4) ename like 검색하고 결과를 페이징하는 함수를 작성하세요.

    Page<Emp> findAllByEnameContaining(String ename, Pageable pageable);


    //    5) 10번 부서에 해당하고 salary 가 1000 이상인 결과를 조회하는 함수를 작성하세요.
    //    단, 페이징 처리 로직을 추가하세요.
    Page<Emp> findAllByDnoAndSalaryGreaterThan(int dno, int salary, Pageable pageable);


    //    @Query 작성하세요
//    문제6) 급여가 2000 ~ 3000 사이에 포함되지 않는 사원을 출력하는 함수를 작성하세요.
//    nativeQuery = true 일 경우 (일반 sql문 작성) countQuery 필요(페이징 추가하려면)
    @Query(value = "select e.* " +
            "from tb_emp e " +
            "where e.salary " +
            "not between :salary1 AND :salary2"
            , countQuery = "select count(*) " +
            "from tb_emp e"
            , nativeQuery = true)
    Page<Emp> selectBySalry(@Param("salary1") int salary1, @Param("salary2") int salary2, Pageable pageable);


    //    문제 7) 1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한 사원을 출력하는 함수를 작성하세요.
    //    단, 페이징 처리 로직을 추가하세요.
    @Query(value = "select e.* " +
            "from tb_emp e " +
            "where e.hiredate " +
            "between :hire1 AND :hire2 "
            , countQuery = "select count(*) " +
            "from tb_emp e "
            , nativeQuery = true)
    Page<Emp> selectByHiredate(@Param("hire1") String hire1, @Param("hire2") String hire2, Pageable pageable);


    //    문제 8) 월급여 1000 ~ 3000 사이의 사원 중 부서번호 10, 20번인 사원을 출력하는 함수를 작성하세요.
//           단, 페이징 처리하세요.
    @Query(value = "select e.* " +
            "from tb_emp e " +
            "where (e.salary between :salary1 AND :salary2) " +
            "and e.dno in (:dno1, :dno2) "
            , countQuery = "select count(*) " +
            "from tb_emp e "
            , nativeQuery = true)
    Page<Emp> selectBydno(@Param("salary1") int salary1, @Param("salary2") int salary2,
                          @Param("dno1") int dno1, @Param("dno2") int dno2, Pageable pageable);


    //    문제 9) 1981년에 입사한 사원을 출력하세요.
//    단 페이징 처리 하세요.
    @Query(value = "select e.* " +
            "from tb_emp e " +
            "where e.hiredate like %:hire1%"
            , countQuery = "select count(*) " +
            "from tb_emp e "
            , nativeQuery = true)
    Page<Emp> selectByHire(@Param("hire1") String hire1, Pageable pageable);


//    문제 10) 커미션(Commission) 이 500 이상인 사원의 정보를 출력하는 함수를 작성하세요.
//    단, 페이징 처리 하세요
@Query(value = "select e.* " +
        "from tb_emp e " +
        "where commission > :date1"
        , countQuery = "select count(*) " +
        "from tb_emp e "
        , nativeQuery = true)
Page<Emp> selectByCommission(@Param("date1") int date1, Pageable pageable);


}



