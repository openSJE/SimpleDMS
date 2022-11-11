package com.example.jpacustomexam.repository;


import com.example.jpacustomexam.dto.Dept03GroupDto;
import com.example.jpacustomexam.dto.DeptGroup;
import com.example.jpacustomexam.dto.DeptGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.model.Emp;
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
// @Service, @Repository, @Component : 서버가 가동될 때 객체를 자동 생성해주는 어노테이션
//    JpaRepasitory<모델(엔티티)명, @ID의 속성자료형> : JPA 인터페이스를 상속받아야 CRUD 함수를 사용가능
@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
    //    JPQl 함수를 사용할 수 있음 : 응용
//    @Query, 쿼리메소드
//    쿼리 메소드 연습문제 :
//    1) Eno 속성(컬럼)에 대해서 내림차순으로 전체 조회
    List<Emp> findAllByOrderByEnoDesc();

    //    2) ename like 검색하여 ename으로 내림차순 조회
//    select * from tb_emp where ename like '%매개변수%' order by ename desc;
    List<Emp> findAllByEnameContainingOrderByEnameDesc(String ename);

    //    3) emp 테이블에서 job 에 like 검색을 추가하고 job 내림차순으로 정렬하는 함수를 작성하세요.
//    select * from tb_emp where job lik '%매개변수%' order by job desc;
    List<Emp> findAllByJobContainingOrderByJobDesc(String job);

    //    4) emp 테이블에서 job 이 manager 이고 매개변수로 부서번호(dno) 를 전달받는 함수를 작성하세요.
//    select * from tb_emp where job = 'MANAGER' and dno = 20;
    List<Emp> findAllByJobAndDno(String job, int dno);

    //    5) EMP 테이블에서 SALARY 가 1000-1500 사이의 값을 갖는 사원을 조회하려고 합니다.
//    함수를 작성해주세요. BETWEEN 사용
    List<Emp> findAllBySalaryBetweenOrderByEname(int salary1, int salary2);


    //    6) emp 테이블에서 job을 매개변수로 받는 함수를 작성해주세요.
//    단, job의 매개변수값은 대문자 또는 소문자가 들어올수 있음
    List<Emp> findAllByJobIgnoreCase(String job);


    //    7) COMMISITON을 받는 사원을 모두 출력하는 함수를 작성해보세요.
    List<Emp> findAllByCommissionNotNull();


    //    8) Salary 는 내림차순, 사원명(ename)은 오름차순으로 정렬하는 함수를 작성해보세요.
    List<Emp> findAllByOrderBySalaryDescEnameAsc();


    //    9) Salary < 1000 또는 Salary > 1500 조건을 만족하는 사원을 구하시오.
    List<Emp> findAllBySalaryLessThanOrSalaryGreaterThan(int first, int last);

    //    10) commission 이 300이거나 500 이거나 1500인 사원을 출력하는 함수를 작성하세요.
    List<Emp> findAllByCommissionOrCommissionOrCommission(int first, int middle, int last);

//  ######################################################################################
//  example02 : @Query
//  ######################################################################################
//  1) ename like 검색하는 함수를 정의하세요.
//     단, @Query 사용하세요, native 쿼리로 작성하세요.

    @Query(value = "select e.* from tb_emp e where e.ename like %:ename%"
            , nativeQuery = true)
    List<Emp> selectByEname(@Param("ename") String ename);


//    2) salary 내림차순, ename 오름차순으로 정렬하는 함수를 작성하세요.
//    단, @Query 사용하세요, native 쿼리로 작성하세요.

    @Query(value = "select e.* from tb_emp e order by e.salary desc, e.ename asc"
            , nativeQuery = true)
    List<Emp> selectByEnameSalary();


    //    3) commission 이 null 이고 , salary 가  매개변수값보다 같거나 큰 사원 정보를 출력하세요.
//    단, @Query 사용하세요, native 쿼리로 작성하세요.
    @Query(value = "select e.* from tb_emp e where e.salary > :value and e.commission is null"
            , nativeQuery = true)
    List<Emp> selectByCommission(@Param("value") int value);


    //    4) 1982년도에 입사한 사원 출력하는 함수를 정의하세요
//       단, 입사일(hiredate) 내림차순
    @Query(value = "select e.* " +
            "from tb_emp e " +
            "where e.hiredate like '1982%' " +
            "order by e.hiredate desc"
            , nativeQuery = true)
    List<Emp> selectByHiredate();


    //    5) 부서별(dno), 직위별(job) 월급여 합계를 출력하는 함수를 정의하세요.
//    단, dto 만들어서 사용하세요
    @Query(value = "select e.dno, e.job, sum(salary) as sumSalary " +
            "from tb_emp e " +
            "group by e.dno, e.job"
            , nativeQuery = true)
    List<DeptGroup> selectByEnoJob();


    //    6) 부서별 평균 월급여를 출력하는 함수를 작성하세요.
//    단, 소수점은 절삭하세요.
    @Query(value = "select e.dno, TRUNC(avg(e.salary)) as avgSalary " +
            "from tb_emp e " +
            "group by e.dno "
            , nativeQuery = true)
    List<DeptGroup> selectByavg();


    //   7) 부서별 최고급여 중에서 3000 이상인 사원만 조회하는 함수를 정의하세요.
//      단, 소수점은 절삭하세요.

    @Query(value = "select dno, max(salary) as maxSalary   " +
            "from tb_emp   " +
            "group by dno   " +
            "having max(salary) >= 3000"
            , nativeQuery = true)
    List<DeptGroup> selectByEno();


    //    8) job이 manager 가 아니고 job 별 월급여 합계가 5000이상 되는 사원의 정보를 출력하는 함수를 정의하세요.
//       단, 월급여 합계로 오름차순 하세요.
    @Query(value = "select job, sum(salary) as sumSalary " +
            "from tb_emp " +
            "where job not like '%manager%' " +
            "group by job " +
            "having sum(salary) >= 5000 " +
            "order by sum(salary) asc"
            , nativeQuery = true)
    List<DeptGroup> selectByNotManager();


    //    9) 사원의 총수와 최고급여를 출력하세요.
    @Query(value = "select count(*) as countVal, max(salary) as maxSalary " +
            "from tb_emp "
            , nativeQuery = true)
    List<DeptGroup> selectByCount();


    //    10) 사원 테이블에서 가장 오래된 사원의 입사일과 가장 빠른 사원의 입사일을 출력하세요.
    @Query(value = "select max(hiredate) as maxSalary, min(hiredate) as minSalary " +
            "from tb_emp"
            , nativeQuery = true)
    List<DeptGroup> selectByHire();


}



