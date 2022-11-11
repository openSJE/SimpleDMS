package com.example.jpacustomexam.repository.exam07;

import com.example.jpacustomexam.model.exam04.Department;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.repository.exam07
 * fileName : Dept07RepositoryCustom
 * author : ds
 * date : 2022-10-27
 * description : Querydsl 용 Custom 인터페이스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-27         ds          최초 생성
 */
public interface Dept07RepositoryCustom {

    List<Department> querydslByDname(String dname);

    List<Department> querydslByDnameAndLoc(String dname, String loc);


}



