<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/teacherHeader.jsp" %>
	<section>
		<h3 align="center">${loginUser.memberBan}반 성적 조회</h3>
		<div align="center">
			국어 평균점수 : ${subjectScore[0]}<br>
			영어 평균점수 : ${subjectScore[1]}<br>
			수학 평균점수 : ${subjectScore[2]}<br>
			과학 평균점수 : ${subjectScore[3]}<br>
			사회 평균점수 : ${subjectScore[4]}<br>
		</div>
	</section>
<%@ include file="../include/footer.jsp" %>	
</body>
</html>