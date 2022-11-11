package com.example.test.model;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName : com.example.jpaexam.model
 * fileName : BaseTimeEntity
 * author : ds
 * date : 2022-10-20
 * description : JPA에서 자동으로 생성일자/수정일자를 만들어주는 클래스
 *               포맷 : yyyy-MM-dd HH:mm:ss
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Getter
// @MappedSuperclass : 모델을 감시하다가 생성일자를 자동으로 뽑아주는 어노테이션
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
//    생성일자 속성
    private String insertTime;
//    수정일자 속성
    private String updateTime;

    //    감시 함수
//    대상 모델(엔티티) 를 저장하기전(insert) 실행되는 함수
    @PrePersist
    void onPrePersist() {
        this.insertTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    //    대상 모델(엔티티) 를 수정하기전(update) 실행되는 함수
    @PreUpdate
    void onPreUpdate() {
        this.updateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.insertTime = this.updateTime;
    }
}
