<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<header>
		<h1>${loginUser.memberBan}반 담임 ${loginUser.memberName}</h1>
	</header>
	
	<nav>
	 	<a href="index.jsp">홈으로</a>
		<a href="logout">로그아웃</a>
		<a href="join">회원가입</a>
	</nav>
	
	<div class="button_center">
		<button type="button" onclick="location='banScore'">과목 성적 조회</button>
		<button type="button" onclick="location='studentList'">학생 목록</button>
		<button type="button"onclick="location='unregistered'">성적 등록</button>
	</div>
</body>
</html>