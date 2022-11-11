package chapter07.Sec03.exam01;

/**
 * packageName : chapter07.Sec03.exam01
 * fileName : Phone
 * author : ds
 * date : 2022-09-29
 * description : 추상 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-29         ds          최초 생성
 */
    // 추상 클래스 만들기 : public abstract calsss 클래스명 {} // abstract 추가
    // 추상 클래스 객체생성을 못함 ( new Phone() // 에러 발생 )
    //  추상클래스 : 부모클래스
    //  자식클래스 상속받아 사용
    //  목적 : 함수 이름을 통일하고 공통된 속성이름을 사용할 목적으로 씀.
    //  추상 클래스 : 일반화된 객체들
    //  ex) 동물(추상클래스) : 물고기, 새, 고양이, 개
public abstract class Phone {
    public String owner;

    //생성자 (alt + insert)
    public Phone(String owner) {
        this.owner = owner;
    }

    // 전원 키는 함수
    public void turnOn(){
        System.out.println("폰 전원을 켭니다.");
    }

    // 전원 끄는 함수
    public void turnOff(){
        System.out.println("폰 전원을 끕니다.");
    }

}
