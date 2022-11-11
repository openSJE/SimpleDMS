package chapter09.Sec04.exam01;

/**
 * packageName : chapter09.Sec04.exam01
 * fileName : Member
 * author : ds
 * date : 2022-10-04
 * description : 객체를 동등 비교( .equals() ) ==
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-04         ds          최초 생성
 */
    // 객체가 동등하다는 것은 2개의 속성이 같다 라는 뜻
    // String 객체를 제외한 모든 객체는 .equals() 함수로 쓰면 주소(방번호) 비교를 하기 때문에
    //   재정의해서 사용해야 함
    // String 객체는 .equals() 값비교가 됨 ( String 에서 재정의 되어 있음 : 자바에서 미리 재정의 함 )
    // object : 최고 조상 (부모) 클래스 (.equals(), hashCode(), .toString() 등)
    //          모든 객체는 object를 자동상속하고 있음 (extends 키워드는 생략됨)

public class Member {
    // 속성
    public String id;

    public Member(String id) {
        this.id = id;
    }

    // Object: 객체의 최고 조상(부모) 클래스
    // 객체의 .equals 함수 재정의
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member){
            // 강제 형변환
            Member member =  (Member)obj;
            // 속성 id값 매개변수값 id 를 비교해서 값으면 true
            // 틀리면 false
            if(this.id.equals(member.id)){
                return true;
            }
        }
        return super.equals(obj);
    }
}
