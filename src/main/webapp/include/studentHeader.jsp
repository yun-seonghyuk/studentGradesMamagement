<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<header>
		<h1>${loginUser.memberName} ${loginUser.memberBan}반 담임 ${homeRoomTeacher}</h1>
	</header>
	 <nav>
	 	<a href="index.jsp">홈으로</a>
		<a href="logout">로그아웃</a>
		<a href="join">회원가입</a>
	</nav>
	<div class="button_center">
		<button type="button" onclick="location='grade'">개인 성적 조회</button>
		<button type="button" onclick="location='banScore'">반 성적 조회</button>
	</div>
</body>
</html>