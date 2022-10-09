package egovframework.let.boardlink;

import egovframework.let.cop.bbs.service.BoardVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter @Setter
@NoArgsConstructor
public class BoardLink extends BoardVO {
    //게시물
    //private Long uid;//pk
    private int uid;//pk

    /** 새로 만든 페이지 넘버 */
    private int pageNo;

    private String board;//게시판이름
    private String id;//null
    private String name;//사람이름
    private String zone;//청,서
    private String place;//부서
    private String job;//null
    private String owner;//청,서

    private String sub;//제목

    private String con;//내용

    private int html;
    private int passive;
    private int notice;
    private int zview;
    private int depth;

    private String fname;//파일암호화이름
    private String fdate;//실제파일이름
    private int signdate;//생성날짜암호화
    private String movie;//파일
    private int sdate;//생성날짜암호화
    private int edate;//생성날짜암호화
    private int mainview;
    private int twitadd;
    private int fdadd;

    private Date date;

    public BoardLink(String board,String id,String name,String zone,String place,String job,String owner,String sub,String con,int signdate) {
        this.board = board;
        this.id = id;
        this.name = name;
        this.zone = zone;
        this.place = place;
        this.job = job;
        this.owner = owner;
        this.sub = sub;
        this.con = con;
        this.signdate = signdate;
    };

}
