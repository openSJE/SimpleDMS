
package com.example.jpaexam.repository.test;

import com.example.jpaexam.model.Board.Board;
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
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
// JpaRepository<모델, 기본키 속성 타입>
@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Page<Board> findAll(Pageable pageable);


    @Query(value = "select t from Board t where t.tname like %:tname%")
    List<Board> selectByTnameAndContent(@Param("tname") String tname);

}