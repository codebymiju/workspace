<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 	<a href="./">Home</a> | <a href="MemberLoginForm.me">Login</a> | <a href="MemberJoinForm.me">Join</a>  -->
<%
//세션에 저장된 세션 아이디("sId") 가져와서 변수 sId 에 저장
String sId = (String)session.getAttribute("sId"); // 로그인 안된상태면 null값 리턴
%>
  <div id="member_area">
  <!-- 세션 아이디가 존재하지 않으면 login, join 링크 표시 -->
  <!-- 세션 아이디가 존재하면 아이디, logout 링크 표시 -->
  <%
  if(sId == null || sId.equals("")) { %>
  		<a href="./">Home</a> |
	    <a href="MemberLoginForm.me">Login</a> |
	  	<a href="MemberJoinForm.me">join</a>
  <% } else if(sId.equals("admin")) { %>
  		<a href="MemberList.me">관리자페이지</a> |
  		<a href="./">Home</a> |
  		<a href="MemberLoginPro.me?id=<%=sId%>"><%=sId%>님</a> | 
  	  	<a href="MemberLogout.me">logout</a>
  <% } else { %>
  		<a href="./">Home</a> |
  		<a href="MemberLoginPro.me?id=<%=sId%>"><%=sId%>님</a> | 
  	  	<a href="MemberLogout.me">logout</a>
  <% } %>
</div>