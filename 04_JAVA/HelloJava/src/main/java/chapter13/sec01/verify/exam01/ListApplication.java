package chapter13.sec01.verify;

import java.util.List;

/**
 * packageName : chapter13.sec01.verify
 * fileName : ListApplication
 * author : ds
 * date : 2022-10-05
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-05         ds          최초 생성
 */
public class ListApplication {
    public static void main(String[] args) {
        BoardDao dao = new BoardDao();
//      List 배열 : Board 객체에 저장되어 있는 값이 들어감
        List<Board> list = dao.getBoardList();

//       list 배열 내용 출력
        for(Board board : list) {
            System.out.println(board.getTitle() + "-" + board.getContent());
        }
    }
}