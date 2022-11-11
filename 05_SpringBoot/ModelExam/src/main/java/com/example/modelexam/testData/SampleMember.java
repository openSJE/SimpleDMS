package com.example.modelexam.testdata;

import com.example.modelexam.model.Dept;
import com.example.modelexam.model.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.example.modelexam.testdata
 * fileName : SampleMember
 * author : kangtaegyung
 * date : 2022/10/14
 * description : 샘플 회원 데이터 클래스(DB 테이블 대체)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/14         kangtaegyung          최초 생성
 */
@Component
@Getter
@Setter
public class SampleMember {
    List<Member> list = new ArrayList<>();

    public SampleMember() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ldt = LocalDateTime.now().format(dtf);

        Member member = Member.builder()
                .eno(7369)
                .eName("SMITH")
                .job("CLERK")
                .manager(7902)
                .insertTime(ldt)
                .build();
        list.add(member);

        member = Member.builder()
                .eno(7499)
                .eName("SMITH")
                .job("CLERK")
                .manager(7698)
                .insertTime(ldt)
                .build();
        list.add(member);

        member = Member.builder()
                .eno(7521)
                .eName("SMITH")
                .job("CLERK")
                .manager(7698)
                .insertTime(ldt)
                .build();
        list.add(member);

        member = Member.builder()
                .eno(7566)
                .eName("SMITH")
                .job("CLERK")
                .manager(7839)
                .insertTime(ldt)
                .build();
        list.add(member);

        member = Member.builder()
                .eno(7654)
                .eName("SMITH")
                .job("CLERK")
                .manager(7698)
                .insertTime(ldt)
                .build();
        list.add(member);

    }
}
