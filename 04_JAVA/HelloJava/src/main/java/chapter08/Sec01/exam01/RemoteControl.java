package chapter08.Sec01;

/**
 * packageName : chapter08
 * fileName : RemoteControl
 * author : ds
 * date : 2022-09-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-30         ds          최초 생성
 */
// 인터페이스(부모클래스 역할) : 추상클래스와 비슷, 내부에 정의되는 함수 전부 추상함수
//            일반 함수는 정의할 수 없음,
//      함수 : 전부 추상함수
//      속성 : 전부 상수(공유상수)
//      목적 : 명명규칙 일반화, 표준화, 다형성을 활용하기 위한 목적으로 생성
// 구현클래스 (자식클래스)
public interface RemoteControl {

    // 상수(공유상수), static final 생략됨
    int MAX_VOLUMN = 10; // 리모콘의 최대 볼륨크기
    int MIN_VOLUMN = 1; //  리모콘의 최소 볼륨크기

    // 함수 만들기 : 추상함수, abstract 키워드 생략됨
    // 추상함수 : 함수선언부만 있고, 실행블럭{}이 없음.
    void turnOn(); // 리모콘 켜기 함수
    void turnOff(); // 리모콘 끄기 함수
    void setVolumn(int volumn); // 볼륨 조정 함수
}
