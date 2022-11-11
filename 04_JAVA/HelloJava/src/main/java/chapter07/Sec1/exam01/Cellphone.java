package chapter06.Sec07.exam01;

/**
 * packageName : chapter06.Sec07
 * fileName : Cellphone
 * author : ds
 * date : 2022-09-29
 * description : 상속(부모클래스)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-29         ds          최초 생성
 */
    // 현실 세계에서 상속 : 부모로부터 재산(자산)을 불려받는 것 (자식)
    // 코딩 : 부모 클래스(객체)(속성,함수) --> 자식클래스(객체)
    // 부모클래스 == 상위클래스
    // 자식클래스 == 하위클래스 == 파생클래스
    // 상속 장점 : 1) 코딩 중복을 제거함
    //           2) 부모 클래스의 속성/함수를 수정하면 자식클래스는 자동 수정됨
    //             (유지보수성 증가, 코딩생산성 증가)
public class Cellphone {
    // 속성
    String model;
    String color;

    // 생성자 생략(자바 자동생성)
    // 전원 켜기 함수(메소드)
    void powerOn(){
        System.out.println("전원을 켭니다.");
    }

    // 전원 끄기 함수 : 리턴값이 없음
    void powerOff(){
        System.out.println("전원을 끕니다.");
    }

    // 벨을 울리는 함수
    void bell(){
        System.out.println("벨이 울립니다.");
    }

    // 핸드폰 통화하기 기능(함수) : 매개변수 있는 함수 (송신)
    void sendVoice(String messege){
        System.out.println("나 : " + messege);
    }

    // 핸드폰 받는사람 통화하는 함수 (수싲ㄴ)
    void reciveVoice(String messege){
        System.out.println("상대방 : " + messege);
    }

    // 전화 끊기 함수
    void hangUp(){
        System.out.println("전화를 끊습니다.");
    }
}









