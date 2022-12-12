<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="../css/style.css" />
<script  defer="defer" type="text/javascript" src="./script/member.js"></script>
</head>
<body>
<%@ include file="../include/header.jsp" %>
	<section>
		<h3 align="center">로그인</h3>
		<form action="login" method="post" name="frm">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="memberId" value="${memberId}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="memberPwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" onclick="return loginCheck()">로그인</button>&nbsp;&nbsp;
						<button type="reset">취소</button>&nbsp;&nbsp;
						<button type="button" onclick="location.href='join'">회원가입</button>
					</td>
				</tr>
				<tr>
					<td colspan="2" >${message}</td>
				</tr>
			</table>
		</form>		
	</section>
	 

<%@ include file="../include/footer.jsp" %>	
</body>
</html>