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
			member.setId(request.getParameter("id"));
			member.setPasswd(request.getParameter("passwd"));
			
			MemberLoginProService service = new MemberLoginProService();
			int serviceCount =  service.loginMember(member);
			
			if(serviceCount > 0) { // 12/12 변경
				// 서블릿 클래스에서 세션 객체에 직접 접근이 불가능함(내장 객체가 없음)
				// 따라서, request 객체로부터 세션 객체를 얻어와야 함(리턴타입 HttpSession)
				
				HttpSession session = request.getSession();
				session.setAttribute("sId", member.getId());
				
				forward = new ActionForward();
				forward.setPath("./");
				forward.setRedirect(true);
			
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
