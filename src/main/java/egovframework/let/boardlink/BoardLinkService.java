package egovframework.let.boardlink;

import java.util.List;

public interface BoardLinkService {

    BoardLink selectFileDetail(BoardLink boardLink);

    String createfile(BoardLink boardLink);

    int filelistpagecount();

    List<BoardList> filelist();

    List<BoardLink> filelistlinkview(BoardLink boardLink);

    String updatefile(BoardLink boardLink);
}
