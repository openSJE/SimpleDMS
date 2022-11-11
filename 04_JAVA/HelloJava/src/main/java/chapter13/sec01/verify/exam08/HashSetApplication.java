package chapter13.sec01.verify8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * packageName : chapter13.sec01.verify8
 * fileName : HashSetApplication
 * author : ds
 * date : 2022-10-06
 * description :HashSet에 Student 객체를 저장하려고 합니다.
 *  *      학번이 같으면 동일한 Student라고 가정하고 중복 저장이 되지 않도록 하고 싶습니다.
 *  *      Student 클래스에서 재정의해야 하는 hashCode()와 equals() 함수를 내용을 채워보세요.
 *  *      Student의 해시코드는 학번이라고 가정합니다.
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-06         ds          최초 생성
 */
// 문제 : HashSet에 Student 객체를 저장하려고 합니다.
//    학번이 같으면 동일한 Student라고 가정하고 중복 저장이 되지 않도록 하고 싶습니다.
//    Student 클래스에서 재정의해야 하는 hashCode()와 equals() 함수의 내용을 채워보세요.
//    Student의 해시코드는 학번이라고 가정합니다.
public class HashSetApplication {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<Student>();
        
//      HashSet : 키가 중복되어있을 때 자동으로 중복제거
//      HashSet : 기존에 값이 있으면 안들어감
        set.add(new Student(1, "홍길동"));
        set.add(new Student(2, "신용권"));
        set.add(new Student(1, "조민우"));

        Iterator<Student> iterator = set.iterator();
        while(iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.studentNum + ":" + student.name);
        }
    }
}
