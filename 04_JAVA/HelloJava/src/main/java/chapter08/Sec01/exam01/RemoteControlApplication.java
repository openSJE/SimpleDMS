package chapter08.Sec01;

/**
 * packageName : chapter08
 * fileName : RemoteControlApplication
 * author : ds
 * date : 2022-09-30
 * description : 실행클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-30         ds          최초 생성
 */
public class RemoteControlApplication {
    public static void main(String[] args) {
        // 다형성 : tv 객체
        RemoteControl rc = new Television();
        rc.turnOn();
        rc.setVolumn(11);
        rc.turnOff();

        // 다형성 : 오디오객체
        rc = new Audio();
        rc.turnOn();
        rc.setVolumn(-1);
        rc.turnOff();
    }
}
