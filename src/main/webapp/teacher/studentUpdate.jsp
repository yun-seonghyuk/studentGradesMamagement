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
		<form action="studentUpdate" method="post" name="frm">
			<h1 align="center">${updateMember} 학생 점수 수정</h1>
			<table border="1" >
				<tr>
					<th>국어 점수</th>
					<td><input type="number" name="kor"  value="${sto.kor}"></td>
				</tr>
				<tr>
					<th>영어 점수</th>
					<td><input type="number" name="eng"  value="${sto.eng}"></td>
				</tr>
				<tr>
					<th>수학 점수</th>
					<td><input type="number" name="math"  value="${sto.math}"></td>
				</tr>
				<tr>
					<th>과학 점수</th>
					<td><input type="number" name="science"  value="${sto.science}"></td>
				</tr>
				<tr>
					<th>사화 점수</th>
					<td><input type="number" name="social"  value="${sto.social}"></td>
				</tr>
				<tr>
				<td colspan="3">
					<button type="button" onclick="location.href='studentList?memberName${updateMember}'">목록 보기</button>
					<button type="submit">변경</button>
					<button type="reset">다시 작성</button>
				</td>
			</tr>
			</table>
		</form>
	</section>
<%@ include file="../include/footer.jsp" %>	
</body>
</html>