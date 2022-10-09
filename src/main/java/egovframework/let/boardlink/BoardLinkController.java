package egovframework.let.boardlink;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/boardlink")
public class BoardLinkController {
    @Autowired
    BoardLinkService boardLinkService;
    private String boardroot = "book";

    @GetMapping("")
    public String boardlink(Model model) {
        List<BoardList> boardList = this.boardLinkService.filelist();
        model.addAttribute("data",boardList);
        return "/"+boardroot+"/boardlink";
    }
    @GetMapping("/{board}")
    public String boardlinkview(@ModelAttribute("BoardLink") BoardLink boardLink, Model model) {
        if(boardLink.getPageNo() == 0) {
            boardLink.setPageNo(1);
        }
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(boardLink.getPageNo()); //현재 페이지 번호
        paginationInfo.setRecordCountPerPage(5); //한 페이지에 게시되는 게시물 건수
        paginationInfo.setPageSize(8); //페이징 리스트의 사이즈

        boardLink.setFirstIndex(paginationInfo.getFirstRecordIndex());
        boardLink.setLastIndex(paginationInfo.getLastRecordIndex());
        boardLink.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

        List<BoardLink> boardLink1 = this.boardLinkService.filelistlinkview(boardLink);

        model.addAttribute("data",boardLink1);

        int fileCount = this.boardLinkService.filelistpagecount();
        paginationInfo.setTotalRecordCount(fileCount); //전체 게시물 건 수
        model.addAttribute("paginationInfo", paginationInfo);

        return "/"+boardroot+"/boardlinkview";
    }

    @GetMapping("/{board}/{uid}")
    public String boarddetail(@ModelAttribute("BoardLink") BoardLink boardLink, Model model) {
        int uid = boardLink.getUid();
        BoardLink boardLink1 = this.boardLinkService.selectFileDetail(boardLink);

        int timestamp = boardLink1.getSigndate();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date = new Date();
        date.setTime(timestamp*1000);

        boardLink1.setDate(date);

        model.addAttribute("data", boardLink1);

        return "/"+boardroot+"/boarddetail";
    }

    @GetMapping("/write")
    public String filecreate(BoardLink boardLink, Model model) {


        model.addAttribute("data", boardLink);

        return "/"+boardroot+"/boarddetailcreate";
    }

    @PostMapping("/write")
    public String filecreatePost(BoardLink boardLink, RedirectAttributes redirectAttributes) {

        String uid = this.boardLinkService.createfile(boardLink);
        System.out.println(boardLink);
        System.out.println(uid+"uid is written");
        if (uid == null) {
            return "redirect:/write";
        }else {
            redirectAttributes.addAttribute("uid", uid);
            return "redirect:/detailfile?uid={uid}";
        }
    }

    @GetMapping("/{board}/{uid}/edit")
    public String boardeditdetail(@ModelAttribute("BoardLink") BoardLink boardLink, Model model) {
        int uid = boardLink.getUid();
        BoardLink boardLink1 = this.boardLinkService.selectFileDetail(boardLink);

        System.out.println(boardLink);
        model.addAttribute("data", boardLink1);

        return "/"+boardroot+"/boardeditdetail";
    }

    @PostMapping("/{board}/{uid}/edit")
    public String boardeditdetailpost(@ModelAttribute("BoardLink") BoardLink boardLink,RedirectAttributes redirectAttributes) {
        int uid1 = boardLink.getUid();
        String uid = this.boardLinkService.updatefile(boardLink);
        System.out.println(boardLink);
        System.out.println(uid+"uid is written");
        if (uid == null) {
            return "redirect:/boardlink/{board}";
        }else {
            redirectAttributes.addAttribute("uid", uid);
            return "redirect:/boardlink/{board}/{uid}";
        }
    }
}
