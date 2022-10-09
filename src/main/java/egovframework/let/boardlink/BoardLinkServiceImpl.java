package egovframework.let.boardlink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardLinkServiceImpl implements BoardLinkService {
    @Autowired
    BoardLinkDAO boardLinkDAO;

    @Override
    public int filelistpagecount(){
        return this.boardLinkDAO.selectFileListPageCount();
    }
    @Override
    public BoardLink selectFileDetail(BoardLink boardLink){
        return this.boardLinkDAO.selectFileDetail(boardLink);
    }
    @Override
    public String createfile(BoardLink boardLink) {
        int affectRowCount = this.boardLinkDAO.insertfile(boardLink);
        if (affectRowCount ==  1) {
            return String.valueOf(boardLink.getUid());
        }
        return null;
    }
    @Override
    public List<BoardList> filelist() {
        return this.boardLinkDAO.selectFileList();
    }
    @Override
    public List<BoardLink> filelistlinkview(BoardLink boardLink) {
        return this.boardLinkDAO.selectFileListlinkview(boardLink);
    }

    @Override
    public String updatefile(BoardLink boardLink) {
        int affectRowCount = this.boardLinkDAO.updatefile(boardLink);
        if (affectRowCount ==  1) {
            return String.valueOf(boardLink.getUid());
        }
        return null;
    }

}
