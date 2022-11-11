package chapter09.Sec04.exam02;

/**
 * packageName : chap11.sec01.exam01
 * fileName : Member
 * author : ds
 * date : 2022-10-04
 * description : 객체를 동등 비교( .hashCode() )
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-04         ds          최초 생성
 */
// 해쉬코드(hashCode) : 객체를 식별하는 유일한 정수값( 번호는 중복되면 안됨 )
//    .hashCode() 함수는 객체가 메모리에 저장된 방번호(주소)를 가지고, 유일한 값을 만듬
//    객체를 비교할때
//    1) HashMap, HashSet 라는 자료구조(배열과 비슷)를 사용할 때 해쉬코드를 사용함
//    객체간 비교에서 .hashCode() 함수를 재정의 안하면 위에서 오류가 발생함(재정의 해야함)
//    결론 : .equals(), .hashCode() 무조건 재정의
//    아래의 .equals(), .hashcode()재정의하는 이노테이션
//    어노테이션 : 일종의 함수하고 비슷
// lombok 라이브러리 @Data : @EqualsAndHashCode 등 포함
//@Data
    // lombok 라이브러리 : equals(), .hashcode() 가 미리 재정의됨
    // @EqualsAndHashCode
public class Member {
    //    속성
    public String id;

    public Member(String id) {
        this.id = id;
    }

    //    object : 객체의 최고 조상(부모) 클래스
//    객체의 .equals 함수 재정의
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member) {
//            강제 형변환
            Member member = (Member) obj;
//            속성의 id 값 매개변수값 id 를 비교해서 같으면 true 틀리면 false 를 리턴
            if(this.id.equals(member.id)) {
                return true;
            }
        }
        return false;
    }

    // 해쉬코드 재정의
    // id 속성이 2개가 같으면 해쉬코드도 같음
    // String 객체의 특징 : 문자열이 같으면 같은 방번호를 씀
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}