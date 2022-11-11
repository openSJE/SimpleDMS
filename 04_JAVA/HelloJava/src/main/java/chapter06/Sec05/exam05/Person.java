package chapter06.Sec06;

/**
 * packageName : chapter06.Sec06
 * fileName : Person
 * author : ds
 * date : 2022-09-28
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-28         ds          최초 생성
 */
public class Person {
    // final 변수 : 자바에서 상수를 정의하는 방법
    // 상수 : 변하지 않는 값(최초 저장이 되면 불변)
    // 1) 값을 바로 저장(대입 연산자(=)이용)
    final String nation = "Korea";
    
    // 2) 생성자를 통해서 저장하는 방법
    final String ssn; // 시리얼 번호
    
    String name;

    public Person(String ssn, String name) {
        this.ssn = ssn;
        this.name = name;
    }
}
