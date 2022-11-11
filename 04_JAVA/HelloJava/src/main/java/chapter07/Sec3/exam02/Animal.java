package chapter07.Sec03.exam02;

/**
 * packageName : chapter07.Sec03.exam02
 * fileName : Animal
 * author : ds
 * date : 2022-09-29
 * description : 추상클래스 / 추상 함수(메소드)
 * 요약 : 
 *    추상 클래스 : 클래스들의 공통적인 속성과 함수를 추출해서 선언한 클래스를 의미
 *          목적 : 함수/속성의 이름을 통일하고자 할 때 사용
 *    추상 함수 : 추상 클래스에만 사용할 수 있고, 함수의 선언부만 있고, 실행블럭{} 없는 함수
 *              자식 클래스에서 반드시 함수 재정의(오버라이딩) 해서 사용해야 함
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-29         ds          최초 생성
 */
public abstract class Animal {
    public String kind; // 종류(종)

    // 공통 함수
    public void breathe(){
        System.out.println("숨을 쉽니다.");
    }

    // 추상함수 : 함수의 선언부만 있고, 실행블럭인 {} 없음
    // 자식클래스에서 함수 재정의해서 사용함 (목적: 함수이름 고정)
    public abstract void sound(); // (함수의 실행블럭)중괄호{} 가 없음

}
