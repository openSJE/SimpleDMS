package com.example.jpaexam.service.board;



import com.example.jpaexam.model.Board.Board;
import com.example.jpaexam.repository.test.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : Dept02Service
 * author : ds
 * date : 2022-10-20
 * description : 부서업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;


//   A. 게시판 글

    //	1) insert 함수 (글쓰기)
    public Board saveInsert(Board board) {

        Board board2 = BoardRepository.save(board); // insert 함수

        return board2;
    }

    //    2) 전체조회 함수 (목록보기)
    public Page<Board> findAll(Pageable pageable){
        Page<Board> page = boardRepository.findAll(pageable);

        return page;
    }


    //    3) ID로 조회 함수 (상세목록보기)
    public Optional<Board> findById(int tno){
        Optional<Board> optionalBoard = boardRepository.findById(tno); // select문 자동생성 DB전송

        return optionalBoard;
    }





    //   4) id로(번호) 삭제 delete 함수(글삭제)
    public boolean removeById(int id) {

        if(boardRepository.existsById(id) == true) {
            boardRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    //    5)update 함수 (글수정)
    public Board saveUpdate(Board board) {

        Board board2 = boardRepository.save(board);

        return board2;
    }


//    6)제목검색
    public List<Board> selectByTnameAndContent(String tname){
        List<Board> list = boardRepository.selectByTnameAndContent(tname);

        return list;
    }


}

