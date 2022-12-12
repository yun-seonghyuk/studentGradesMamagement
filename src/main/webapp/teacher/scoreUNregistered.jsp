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
		<h1 align="center">성적 미등록자 명단</h1>
		<table border="1" >
			<c:forEach var="list" items="${nmL}" varStatus="status">
				<tr>
					<td>
						${status.count} 
					</td>
					<td>
						<a href="scoreInput?memberName=${list.memberName}">${list.memberName}</a><br>	
					</td>
				</tr>
				
			</c:forEach>	
		</table>
	</section>
<%@ include file="../include/footer.jsp" %>		
</body>
</html>