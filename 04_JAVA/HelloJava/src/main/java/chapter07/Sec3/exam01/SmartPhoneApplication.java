package chapter07.Sec03.exam01;

/**
 * packageName : chapter07.Sec03.exam01
 * fileName : SmartPhoneApplication
 * author : ds
 * date : 2022-09-29
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-29         ds          최초 생성
 */
public class SmartPhoneApplication {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone("홍길동");

        // 추상클래스의 함수호출
        smartPhone.turnOn(); // 전원켜기
        smartPhone.internetSearch(); // 검색
        smartPhone.turnOff(); // 전원끄기

    }
}
