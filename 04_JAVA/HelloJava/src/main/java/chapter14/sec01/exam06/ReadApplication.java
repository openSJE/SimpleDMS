package chapter14.sec01.exam05;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * packageName : chapter14.sec01.exam04
 * fileName : ReadApplication
 * author : ds
 * date : 2022-10-06
 * description : 배열의 크기만큼 파일에서 읽기
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-06         ds          최초 생성
 */
public class ReadApplication {
    public static void main(String[] args) throws Exception{
        InputStream inputStream = new FileInputStream("src/main/resources/test2.db");

//        한번에 크게 읽기용으로 배열 크기 설정
        byte[] buffer = new byte[100];
        while (true){
//            배열의 크기만큼 읽기 : 100byte씩 읽기 (읽기횟수가 줄어듦) - 속도 향상
//            .read(배열) : 파일에서 읽은 데이터를 배열에 씁니다.
//                  return값 : 파일에서 읽은 byte 개수
            int data = inputStream.read(buffer); // read(배열) 리턴값 (int)
//            파일의 끝에 도달하면 : -1
            if(data == -1) break;
            System.out.println(data);
//            읽은 바이트 수만큼 화면에 출력
//            읽은 바이트 : data
//            읽은 데이터 : buffer 배열
            for (int i = 0; i < data; i++) {
                System.out.println(buffer[i]);
            }
        }
        inputStream.close();
    }
}
