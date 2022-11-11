package chapter09.Sec04.exam03;

/**
 * packageName : chapter09.Sec04.exam03
 * fileName : SmartPhone
 * author : ds
 * date : 2022-10-04
 * description : 객체의 정보 출력하기, toString() 함수 재정의
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-04         ds          최초 생성
 */
public class SmartPhone {
    private String company;
    private String os;

    public SmartPhone(String company, String os) {
        this.company = company;
        this.os = os;
    }

    // toString() 재정의
    // 속성의 값을 볼수 있게 함수 재정의
    @Override
    public String toString() {
        return this.company + "❤" + this.os;
    }
}
