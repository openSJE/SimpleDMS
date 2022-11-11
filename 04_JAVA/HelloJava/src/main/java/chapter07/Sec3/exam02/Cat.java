package chapter07.Sec03.exam02;

/**
 * packageName : chapter07.Sec03.exam02
 * fileName : Cat
 * author : ds
 * date : 2022-09-29
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-29         ds          최초 생성
 */
public class Cat extends Animal{
    public Cat(){
        this.kind = "포유류";
    }

    @Override
    public void sound() {
        System.out.println("얘얘얭얘얘얘얘얭");
    }
}
