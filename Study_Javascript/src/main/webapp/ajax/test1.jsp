<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.3.js"></script>
<script type="text/javascript">
$(function() {
	$("#btnLogin").on("click", function() {
		// AJAX를 사용하여 test1_result.jsp 페이지로 요청 전송하기
		$.ajax({
			type: "post",  // AJAX 로 요청시 HTTP 요청 방식(GET or Post)
			url: "test1_result.jsp",
			data: { // 전송할 데이터(파라미터) 지정 : 중괄호로 묶음
				id: $("#id").val(),
				passwd: $("#passwd").val()
			},
			dataType: "text", // 응답 데이터에 대한 타입 지정(일반 데이터는 text, 자바스크립트 포함시 html 사용)
			success: function(response){ // 요청에 대한 처리 성공 시 자동 호출
				// 익명 함수 파라미터로 응답 데이터가 전달됨(처리 페이지의 응답 결과)
				$("#resultArea").html(response);
			
			},
			error: function(xhr, textStatus, errorThrown) {
				$("#resultArea").html("xhr = " + xhr + "<br>textStatus = " + textStatus + "<br>errorThrown = " + errorThrown);
			}
		});
		
	});
});
</script>
</head>
<body>
	<h1>AJAX - test1.jsp</h1>
	<h1>로그인</h1>
		<form action="" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" id="id" required="required" size="20"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="passwd" id="passwd" required="required" size="20"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="로그인" id="btnLogin">
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<div id = "resultArea"><!-- AJAX 요청에 대한 응답 처리 결과 출력할 위치 --></div>
		<hr>
</body>
</html>
