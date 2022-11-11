package chapter07.Sec2.exam01;

/**
 * packageName : chapter07.Sec2.exam01
 * fileName : Child
 * author : ds
 * date : 2022-09-29
 * description : 자식 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-29         ds          최초 생성
 */
public class Child2 extends Parent{

    @Override
    public void method2() {
        System.out.println("Child2-method2()");
    }

    public void method3() {
        System.out.println("Child2-method3()");
    }
}
