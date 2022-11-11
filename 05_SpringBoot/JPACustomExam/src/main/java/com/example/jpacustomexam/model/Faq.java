package com.example.jpaexam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * packageName : com.example.jpaexam.model
 * fileName : Faq
 * author : ds
 * date : 2022-10-21
 * description : Faq 엔티티(==모델) 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
@Entity
@Table(name = "TB_FAQ")
@SequenceGenerator(
        name= "SQ_FAQ_GENERATOR"
        , sequenceName = "SQ_FAQ"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
// null 인 컬럼 데이터는 sql문 자동 생성 시 제외시킴
@DynamicInsert
@DynamicUpdate
public class Faq {
//    1) 종합 예제
//    Faq 게시판을 만들려고 합니다.
//    모델을 아래와 같이 정의하고, 서비스 / 컨트롤러 클래스를 정의하세요(CRUD 함수 모두 포함)
//    단 no 는 시퀀스로 생성되고 1부터 증가
//      RestController를 이용하세요.
//    속성
//    no ( int )  : faq 번호
//    title ( String )  : faq 제목
//    content ( String )  : faq 내용
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE
        , generator = "SQ_FAQ_GENERATOR"
)
private Integer no;
    @Column(columnDefinition = "VARCHAR2(255)")
    private String title;
    @Column(columnDefinition = "VARCHAR2(255)")
    private String content ;


}
