package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.jpaexam.model
 * fileName : Emp
 * author : ds
 * date : 2022-10-20
 * description : 사원 모델(==엔티티)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Entity
@Table(name = "TB_CUSTOMER")
@SequenceGenerator(
        name= "SQ_CUSTOMER_GENERATOR"
        , sequenceName = "SQ_CUSTOMER"
        , initialValue = 1
        , allocationSize = 1
)
// lombok 라이브러리 어노테이션
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
// null 무시하고 sql 문 자동생성하는 어노테이션
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_CUSTOMER SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE cid = ?")
public class Customer extends BaseTimeEntity {

//    테이블스크립트는 언더바. 자바는 카멜표기법
//    카멜 shift+ alt u
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_CUSTOMER_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer cid;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String firstName;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String lastName;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String email;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String phone;

}












