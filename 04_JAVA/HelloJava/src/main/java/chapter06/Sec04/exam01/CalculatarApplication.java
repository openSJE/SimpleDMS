package chapter06.Sec04;

/**
 * packageName : chapter06.Sec04
 * fileName : CalculatarApplication
 * author : ds
 * date : 2022-09-28
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-28         ds          최초 생성
 */
public class CalculatarApplication {
    public static void main(String[] args) {
        Calculatar calculatar = new Calculatar();

        // 계산기 전원 on
        // 리턴 값이 없는 함수()
        calculatar.powerOn();

        // 덧셈 계산
        // int result = 객체변수.리턴값이 있는 함수()
        int result1 = calculatar.plus(5,6);
        System.out.println(result1);

        // 나누기 계산
        double result2 = calculatar.divide(10,2);
        System.out.println(result2);


        calculatar.powerOff();

    }
}
