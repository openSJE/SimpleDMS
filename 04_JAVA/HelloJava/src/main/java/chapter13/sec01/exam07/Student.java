package chapter13.sec01.verify;

/**
 * packageName : chapter13.sec01.verify
 * fileName : Student
 * author : ds
 * date : 2022-10-05
 * description : 학생 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-05         ds          최초 생성
 */
public class Student {
    public int sno;       // 학번
    public  String name;  // 이름

//    생성자
    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }
}
