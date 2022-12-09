package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.MemberBean;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		MemberListService service = new MemberListService();
		List<MemberBean> memberList = service.getMemberList();
		
		request.setAttribute("memberList", memberList);
		
		forward = new ActionForward();
		forward.setPath("member/member_list.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
