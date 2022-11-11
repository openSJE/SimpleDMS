package chapter12.sec01.chatting;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * packageName : chapter12.sec01.chatting
 * fileName : SendThread
 * author : ds
 * date : 2022-10-06
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-06         ds          최초 생성
 */
public class SendThread extends Thread{
//    소켓 프로그래밍 + 쓰레드 프로그래밍
//    채팅(네트워크통신)을 위한 통로 개설, 실시간 통신 가능
    private final Socket socket; // 상수 만들면 바로 값을 넣어야 함 or 생성자를 통해서 넣어야 함

//    scanner입력 속성
    private Scanner scanner = new Scanner(System.in);

//    생성자
    public SendThread(Socket socket) {
        this.socket = socket;
    }

//    run() 실행함수

    @Override
    public void run() {
        try {
//            입출력 객체 사용 : 네트워크 기본 자료형을 사용할 수 있게 만들어주는 객체
//                             int, String, double, boolean 사용할 수 있게 해주는 객체
//            입출력 기본 객체 : InputStream, OutputStream (1byte씩 입출력)
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String sendString;
            while (true){
                sendString = scanner.nextLine(); // 채팅 입력 받기
                dataOutputStream.writeUTF(sendString); // 문자열을 네트웤 버퍼로 쏘기
                dataOutputStream.flush(); // 진짜 네트웤 전송
            }
        }catch (IOException e){
            e.printStackTrace(); // 에러코드 및 메세지를 화면에 출력
        }
    }
}
