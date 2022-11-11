package chapter12.sec01.exam01;

import java.awt.*;

/**
 * packageName : chapter12.sec01.exam01
 * fileName : BeepThread
 * author : ds
 * date : 2022-10-06
 * description : Thread 클래스 상속받아 만들기
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-06         ds          최초 생성
 */
public class BeepThread extends Thread{

    @Override
    public void run() {
//        멀티미디어 객체
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            }catch (Exception e){}
        }
    }
}
