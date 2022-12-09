package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberJoinProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberJoinProAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		try {
			MemberBean member = new MemberBean();
				member.setName(request.getParameter("name"));
				member.setGender(request.getParameter("gender"));
				member.setEmail(request.getParameter("email1")+"@"+request.getParameter("email2"));
				member.setId(request.getParameter("id"));
				member.setPasswd(request.getParameter("passwd"));
				
			MemberJoinProService service = new MemberJoinProService();
			Boolean isJoinMember = service.joinMember(member);
			
			if(!isJoinMember) {
				
					response.setContentType("text/html; charset=UTF-8"); // html 형식 넘겨준다는 표시
					PrintWriter out = response.getWriter(); // 자바 코드를 위해 html태그 출력
					out.println("<script>");
					out.println("alert('회원 가입 실패!')");
					out.println("history.back()");
					out.println("</script>");
				
			} else {
				forward = new ActionForward();
				forward.setPath("member/member_join_result.jsp");
				forward.setRedirect(true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return forward;
	}

}
