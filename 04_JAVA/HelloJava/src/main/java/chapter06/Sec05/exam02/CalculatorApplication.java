package chapter06.Sec05.exam01.exam02;


/**
 * packageName : chapter06.Sec05.exam01.exam02
 * fileName : CalculatorApplication
 * author : ds
 * date : 2022-09-28
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-28         ds          최초 생성
 */
// 문제 : 아래 공유변수(pi), 공유함수 (plus(), minus()) Calculator 클래스에 만들어서
    //   오류를 잡아보세요.
public class CalculatorApplication {
    public static void main(String[] args) {

        // 사용법 : 클래스명.함수(), 클래스명.변수
        double result1 = 10 * 10 * Calculator.pi; // pi = 3.14 공유 변수
        int result2 = Calculator.plus(10,5); // 두개의 매개변수 더하기 함수
        int result3 = Calculator.minus(10,5); // 두개의 매개변수 빼기 함수

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);
    }
}
