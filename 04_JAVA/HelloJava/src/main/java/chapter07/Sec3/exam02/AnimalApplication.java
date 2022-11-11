package chapter07.Sec03.exam02;

import chapter06.Sec06.Car;

/**
 * packageName : chapter07.Sec03.exam02
 * fileName : AnimalApplication
 * author : ds
 * date : 2022-09-29
 * description : 실행클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-29         ds          최초 생성
 */
public class AnimalApplication {
    public static void main(String[] args) {
        // 자식객체들 생송
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.sound();
        cat.sound();

        System.out.println("--------------------------");

        // 다형성을 이용해서 (dog,cat) animal.sound() 출력하세요.
        Animal animal = null;
        // 다형성 타입변환 : Dog
        animal = new Dog();
        animal.sound(); // "멍멍"
        // 다형성 타입변환 : Cat
        animal = new Cat();
        animal.sound(); // "멍멍"

        System.out.println("---------------------------");

        // 매개변수의 다형성
        animalSound(dog);
        animalSound(cat);
    }

    // 공유함수
    public static void animalSound(Animal animal){
        animal.sound();
    }
}
