package com.example.jpacustomexam.dto.querydsl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName : com.example.jpacustomexam.dto.querydsl
 * fileName : DEptGroupQDto
 * author : ds
 * date : 2022-10-28
 * description : querydsl 에서 사용하는 DTO(Data Transfer Object)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-28         ds          최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeptGroupQDto {
    Long countVar; // querydsl 에서 long 자료형을 사용한 count() 일경우
    Integer sumVar;
    Double avgVar;
    Integer maxVar;
    Integer minVar;
}