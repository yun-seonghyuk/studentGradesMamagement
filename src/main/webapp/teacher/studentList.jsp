<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/teacherHeader.jsp" %>
	<section>
		<h1 align="center">${memberBan}반 학생 명단	${count}명</h1>
		<table border="1"  wi >
			<c:forEach var="list" items="${mto2}" varStatus="status">
				<tr>
					<td>
						${status.count} 
					</td>
					<td>
						${list.memberId} 	
					</td>
					<td>
						<a href="grade?memberName=${list.memberName}">${list.memberName}</a><br>	
					</td>
					<td colspan="2">
						<button type="button" onclick="location.href='studentDelete?memberName=${list.memberName}'">삭제</button>
						<button type="button" onclick="location.href='studentUpdate?memberName=${list.memberName}'">수정</button>
					</td>
				</tr>
				
			</c:forEach>	
		</table>
	</section>
<%@ include file="../include/footer.jsp" %>	
</body>
</html>