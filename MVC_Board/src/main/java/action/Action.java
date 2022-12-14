package action;
/*
 * XXXAction 클래스에서 수행할 작업에 대한 메서드를 
 * 공통된 형식으로 제공하기 위한 인터페이스 정의
 * => 각 액션 클래스에서 상속에 대한 제약을 덜어주기 위해 인터페이스로 정의 
 *    (다중 구현 가능) 
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public interface Action {
	// 공통 메서드 execute() 정의 - 추상메서드
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response);
	
}
