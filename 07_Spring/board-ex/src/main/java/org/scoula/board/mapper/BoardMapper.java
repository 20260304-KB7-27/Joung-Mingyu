package org.scoula.board.mapper;

import org.scoula.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    // 게시글 전체 조회
    // public List<BoardVO> getList();

    // 게시글 단건 조회
    BoardVO get(Long no);

    // 게시글 생성
    void create(BoardVO board);

    // 게시글 수정
    int update(BoardVO board);

    // 게시글 삭제
    // public boolean delete(long no);
}
