package org.scoula.board.service;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    // 게시글 전체 조회
    List<BoardDTO> getList();

    // 게시글 단건 조회
    BoardDTO get(Long no);

    // 게시글 생성
    void create(BoardDTO board);

    // 게시글 수정
    boolean update(BoardDTO board);

    // 게시글 삭제
    boolean delete(Long no);

    // 첨부파일 단건 조회
    BoardAttachmentVO getAttachment(Long no);
}
