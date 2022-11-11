package sec03.exam01;

/**
 * packageName : sec03.exam01
 * fileName : CarApplication
 * author : ds
 * date : 2022-09-27
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-27         ds          최초 생성
 */
public class CarApplication {
    public static void main(String[] args) {
        // 클래스명 객체변수명 = new 생성자함수(매개변수1, ... 매개변수n);
        Car car = new Car("검정",3000);

        System.out.println(car.ccNum);
        System.out.println(car.col);
    }
}
