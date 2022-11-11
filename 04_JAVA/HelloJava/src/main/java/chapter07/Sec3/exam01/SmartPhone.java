package chapter07.Sec03.exam01;

/**
 * packageName : chapter07.Sec03.exam01
 * fileName : SmartPhone
 * author : ds
 * date : 2022-09-29
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-29         ds          최초 생성
 */
public class SmartPhone extends Phone{

    // 생성자 (alt + insert)
    public SmartPhone(String owner) {
        super(owner);
    }

    // 인터넷 검색 함수
    public void internetSearch() {
        System.out.println("인터넷 검색을 합니다.");
    }
}
