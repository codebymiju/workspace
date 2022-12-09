package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberLoginProService {
	// 로그인 정보 = db회원 정보와 일치하는지 확인
	public int loginMember(MemberBean member) {
		int loginCount = 0;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		int selectCount = dao.selectMember(member);
		
			if(selectCount > 0) {
				JdbcUtil.commit(con);
				loginCount = 1;
			} else {
				JdbcUtil.rollback(con);
			}
			
		JdbcUtil.close(con);
		
		return loginCount;
	}
	
}
