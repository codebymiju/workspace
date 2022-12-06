package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import db.JdbcUtil;
import svc.BoardModifyProService;
import vo.ActionForward;

public class BoardModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		System.out.println("BoardModifyProAction");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String board_name = request.getParameter("board_name");
		String board_pass = request.getParameter("board_pass");
		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("board_content");
		
		try {
			BoardModifyProService service = new BoardModifyProService();
			boolean isBoardWriter = service.modifyBoard(board_num,board_pass);
			
			if(!isBoardWriter) {
				response.setContentType("text/html; charset=UTF-8"); // html 형식 넘겨준다는 표시
				PrintWriter out = response.getWriter(); // 자바 코드를 위해 html태그 출력
				out.println("<script>");
				out.println("alert('수정 권한이 없습니다!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				boolean isUpdateWriter = service.updateBoard(board_num, board_name, board_pass, board_subject, board_content);
				 if(!isUpdateWriter) {
					 response.setContentType("text/html; charset=UTF-8"); // html 형식 넘겨준다는 표시
					 PrintWriter out = response.getWriter(); // 자바 코드를 위해 html태그 출력
					 out.println("<script>");
					 out.println("alert('글 수정 실패!')");
					 out.println("history.back()");
					 out.println("</script>");
				 } else {
					 forward = new ActionForward();
					 forward.setPath("BoardDetail.bo?board_num=" + request.getParameter("board_num") + "&pageNum=" + request.getParameter("pageNum"));
					 forward.setRedirect(true);
				 }
			}
		} catch (IOException e) {
			System.out.println("BoardModifyProAction - execute()");
			e.printStackTrace();
		}
	
		return forward;
	}

}
