package chapter06.sec02.exam01;

/**
 * packageName : sec02.exam01
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
        //         객체생성
        // 클래스명 객체변수명 = new 생성자함수();
        Car car = new Car();

        // 속성 불러와서 출력하기
        System.out.println("제작회사 : " + car.company);
        System.out.println("모델명 : " + car.model);
        System.out.println("색상 : " + car.color);
        System.out.println("최고속도 : " + car.maxSpeed);
        System.out.println("현재속도 : " + car.speed);

        // Car 클래스(객체정의) 속성 값 변경 (수정)
        car.speed = 60;
        System.out.println("수정된 속도 : "+ car.speed);
    }
}
