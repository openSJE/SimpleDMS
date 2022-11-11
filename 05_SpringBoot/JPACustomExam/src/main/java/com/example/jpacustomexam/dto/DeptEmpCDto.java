package com.example.jpacustomexam.dto;

import lombok.*;

/**
 * packageName : com.example.jpacustomexam.dto
 * fileName : DeptEmptCDto
 * author : ds
 * date : 2022-10-27
 * description : 객체 쿼리(JPQL)의 결과를 저장할 DTO 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-27         ds          최초 생성
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeptEmptCDto {

//    부서
    private Integer dno;
    private String dname;
    private String loc;

//    사원
    private Integer eno;
    private String ename;
    private String job;
    private Integer manager;
    private String hiredate;
    private Integer salary;
    private Integer commission;

//    생성자를 이용해서 필요한 속성만 출력하기

    public DeptEmptCDto(Integer dno, String dname, String loc, Integer eno, String ename, Integer salary) {
        this.dno = dno;
        this.dname = dname;
        this.loc = loc;
        this.eno = eno;
        this.ename = ename;
        this.salary = salary;
    }
}
