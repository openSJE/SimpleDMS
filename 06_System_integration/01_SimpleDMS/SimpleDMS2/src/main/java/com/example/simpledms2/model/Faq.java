package com.example.simpledms2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@Entity
@Table(name = "TB_DEPT")
@SequenceGenerator(
        name= "SQ_DEPT_GENERATOR"
        , sequenceName = "SQ_DEPT"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
// soft delete : 삭제하는 척만 하기 (화면에서는 안보이고 ,db는 데이터를 삭제하지 않음)
// 법정 의무 보관 기간을 위해 실제 데이터를 삭제하지 않음
// 사용법 1) @SQLDelete(sql="update문")  : delete문이 실행되지 않고, 매개변수의 update문이 실행되게 함
//       2) Where(coluse="겅재조건") : 대상 클래스에 붙이면 sql문 실행시 강제 조건이 붙어 실행됨
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql = "UPDATE TB_DEPT SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE DNO = ?")
public class Dept extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_DEPT_GENERATOR"
    )
    private Integer dno;
    //    부서명 : dname
    @Column(columnDefinition = "VARCHAR2(255)")
    private String dname;
    //    위치 : loc
    @Column(columnDefinition = "VARCHAR2(255)")
    private String loc;
}

