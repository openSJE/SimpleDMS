package chapter06.Sec06;

/**
 * packageName : chapter06.Sec06
 * fileName : PersonApplication
 * author : ds
 * date : 2022-09-28
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-28         ds          최초 생성
 */
public class PersonApplication {
    public static void main(String[] args) {
        Person person = new Person("1234567-1234567","홍길동");

        System.out.println(person.nation); // 상수
        System.out.println(person.ssn); // 상수
        System.out.println(person.name); // 상수

        person.name = "강감찬";
//        person.nation = "Canada"; // 상수기 때문에 변경불가
    }
}
