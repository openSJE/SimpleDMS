package chapter13.sec01.verify;

/**
 * packageName : chapter13.sec01.verify
 * fileName : Board
 * author : ds
 * date : 2022-10-05
 * description : 게시판 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-05         ds          최초 생성
 */
    // 문제 : BoardDao 객체의 getBoardList() 함수를 호출하면 List<Board> 타입의 컬렉션을
//    리턴합니다. ListApplication 클래스를 실행할 때 다음과 같이 출력될 수 있도록
//    BoardDao의 getBoardList() 함수를 작성해 보세요.
//    결과 :
//      제목1-내용1
//      제목2-내용2
//      제목3-내용3
    public class Board {
        private String title;
        private String content;

        public Board(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() { return title; }
        public String getContent() { return content; }
    }

