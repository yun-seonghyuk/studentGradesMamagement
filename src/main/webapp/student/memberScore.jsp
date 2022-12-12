<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/studentHeader.jsp" %>
	<section>
		<h1 align="center"> 학생 성적 조회</h1>
		<table border="1">
			<tr>
				<td>학생이름 : ${loginUser.memberName}<br></td>
			</tr>
			<tr>
				<td>국어점수 : ${StudentScore.kor}<br></td>
			</tr>
			<tr>
				<td>영어점수 : ${StudentScore.eng}<br></td>
			</tr>
			<tr>
				<td>수학점수 : ${StudentScore.math}<br></td>
			</tr>
			<tr>
				<td>과학점수 : ${StudentScore.science}<br></td>
			</tr>
			<tr>
				<td>사회점수 : ${StudentScore.social}<br></td>
			</tr>
			<tr>
				<td>총점 : ${StudentScore.total}<br></td>
			</tr>
			<tr>
				<td>평균 : ${StudentScore.avg}<br></td>
			</tr>
		</table>
	</section>	
<%@ include file="../include/footer.jsp" %>	
</body>
</html>