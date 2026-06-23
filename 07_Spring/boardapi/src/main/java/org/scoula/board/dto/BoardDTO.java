package org.scoula.board.dto;

import lombok.*;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// DTO -> 화면 / API에 맞춰서 가공한 데이터
@Data // Getter, Setter, ToString, EqualsAndHashCode, RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    // DB에 저장된 파일 내용
    private List<BoardAttachmentVO> attaches;

    // 실제 업로드 파일(MultipartFile) 목록 (클라이언트에서 전달받음)
    List<MultipartFile> files = new ArrayList<>();

    // VO -> DTO 변환
    public static BoardDTO of(BoardVO vo) {
        return vo == null ? null : BoardDTO.builder()
                .no(vo.getNo())
                .title(vo.getTitle())
                .content(vo.getContent())
                .writer(vo.getWriter())
                .regDate(vo.getRegDate())
                .updateDate(vo.getUpdateDate())
                .attaches(vo.getAttaches()) // 추가
                .build();
    }

    // DTO -> VO 변환
    public BoardVO toVo() {
        return BoardVO.builder()
                .no(no)
                .title(title)
                .content(content)
                .writer(writer)
                .regDate(regDate)
                .updateDate(updateDate)
                .attaches(attaches) // 추가
                .build();
    }
}
