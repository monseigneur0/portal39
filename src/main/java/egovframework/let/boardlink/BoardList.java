package egovframework.let.boardlink;

import egovframework.let.cop.bbs.service.BoardVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class BoardList extends BoardVO {
    //게시물
    //private Long uid;//pk
    private int uid;//pk

    private String name;
    private String type;
    private String code;
    private String owner;
    private String rank;

    private int fname;
    private int w;
    private int r;
    private int ipin;
    private int n;
    private int v;
    private int h;
    private int i;
}
