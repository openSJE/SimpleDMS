package com.example.simpledms.service;

import com.example.simpledms.model.Customer;
import com.example.simpledms.model.Emp;
import com.example.simpledms.repository.CustomerRepository;
import com.example.simpledms.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : DeptService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수
    public Page<Customer> findAll(Pageable pageable) {
        Page<Customer> page = customerRepository.findAll(pageable);

        return page;
    }

    public void removeAll() {
        customerRepository.deleteAll(); // 전체 삭제
    }

    //   사원 정보 저장 함수
    public Customer save(Customer customer) {

        Customer customer2 = customerRepository.save(customer);

        return customer2;
    }

    //    부서번호로 조회하는 함수
//    Optional 객체 : null 방지 객체
//    주요 함수 : .get() - 안에 있는 객체 꺼내기 함수
//              .isPresent() - 안에 객체 있어요? 있으면  true, 없으면 false
    public Optional<Customer> findById(int cid) {
//        findById(기본키속성)
        Optional<Customer> optionalCustomer = customerRepository.findById(cid);

        return optionalCustomer;
    }

    // 사원번호(eno)로 삭제하는 함수
    public boolean removeById(int cid) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(customerRepository.existsById(cid) == true) {
            customerRepository.deleteById(cid);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }


    //    email like 검색 함수
    public Page<Customer> findAllByEmailContaining(String email, Pageable pageable) {
        Page<Customer> page = customerRepository.findAllByEmailContaining(email, pageable);

        return page;
    }
}









