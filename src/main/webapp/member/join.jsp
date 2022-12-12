<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="./script/member.js"></script>
</head>
<body>
<%@ include file="../include/header.jsp" %>
	<nav>
		<a href="index.jsp">홈으로</a>
		<a href="login">로그인</a>
	</nav>
	<section>
		<h3 align="center">회원 가입 페이지</h3>
		<form action="join" method="post" name="frm">
			<table border="1">
				<tr>
					<th>이름</th>
					<td><input type="text" name="memberName" size="20">*</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="memberId" size="20">*
						<input type="hidden" name="reid" size="20">
						<button type="button" onclick="idCheck()">중복 체크</button><br>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="memberPwd" size="20">*</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="pwd_check" size="20">*</td>
				</tr>
				<tr>
					<th>반</th>
					<td>
						A <input type="radio" name="memberBan" value="A" checked>
						B <input type="radio" name="memberBan" value="B" >
					</td>
				</tr>
				<tr>
					<th>권한</th>
					<td>
						학생<input type="radio" name="authority" value="학생" checked>
						선생<input type="radio" name="authority" value="선생">
					</td>	
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" onclick="return joinCheck()">회원 가입</button>&nbsp;&nbsp;
						<button type="reset">취소</button>
					</td>
				</tr>
				<tr>
					<td colspan="2"> ${message} </td>
				</tr>
			</table>
		</form>
	</section>
	
	<%@ include file="../include/footer.jsp" %>	
</body>
</html>