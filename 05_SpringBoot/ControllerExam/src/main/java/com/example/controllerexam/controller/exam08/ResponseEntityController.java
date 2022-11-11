package com.example.controllerexam.controller.exam08;

import com.example.controllerexam.model.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.example.controllerexam.controller.exam08
 * fileName : RequestEntity
 * author : ds
 * date : 2022-10-14
 * description : RequestEntity 클래스 적용, @RequestBody / @PostMapping사용
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-14         ds          최초 생성
 */
@RestController
@RequestMapping("/exam08")
public class RequestEntityController {

    @PostMapping("/object-body")
    public RequestEntity<Object> getObjectBody(
            @RequestBody Member member
    ){
        List<Member> list = new ArrayList<>();
        list.add(member);

        return new RequestEntity<Object>(list, HttpStatus.FOUND);

    }
}
