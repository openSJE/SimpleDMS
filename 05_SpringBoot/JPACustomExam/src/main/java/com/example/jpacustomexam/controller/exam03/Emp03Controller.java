


package com.example.jpacustomexam.controller.exam02;

import com.example.jpacustomexam.dto.Dept03GroupDto;
import com.example.jpacustomexam.dto.DeptGroup;
import com.example.jpacustomexam.model.Emp;
import com.example.jpacustomexam.service.exam02.Emp02Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/exam02")
public class Emp02Controller {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    Emp02Service empService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기





    //  1)
    @GetMapping("/emp/ename/{ename}")
    public ResponseEntity<Object> selectByEname(String ename) {

        try {
            List<Emp> list = empService.selectByEname(ename);

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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
    @GetMapping("/emp/ename")
    public ResponseEntity<Object> selectByEnameSalary() {

        try {
            List<Emp> list = empService.selectByEnameSalary();

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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
    @GetMapping("/emp/value/{value}")
    public ResponseEntity<Object> selectByCommission(@PathVariable int value) {

        try {
            List<Emp> list = empService.selectByCommission(value);

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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
    @GetMapping("/emp/hiredate")
    public ResponseEntity<Object> selectByHiredate() {

        try {
            List<Emp> list = empService.selectByHiredate();

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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
    @GetMapping("/emp/enojob")
    public ResponseEntity<Object> selectByEnoJob() {

        try {
            List<DeptGroup> list = empService.selectByEnoJob();

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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
    @GetMapping("/emp/avg")
    public ResponseEntity<Object> selectByavg() {

        try {
            List<DeptGroup> list = empService.selectByavg();

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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
    @GetMapping("/emp/eno")
    public ResponseEntity<Object> selectByEno() {

        try {
            List<DeptGroup> list = empService.selectByEno();

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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
    @GetMapping("/emp/manager")
    public ResponseEntity<Object> selectByNotManager() {

        try {
            List<DeptGroup> list = empService.selectByNotManager();

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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
    @GetMapping("/emp/count")
    public ResponseEntity<Object> selectByCount() {

        try {
            List<DeptGroup> list = empService.selectByCount();

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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
    @GetMapping("/emp/hire")
    public ResponseEntity<Object> selectByHire() {

        try {
            List<DeptGroup> list = empService.selectByHire();

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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







