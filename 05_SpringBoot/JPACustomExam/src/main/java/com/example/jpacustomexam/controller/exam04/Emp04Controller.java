


package com.example.jpacustomexam.controller.exam03;

import com.example.jpacustomexam.dto.DeptGroup;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.model.Emp;
import com.example.jpacustomexam.service.exam02.Emp02Service;
import com.example.jpacustomexam.service.exam03.Emp03Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Dept07Controllder
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러 @RestController, ResponseEntity, getDeptAll()
 *
 *
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
// @RestController : return 값이 json 데이터 형태로 출력됨
@Slf4j
@RestController
@RequestMapping("/exam03")
public class Emp03Controller {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    Emp03Service empService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기



    //  1)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/emp/asc/paging")
    public ResponseEntity<Object> findAll(Pageable pageable) {

        try {
            Page<Emp> page = empService.findAll(pageable);

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
    @GetMapping("/emp/ename/desc/paging")
    public ResponseEntity<Object> findAllByOrderByEnameDesc(Pageable pageable) {

        try {
            Page<Emp> page = empService.findAllByOrderByEnameDesc(pageable);


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
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/emp/commission/{salary1}/{salary2}/paging")
    public ResponseEntity<Object> findAllBySalaryBetweenAndCommissionIsNotNull(@PathVariable int salary1,
                                                                               @PathVariable int salary2,
                                                                               Pageable pageable) {

        try {
            Page<Emp> page = empService.findAllBySalaryBetweenAndCommissionIsNotNull(salary1, salary2, pageable);

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





    //  4)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/emp/ename/{ename}/paging")
    public ResponseEntity<Object> findAllByEnameContaining(@PathVariable String ename,
                                                                               Pageable pageable) {

        try {
            Page<Emp> page = empService.findAllByEnameContaining(ename, pageable);

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






    //  5)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/emp/dno/{dno}/salary/{salary}/paging")
    public ResponseEntity<Object> findAllByDnoAndSalaryGreaterThan(@PathVariable int dno,
                                                        @PathVariable int salary,
                                                        Pageable pageable) {

        try {
            Page<Emp> page = empService.findAllByDnoAndSalaryGreaterThan(dno, salary, pageable);

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








    //  6)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/emp/salary/{salary1}/{salary2}/paging")
    public ResponseEntity<Object> selectBySalry(@PathVariable int salary1,
                                                        @PathVariable int salary2,
                                                        Pageable pageable) {

        try {
            Page<Emp> page = empService.selectBySalry(salary1, salary2, pageable);

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








    //  7)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/emp/hire/{hire1}/{hire2}/paging")
    public ResponseEntity<Object> selectByHiredate(@PathVariable String hire1,
                                                        @PathVariable String hire2,
                                                        Pageable pageable) {

        try {
            Page<Emp> page = empService.selectByHiredate(hire1, hire2, pageable);

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







    //  8)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/emp/salary/{salary1}/{salary2}/dno/{dno1}/{dno2}/paging")
    public ResponseEntity<Object> selectBydno(@PathVariable int salary1,
                                              @PathVariable int salary2,
                                              @PathVariable int dno1,
                                              @PathVariable int dno2,
                                              Pageable pageable) {

        try {
            Page<Emp> page = empService.selectBydno(salary1, salary2,dno1, dno2, pageable);

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







    //  9)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/emp/hire/{hire1}/paging")
    public ResponseEntity<Object> selectByHire(@PathVariable String hire1,
                                                        Pageable pageable) {

        try {
            Page<Emp> page = empService.selectByHire(hire1, pageable);

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







    //  10)
//    URL 속성 : page -> 현재 페이지 번호, size -> 한 페이지 당 건수
//    URL 테스트 : http://localhost:8000/exam03/dept/asc/paging?page=0&size=2
    @GetMapping("/emp/commissiondate/{date1}/paging")
    public ResponseEntity<Object> selectByCommission(@PathVariable int date1,
                                                        Pageable pageable) {

        try {
            Page<Emp> page = empService.selectByCommission(date1, pageable);

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



}







