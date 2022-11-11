
package com.example.test.repository.test;

import com.example.test.model.Dept;
import com.example.test.model.test.Test;
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
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
// JpaRepository<모델, 기본키 속성 타입>
@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    @Query(value = "select t from Test t where t.tname like %:tname%")
    List<Test> selectByTnameAndContent(@Param("tname") String tname);

}