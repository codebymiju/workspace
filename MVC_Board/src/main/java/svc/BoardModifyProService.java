package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
// 12/05 숙제
public class BoardModifyProService {

	public boolean modifyBoard(int board_num, String board_pass) {
		boolean ismodifyChange = false;
		Connection con = JdbcUtil.getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		ismodifyChange = dao.isBoardWriter(board_num, board_pass);
		
		JdbcUtil.close(con);
		
		return ismodifyChange;
		
	}

	public boolean updateBoard(int board_num, String board_name, String board_pass, String board_subject,
			String board_content) {
		boolean isUpdateWriter = false;
		
		Connection con = JdbcUtil.getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		int updateCount = dao.updateBoard(board_num, board_name, board_pass, board_subject, board_content);
		
		 if(updateCount > 0) {
			 isUpdateWriter = true;
			 JdbcUtil.commit(con);
		 } else {
			 JdbcUtil.rollback(con);
		 }
		
		JdbcUtil.close(con);
		
		return isUpdateWriter;
	}

	
	
}
