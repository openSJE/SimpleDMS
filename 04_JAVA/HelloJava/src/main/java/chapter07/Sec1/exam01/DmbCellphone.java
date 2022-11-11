package chapter06.Sec07.exam01;

/**
 * packageName : chapter06.Sec07
 * fileName : DmbCellphone
 * author : ds
 * date : 2022-09-29
 * description : 자식클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-29         ds          최초 생성
 */
// 상속 사용법 : public class 자식클래스 extends 부모클래스
public class DmbCellphone extends Cellphone{
    // String model, String color 속성 상속 받으므로 정의 할 필요 없음
    int channel; // tv 채널 속성

    // 생성자 만들기 : alt + insert

    // 매개변수 3개짜리 생성자
    public DmbCellphone(String model, String color, int channel) {
        this.channel = channel;
        this.model = model; // 부모속성 = 매개변수 값
        this.color = color; // 부모속성 = 매개변수 값
    }

    // powerOn(), powerOff(), bell() 등 상속 받았으므로 정의할 필요 없음

    // tv 수신을 시작하는 함수
    void turnOnDmb() {
        System.out.println("채널 : " + channel + "번 방송 수신을 시작합니다.");
    }

    // 채널 돌리기 함수
    void changeChannelDmb(int channel){
        // 속성 = 매개변수값(ex) 7)
        this.channel = channel;
        System.out.println("채널 : " + channel + "번으로 바꿉니다.");
    }

    // tv 수신을 멈추는 함수
    void turnOff() {
        System.out.println("DMB 방송 수신을 멈춥니다.");
    }

}
