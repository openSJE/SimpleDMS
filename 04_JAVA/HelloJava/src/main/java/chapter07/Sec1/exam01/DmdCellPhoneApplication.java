package chapter06.Sec07.exam01;

/**
 * packageName : chapter06.Sec07
 * fileName : DmdCellPhoneApplication
 * author : ds
 * date : 2022-09-29
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-29         ds          최초 생성
 */
public class DmdCellPhoneApplication {
    public static void main(String[] args) {
        // Dmb 탑재 핸드폰 객체 :
        DmbCellphone dmbCellphone = new DmbCellphone("JAVA","BLACK",10);

        // 상속받은 속성 출력하기
        System.out.println("모델 : " + dmbCellphone.model); // 부모속성 : model
        System.out.println("색상 : " + dmbCellphone.color); // 부모속성 : color

        // 자기 속성 출력하기
        System.out.println("채널 : " + dmbCellphone.channel); // 자기 속성 속성

        // 상속받은 함수 실행하기
        dmbCellphone.powerOn(); // 부모함수
        dmbCellphone.bell(); // 핸드폰 통화
        dmbCellphone.sendVoice("여보세요"); // 전화받기
        dmbCellphone.reciveVoice("안녕하세요 반갑습니다."); //상대방 음성
        dmbCellphone.hangUp(); // 전화끊기
        
        // 자기 함수 실행
        dmbCellphone.turnOnDmb(); // tv시작
        dmbCellphone.changeChannelDmb(12); // 채널바꾸기
        dmbCellphone.turnOff(); // tv 끝
    }
}
