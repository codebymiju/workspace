package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberLoginProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		try {
			MemberBean member = new MemberBean();
			MemberLoginProService service = new MemberLoginProService();

			member.setId(request.getParameter("id"));
			member.setPasswd(request.getParameter("passwd"));
			
			int serviceCount =  service.loginMember(member);
			
			if(serviceCount > 0) {
				
				HttpSession session = request.getSession();
				session.setAttribute("sId", member.getId());
				
				forward = new ActionForward();
				forward.setPath("index.jsp?sId="+member.getId());
				forward.setRedirect(false);
			
			} else {
				response.setContentType("text/html; charset=UTF-8"); // html 형식 넘겨준다는 표시
				PrintWriter out = response.getWriter(); // 자바 코드를 위해 html태그 출력
				out.println("<script>");
				out.println("alert('로그인 실패!')");
				out.println("history.back()");
				out.println("</script>");
			}
		} catch (IOException e) {
			System.out.println("MemberLoginProAction 오류");
			e.printStackTrace();
		}
		
		return forward;
	}

}
