package chapter14.sec01.exam04;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * packageName : chapter14.sec01.exam04
 * fileName : ReadApplication
 * author : ds
 * date : 2022-10-06
 * description : 1byte 씩 파일에서 읽기
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-06         ds          최초 생성
 */
public class ReadApplication {
    public static void main(String[] args) throws Exception{
        InputStream inputStream = new FileInputStream("src/main/resources/test1.db");

        while (true){
//            1byte 읽기
            int data = inputStream.read(); // read() 리턴값 (int)
//            파일의 끝에 도달하면 : -1
            if(data == -1) break;
            System.out.println(data);
        }
        inputStream.close();
    }
}
