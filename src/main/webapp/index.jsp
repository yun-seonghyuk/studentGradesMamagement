<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<section>
		<c:if test="${loginUser.memberId ne null and loginUser.authority eq '학생'}">
			<%@ include file="include/studentHeader.jsp" %>
			<div id="wrap">
				<section>
					<img alt="student" src="./image/student.jpg" width="700px">			
				</section>
			</div>
			<%@ include file="include/footer.jsp" %>
		</c:if>
		
		
		<c:if test="${loginUser.memberId ne null and loginUser.authority eq '선생'}">
			<%@ include file="/include/teacherHeader.jsp" %>
				<section>
					<img alt="student" src="./image/teacher.jpg" width="700px">	
				</section>
			<%@ include file="/include/footer.jsp" %>	
		</c:if>
		
		<c:if test="${loginUser.memberId eq null}">
			<%@ include file="include/header.jsp" %>
			<nav>
				<a href="login">로그인</a>
				<a href="join">회원가입</a>
			</nav>
			<div id="wrap">
				<section>
					<img alt="student" src="./image/home.jpg" width="700px" >
				</section>
			</div>
			<%@ include file="include/footer.jsp" %>
		</c:if>
	
	</section>

</body>
</html>