package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

// 12/05 01-(1)
public class BoardDetailService {

	public BoardBean getBoard(int board_num) {
		BoardBean board = null;
		
		// 공통작업-1. Connection 객체 가져오기
		Connection con = JdbcUtil.getConnection();
		// 공통작업-2. BoardDAO 객체 가져오기
		BoardDAO dao = BoardDAO.getInstance();
		// 공통작업-3. BoardDAO 객체에 Connection 객체 전달하기
		dao.setConnection(con);
		
		// 1-(1).1
		// BoardDAO 의 selectBoard() 메서드 호출하여 게시물 상세 정보 조회 작업 수행
		// => 파라미터 : 글번호    리턴타입 : BoardBean(board)
		board = dao.selectBoard(board_num);
		
		// 1-(1).2
		// 리턴받은 BoardBean 객체가 null이 아닐 경우
		// updateReadcount() 메서드 호출 > 조회수 증가 작업 
		// 작업이 성공했을 경우 commit 작업 수행 + BoardBean 객체의 조회수 값 1 증가 시키기
		if(board != null) {
			int updateCount = dao.updateReadCount(board_num);
			if(updateCount > 0) {
				JdbcUtil.commit(con);
				board.setBoard_readcount(board.getBoard_readcount() + 1);
			}
		}
		
		// 공통작업-4. Connection 객체 반환하기
		JdbcUtil.close(con);
		
		
		return board;
	}
}
