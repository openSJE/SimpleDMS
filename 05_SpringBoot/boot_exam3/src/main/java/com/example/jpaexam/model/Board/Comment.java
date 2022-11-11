package com.example.jpaexam.model.Board;

import com.example.jpaexam.model.BaseTimeEntity;
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
@Table(name = "TB_CONTENT")
@SequenceGenerator(
        name= "SQ_CONTENT_GENERATOR"
        , sequenceName = "SQ_CONTENTD"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
// null 인 컬럼 데이터는 sql문 자동 생성 시 제외시킴
@DynamicInsert
@DynamicUpdate
public class TestComment extends BaseTimeEntity {
    //    부서 번호 : dno
//    @Id : 기본키
//    시퀀스 사용 : ORACLE  POSTGRE 등 (자동으로 생성되도록)
//    MYSQL / MARIA DB -> increment 이용
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_BOARD_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER", name="BID")
    private Integer cid;
    //    제목 : tname
    @Column(columnDefinition = "VARCHAR2(255)", name="COMMENT_CONTENT")
    private String commentContent;
    //    내용 : content
    @Column(columnDefinition = "VARCHAR2(255)", name="COMMENT_WRITER")
    private String commentWriter;
    @Column(columnDefinition = "VARCHAR2(255)", name="COMMENT_BID")
    private String bid;
}

