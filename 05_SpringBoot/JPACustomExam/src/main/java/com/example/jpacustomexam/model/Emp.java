package com.example.jpaexam.model;

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
 * description : 부서모델 (== JPA : 엔티티(Entity)) 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-19         ds          최초 생성
 */
// JPA 매커니즘 : 클래스를 대상으로 테이블 자동 생성,
//               기본 제공하는 함수들은 자동으로 CRUD sql문을 만들어줌
//    sql은 적성에 필요한 노력을 절약.
//    개발자는 제공하는 함수만 호출 -> sql문 JPA 라이브러리가 알아서 생성해줌
// @Entity : 대상 클래스를 참고하여 DB에 물리 테이블을 생성함
// @Table(name = "테이블명") : 자동 생성 시 테이블명으로 생성됨
// @SequenceGenerator(각종 속성) : Oracle DB 시퀀스 생성시 사용할 속성들
// @DynamicInsert : insert 시 null 인 컬럼 제외해서 sql문 자동 생성함
// @DynamicUpdate : update 시 null 인 컬럼 제외해서 sql문 자동 생성함
// @Id : 기본키가 지정될 속성 -> DB에 기본키를 자동으로 만들어줌
// @Column(columnDefinition = "컬럼타입(개수)") : DB에 자동 생성될 테이블의 컬럼정보를 직접 지정
@Entity
@Table(name = "TB_EMP")
@SequenceGenerator(
        name= "EMP"
        , sequenceName = "SQ_EMP"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
// null 인 컬럼 데이터는 sql문 자동 생성 시 제외시킴
@DynamicInsert
@DynamicUpdate
public class Emp extends BaseTimeEntity{
    //    부서 번호 : dno
//    @Id : 기본키
//    시퀀스 사용 : ORACLE  POSTGRE 등 (자동으로 생성되도록)
//    MYSQL / MARIA DB -> increment 이용
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                    , generator = "SQ_EMP_GENERATOR"
    )
    private Integer eno;
    //    부서명 : dname
    @Column(columnDefinition = "VARCHAR2(255)")
    private String ename;
    //    위치 : loc
    @Column(columnDefinition = "VARCHAR2(255)")
    private String job ;
    @Column(columnDefinition = "INT")
    private String manager  ;
    @Column(columnDefinition = "VARCHAR2(255)")
    private String hiredate  ;
    @Column(columnDefinition = "INT")
    private String salary   ;
    @Column(columnDefinition = "INT")
    private String commission    ;
    @Column(columnDefinition = "INT")
    private String dno   ;
}

