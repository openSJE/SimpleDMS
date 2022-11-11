package chapter08.Sec01.exam01;

/**
 * packageName : chapter08
 * fileName : Audio
 * author : ds
 * date : 2022-09-30
 * description : 구현 클래스(자식 클래스)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-30         ds          최초 생성
 */
public class Audio implements RemoteControl{
    // 볼륨 속성
    private int volumn;

    @Override
    public void turnOn() {
        System.out.println("오디오를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("오디오를 끕니다.");
    }

    @Override
    public void setVolumn(int volumns) {
        // 속성 = 매개변수 값;
        // 현재 볼륨 출력
        if(volumn > RemoteControl.MAX_VOLUMN){
            this.volumn = RemoteControl.MAX_VOLUMN;
        }else if(volumn < RemoteControl.MIN_VOLUMN){
            this.volumn = RemoteControl.MIN_VOLUMN;
        }else{
            this.volumn = volumns;
        }
        System.out.println("현재 오디오 볼륨 : " + volumn);

    }
}
