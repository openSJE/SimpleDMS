package chapter14.sec01.exam02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * packageName : chapter14.sec01.exam02
 * fileName : WriteApplication
 * author : ds
 * date : 2022-10-06
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-06         ds          최초 생성
 */
public class WriteApplication {
    public static void main(String[] args) throws Exception {
        OutputStream outputStream = new FileOutputStream("src/main/resources/test2.db");
        byte[] array = {10, 20, 30};

//        배열의 데이터를 버퍼에쓰기
        outputStream.write(array);

//        버퍼내용 -> 파일쓰기
        outputStream.flush();

//        파일닫기
        outputStream.close();
    }
}
