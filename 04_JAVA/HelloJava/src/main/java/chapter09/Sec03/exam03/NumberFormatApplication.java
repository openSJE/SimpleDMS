package chapter09.Sec03.exam02;

/**
 * packageName : chapter09.Sec03.exam02
 * fileName : NumberFormatApplication
 * author : ds
 * date : 2022-10-04
 * description : Number Format Exception (숫자형태가 잘못도리 경우 발생)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-04         ds          최초 생성
 */
public class NumberFormatApplication {
    public static void main(String[] args) {
        String data1 = "100";
        String data2 = "a100";
        
        int value1 = Integer.parseInt(data1); // 100 숫자로 바뀜
        // NumberFormatApplication : 숫자로 바꿀 수 없는 것을 강제 변환할 경우 발생
        int value2 = Integer.parseInt(data2); // a100 숫자로 바뀔 수가 없음

        int result = value1 + value2;
        System.out.println(data1 + " + " + data2 + " = " + result);
    }
}
