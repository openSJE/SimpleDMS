package chapter08.Sec01;

/**
 * packageName : chapter08
 * fileName : Television
 * author : ds
 * date : 2022-09-30
 * description : 구현클래스(자식클래스)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-30         ds          최초 생성
 */
public class Television implements RemoteControl{
    // 볼륨속성
    private int volumn;

    @Override
    public void turnOn() {
        System.out.println("tv를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("tv를 끕니다.");
    }

    @Override
    public void setVolumn(int volumns) {


        if(volumn > RemoteControl.MAX_VOLUMN){
            this.volumn = RemoteControl.MAX_VOLUMN;
        }else if(volumn < RemoteControl.MIN_VOLUMN){
            this.volumn = RemoteControl.MIN_VOLUMN;
        }else{
            this.volumn = volumns;

        }
        // 현재 볼륨 출력
        System.out.println("현재 티비 볼륨 : " + volumn);
    }
}
