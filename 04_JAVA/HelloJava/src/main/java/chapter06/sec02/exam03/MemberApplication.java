package Verify06;

/**
 * packageName : Verify06
 * fileName : MemberApplication
 * author : ds
 * date : 2022-09-27
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-27         ds          최초 생성
 */
public class MemberApplication {
    public static void main(String[] args) {
        // Member 객체를 생성하고 속성에 아래의 값으로 저장한 후 속성의 값을 출력하세요.
        // 결과 :
        //      이름 : 최하연
        //       id : 23
        Member member = new Member();
        member.name = "최하얀";
        member.id = "23";

        System.out.println("이름 : " + member.name);
        System.out.println("id : " + member.id);

    }
}
