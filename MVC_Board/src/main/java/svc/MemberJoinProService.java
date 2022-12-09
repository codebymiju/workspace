package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberJoinProService {

	public boolean joinMember(MemberBean member) {
		boolean isJoinMember = false;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertMember(member);
		
			if(insertCount > 0) { // 성공시
				JdbcUtil.commit(con);
				isJoinMember = true;
			} else { // 실패시
				JdbcUtil.rollback(con);
			}
		
		JdbcUtil.close(con);
		
		return isJoinMember;
	}
	
	
	
	
}
