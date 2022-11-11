package com.example.jpacustomexam.repository.exam04;

import com.example.jpacustomexam.dto.DeptEmpCDto;
import com.example.jpacustomexam.dto.DeptEmpDto;
import com.example.jpacustomexam.model.exam04.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : DeptRepository
 * author : ds
 * date : 2022-10-20
 * description : join 실습 레파지토리
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
// JpaRepository<모델, 기본키 속성 타입>
@Repository
public interface Dept04Repository extends JpaRepository<Department, Integer> {

    //     예제 1) 부서와사원테이블 조인해서 보여주기
//    DTO 필요 (nativeQuery=true일 경우 인터페이스)
//    자동 import -> spring 붙은 것을 선택, java.utill.* 선택
//    1-1) nativeQuery = true : 일반 sql문
    @Query(value = "select d.*, e.eno, e.ename, e.salary " +
            "from tb_department d, tb_employee e " +
            "where d.dno=e.dno"
            , nativeQuery = true)
    List<DeptEmpDto> selectNativeJoin();


//    1-2) nativeQuery = false, 생략 : 객체쿼리 (JPQL 쿼리)
//    DTO 사용 : 클래스
//    관계 설정 : @ManyToOne 있어야 아래 커리 가능
//    @Query(value = "select " +
//            " new com.example.jpacustomexam.dto.DeptEmpCDto(d.dno, d.dname, d.loc, e.eno, e.ename, e.salary) " +
//            "from Employee e inner join e.department d ")
//    List<DeptEmpCDto> selectJoin();

    //    참고 2) 관계 설정 없이 객체 커ㅜ리로 조인 사용
    @Query(value = "select " +
            " new com.example.jpacustomexam.dto.DeptEmpCDto(d.dno, d.dname, d.loc, e.eno, e.ename, e.salary) " +
            "from Emp e inner join Dept d on e.dno = d.dno")
    List<DeptEmpCDto> selectJoin();


}