package chapter06.Sec04;

/**
 * packageName : Sec04
 * fileName : Calculatar
 * author : ds
 * date : 2022-09-28
 * description : 함수(멤버메소드)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-28         ds          최초 생성
 */
public class Calculatar {
    // 속성
    // 생성자
    // 함수(메소드)
    // 전원 켜는 함수
    // 리턴값이 없는 함수 : void
    // 사용법 : 접근제어자 (public(공용), default(생략, 자기 패키지에서는 사용 가능))
    //         접근제어자 리턴타입(자료형) 함수명(매개변수1, ..., 매개변수n) {}
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    // 리턴 값이 있는 함수
    // 리턴타입(자료형) 함수명 : 함수 앞에 리턴타입과 { return 변수명 } 변수명의 타입 일치해야함
    int plus(int x, int y) {
        int result = x + y;

        return result;
    }

    // 리턴값이 있는 나누기 함수를 추가하세요.
    double divide(int x, int y) {
        double result = x / y;

        return  result;
    }

    // 리턴값이 없는 전원을 끄는 함수 추가
    void powerOff() {
        System.out.println("전원을 끕니다.");
    }
}
