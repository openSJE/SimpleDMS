package com.example.jpaexam.model.test;

import com.example.test.model.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * packageName : com.example.jpaexam.model
 * fileName : Dept
 * author : ds
 * date : 2022-10-19
 * description : == JPA : 엔티티(Entity)) 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-19         ds          최초 생성
 */

@Entity
@Table(name = "TB_TEST")
@SequenceGenerator(
        name= "SQ_TEST_GENERATOR"
        , sequenceName = "SQ_TEST"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
// null 인 컬럼 데이터는 sql문 자동 생성 시 제외시킴
@DynamicInsert
@DynamicUpdate
public class Test extends BaseTimeEntity {
    //    부서 번호 : dno
//    @Id : 기본키
//    시퀀스 사용 : ORACLE  POSTGRE 등 (자동으로 생성되도록)
//    MYSQL / MARIA DB -> increment 이용
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_TEST_GENERATOR"
    )
    private Integer tno;
    //    제목 : tname
    @Column(columnDefinition = "VARCHAR2(255)")
    private String tname;
    //    내용 : content
    @Column(columnDefinition = "VARCHAR2(255)")
    private String content;
}

