package egovframework.let.boardlink;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardLinkDAO extends EgovAbstractDAO {

    @Autowired SqlSessionTemplate sqlSessionTemplate;

    public int selectFileListPageCount() {
        return this.sqlSessionTemplate.selectOne("egovframework.let.boardlink.service.impl.BoardLinkDAO.select_filepagecount");
    }
    public BoardLink selectFileDetail(BoardLink boardLink) {
        return this.sqlSessionTemplate.selectOne("egovframework.let.boardlink.service.impl.BoardLinkDAO.select_filedetail", boardLink);
    }
    public int insertfile(BoardLink boardLink) {
        return this.sqlSessionTemplate.insert("egovframework.let.boardlink.service.impl.BoardLinkDAO.insert_file", boardLink);
    }
    public List<BoardList> selectFileList() {
        return this.sqlSessionTemplate.selectList("egovframework.let.boardlink.service.impl.BoardLinkDAO.select_filelist");
    }
    public List<BoardLink> selectFileListlinkview(BoardLink boardLink) {
        return this.sqlSessionTemplate.selectList("egovframework.let.boardlink.service.impl.BoardLinkDAO.select_filelistlinkview", boardLink);
    }
    public int updatefile(BoardLink BoardLink) {
        return this.sqlSessionTemplate.update("egovframework.let.boardlink.service.impl.BoardLinkDAO.update_file", BoardLink);
    }
}
