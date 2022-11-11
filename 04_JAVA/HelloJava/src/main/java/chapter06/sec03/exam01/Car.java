package sec03.exam01;

/**
 * packageName : sec03.exam01
 * fileName : Car
 * author : ds
 * date : 2022-09-27
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-27         ds          최초 생성
 */
public class Car {
    // 속성
    String col; // 자동차 색상
    int ccNum;  // 자동차 배기량
    // 생성자(함수)
    // 클래스에 생성자가 없으면 자바 언어 컴파일 시 자동으로 1개 만들어 줌
    //  만약에 생성자가 있으면 안 만들어 줌.
    // 기본 생성자 : 매개변수가 없는 생성자
    // 생성자 : 리턴타입(자료형) 없음
    // 사용법 : (접근제어자) 클래스명(){}
//    Car() {
//
//    }
    // 매개변수 2개 생성자
    Car(String color, int cc){
        // 속성의 초기화를(초기값을 넣어두는 곳) 담당
        col = color;
        ccNum = cc;
    }
}
