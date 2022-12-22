<%@page import="free.FreeBoardDTO"%>
<%@page import="free.FreeBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 번호, 페이지 파라미터 가져오기
int idx = Integer.parseInt(request.getParameter("idx"));
String pageNum = request.getParameter("pageNum");

// free_boardDAO 객체의 selectFileBoard() 메서드 호출하여 게시물 1개 정보 조회 - 메서드 재사용
// -> 파라미터 : 글번호 (idx)  리턴타입 : free_boardDTO (free)
FreeBoardDAO dao = new FreeBoardDAO();
FreeBoardDTO freeBoard = dao.selectFreeBoard(idx);
System.out.println(freeBoard);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>free_board_update</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">
		<!-- 헤더 들어가는곳 -->
		<jsp:include page="../inc/top.jsp" />
		<!-- 헤더 들어가는곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 본문 메인 이미지 -->
		<div id="sub_img_center"></div>
		<!-- 왼쪽 메뉴 -->
		<jsp:include page="../inc/left.jsp"></jsp:include>
		<!-- 본문 내용 -->
		<article>
			<h1>Free Board Update</h1>
			<form action="free_board_updatePro.jsp" method="post" enctype="multipart/form-data">
				<input type="hidden" name ="idx" value="<%=idx%>">
				<input type="hidden" name ="pageNum" value="<%=pageNum%>"> 
				<!-- 업로드 할 파일을 새로 선택하지 않을 경우를 대비하여 기존 파일명 포함시키기 -->
				<input type="hidden" name ="old_original_file" value="<%=freeBoard.getOriginal_file()%>"> 
				<input type="hidden" name ="old_real_file" value="<%=freeBoard.getReal_file()%>"> 
				
				<table id="notice">
					<tr>
						<td>글쓴이</td>
						<td><input type="text" name="name" value="<%=freeBoard.getName()%>" required="required" readonly="readonly"></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input type="password" name="pass" required="required"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="subject" value="<%=freeBoard.getSubject()%>" required="required"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea rows="10" cols="20" name="content" required="required"><%=freeBoard.getContent()%></textarea></td>
					</tr>
					<!-- 파일 업로드를 위한 입력폼 추가 -->
					<tr>
						<td>파일</td>
						<td>
							<input type="file" name="original_file" ><br>
							(현재 파일 : <%=freeBoard.getOriginal_file()%>)
						</td>
					</tr>
				</table>

				<div id="table_search">
					<input type="submit" value="글수정" class="btn">
					<input type="button" value="취소" class="btn" onclick="history.back()">
				</div>
			</form>
			<div class="clear"></div>
		</article>


		<div class="clear"></div>
		<!-- 푸터 들어가는곳 -->
		<jsp:include page="../inc/bottom.jsp" />
		<!-- 푸터 들어가는곳 -->
	</div>
</body>
</html>