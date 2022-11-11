package chapter13.sec01.verify8;

import chapter13.sec01.exam05.Member;

import java.util.Objects;

/**
 * packageName : chapter13.sec01.verify8
 * fileName : Student
 * author : ds
 * date : 2022-10-06
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-06         ds          최초 생성
 */
public class Student {
    public int studentNum;
    public String name;

    public Student (int studentNum, String name) {
        this.studentNum = studentNum;
        this.name = name;
    }

//    함수 재정의 : .equals(), .hashCode()
//    학번만 return하기 함수 재정의 : 같은 객체로 취급
    @Override
    public int hashCode() {
        return Objects.hash(studentNum);
    }

//    객체의 최고 조상클래스 : Object
    @Override
    public boolean equals(Object obj) {
//        재정의 로직 구현
        if(obj instanceof Student){
//            강제형변환
            Student student = (Student) obj;
//            학번만 체크해서 같으면 true 아니면 false
            return this.studentNum == student.studentNum;
        }else {
            return false;
        }
    }
}
