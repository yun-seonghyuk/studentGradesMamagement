<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  defer="defer" type="text/javascript" src="./script/member.js"></script>
</head>
<body>
<%@ include file="../include/teacherHeader.jsp" %>
	<section>
		<form action="scoreInput" method="post"  name="frm">
			<h1 align="center">${scoreInputMember} 학생 성적 등록</h1>
			<table border="1">
				<tr>
					<th>국어점수 : </th>
					<td><input type="number" name="kor" min="0" max="100"></td>
				</tr>
				<tr>
					<th>영어 점수 : </th>
					<td><input type="number" name="eng" min="0" max="100"></td>
				</tr>
				<tr>
					<th>수학 점수 : </th>
					<td><input type="number" name="math" min="0" max="100"></td>
				</tr>
				<tr>
					<th>과학 점수 : </th>
					<td><input type="number" name="science" min="0" max="100"></td>
				</tr>
				<tr>
					<th>사회 점수 : </th>
					<td><input type="number" name="social" min="0" max="100"></td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<button type="submit" onclick="return scoreInputCheck()" >등록</button>
						<button type="reset">다시 작성</button>
						<button type="button" onclick="location.href='index.jsp'">목록 돌아가기</button>
					</td>
				</tr>
			</table>
		</form>
	</section>
<%@ include file="../include/footer.jsp" %>		
</body>
</html>