
package com.example.jpacustomexam.controller.exam03;


import com.example.jpacustomexam.dto.Dept02GroupDto;
import com.example.jpacustomexam.dto.DeptGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.service.exam03.Dept03Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Dept03Controllder
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러
 * 요악 :

 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
// @RestController : return 값이 json 데이터 형태로 출력됨
@Slf4j
@RestController
@RequestMapping("/exam03")
public class Dept03Controller {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    Dept03Service deptService;

    //  0)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/desc/paging?page=0&size=2
    @GetMapping("/dept/desc/paging")
    public ResponseEntity<Object> selectByDname(Pageable pageable) {

        try {
            Page<Dept> page = deptService.findAllByOrderByDnoDesc(pageable);

//            로직 추가 :   data +
//                         currentPage(현재페이지),
//                         totalItems(총데이터건수),
//                         totalPages(총페이지수)
//            Map 자료구조에 담아서 전송 (클라이언트)
            Map<String, Object> response = new HashMap<>();

//            앱객체.put(키이름, 값) : 앱 객체에 키이름으로 정보를 저장
            response.put("dept", page.getContent()); // 테이블 페이징된 데이터
            response.put("currentPage", page.getNumber()); // 현재 페이징 번호 (0 ~ n)
            response.put("totalItems", page.getTotalElements()); // 총 데이터 수 (4건)
            response.put("totalPages", page.getTotalPages()); // 총 페이지 수

            if (page.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





    //  1)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/dept/asc/paging")
    public ResponseEntity<Object> findAll(Pageable pageable) {

        try {
            Page<Dept> page = deptService.findAll(pageable);

//            로직 추가 :   data +
//                         currentPage(현재페이지),
//                         totalItems(총데이터건수),
//                         totalPages(총페이지수)
//            Map 자료구조에 담아서 전송 (클라이언트)
            Map<String, Object> response = new HashMap<>();

//            앱객체.put(키이름, 값) : 앱 객체에 키이름으로 정보를 저장
            response.put("dept", page.getContent()); // 테이블 페이징된 데이터
            response.put("currentPage", page.getNumber()); // 현재 페이징 번호 (0 ~ n)
            response.put("totalItems", page.getTotalElements()); // 총 데이터 수 (4건)
            response.put("totalPages", page.getTotalPages()); // 총 페이지 수

            if (page.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







    //  2)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/dept/dname/{dname}/paging")
    public ResponseEntity<Object> findAllByDnameContaining(@PathVariable String dname, Pageable pageable) {

        try {
            Page<Dept> page = deptService.findAllByDnameContaining(dname, pageable);

//            로직 추가 :   data +
//                         currentPage(현재페이지),
//                         totalItems(총데이터건수),
//                         totalPages(총페이지수)
//            Map 자료구조에 담아서 전송 (클라이언트)
            Map<String, Object> response = new HashMap<>();

//            앱객체.put(키이름, 값) : 앱 객체에 키이름으로 정보를 저장
            response.put("dept", page.getContent()); // 테이블 페이징된 데이터
            response.put("currentPage", page.getNumber()); // 현재 페이징 번호 (0 ~ n)
            response.put("totalItems", page.getTotalElements()); // 총 데이터 수 (4건)
            response.put("totalPages", page.getTotalPages()); // 총 페이지 수

            if (page.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







    //  3)
    //    URL 테스트 : http://localhost:8000/exam03/dept/all/paging?page=0&size=2&sort=dno,desc
    @GetMapping("/dept/dname/{dname}/loc/{loc}/paging")
    public ResponseEntity<Object> selectByDnameAndLocPage(@PathVariable String dname,
                                                      @PathVariable String loc,
                                                      Pageable pageable) {

        try {
            Page<Dept> page = deptService.selectByDnameAndLocPage(dname, loc, pageable);

//            페이지 정보를 맵 자료구조에 저장해서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("dept", page.getContent());
            response.put("currentPage", page.getNumber());
            response.put("totalItems", page.getTotalElements());
            response.put("totalPages", page.getTotalPages());

            if (page.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



//    //    URL 테스트 : http://localhost:8000/exam03/dept/all/paging?page=0&size=2&sort=dno,desc
//    @GetMapping("/dept/dname/{dname}/loc/{loc}/paging")
//    public ResponseEntity<Object> getDeptDnameLocPage(@PathVariable String dname,
//                                                      @PathVariable String loc,
//                                                      Pageable pageable) {
//
//        try {
//            Page<Dept> page = deptService.selectByDnameAndLocPage(dname, loc, pageable);
//
////            페이지 정보를 맵 자료구조에 저장해서 전송
//            Map<String, Object> response = new HashMap<>();
//            response.put("dept", page.getContent());
//            response.put("currentPage", page.getNumber());
//            response.put("totalItems", page.getTotalElements());
//            response.put("totalPages", page.getTotalPages());
//
//            if (page.isEmpty() == false) {
////                성공
//                return new ResponseEntity<>(response, HttpStatus.OK);
//            } else {
////                데이터 없음
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
////            서버 에러
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


//    3)

    @GetMapping("/dept/concat/paging")
    public ResponseEntity<Object> selectByConcat(Pageable pageable) {

        try {
            Page<Dept02GroupDto> page = deptService.selectByConcat(pageable);

//            페이지 정보를 맵 자료구조에 저장해서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("dept", page.getContent());
            response.put("currentPage", page.getNumber());
            response.put("totalItems", page.getTotalElements());
            response.put("totalPages", page.getTotalPages());

            if (page.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




//    4)

    @GetMapping("/dept/case/paging")
    public ResponseEntity<Object> selectByCase(Pageable pageable) {

        try {
            Page<DeptGroupDto> page = deptService.selectByCase(pageable);

//            페이지 정보를 맵 자료구조에 저장해서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("dept", page.getContent());
            response.put("currentPage", page.getNumber());
            response.put("totalItems", page.getTotalElements());
            response.put("totalPages", page.getTotalPages());

            if (page.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}








