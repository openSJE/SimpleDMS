package com.example.controllerexam.model;

import lombok.*;

/**
 * packageName : com.example.controllerexam.model
 * fileName : Member
 * author : ds
 * date : 2022-10-14
 * description : 부서클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-14         ds          최초 생성
 */
// M : Model, Service, DAO, DTO
//    Model : 정보 저장/검색을 위한 클래스 , 속성/생성자/Setter/Getter
//  Lombok 라이브러리에서 제공하는 어노테이션(@)
// @Setter : 클래스의 속성을 검토해서 Setter 함수 자동 생성
@Setter
// @Getter : 클래스의 속성을 검토해서 Getter 함수 자동 생성
@Getter
// @ToString : ToString 함수 자동 재정의 해주는 기능 부여
// 객체를 출력하면 속성의 값이 출력됨
@ToString
// @AllArgsConstructor : 모든 속성을 매개변수로 하는 생성자 자동 생성
@AllArgsConstructor
// @NoArgsConstructor : 매개변수가 없는 생성자 자동 생성
@NoArgsConstructor
public class Dept {
    //    속성 정의
    Integer No;
    Integer dno;
    String dName;
    String loc;

    public Dept(Integer dno, String dName, String loc) {
        this.dno = dno;
        this.dName = dName;
        this.loc = loc;
    }
}


















