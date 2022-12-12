<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크 페이지</title>
<script type="text/javascript" src="./script/member.js"></script>
</head>
<body>
<h3>아이디 중복 체크</h3>
<form action="idCheck" method="GET" name="frm">
	아이디 : <input type="text" name="memberId" value="${memberId}">
	<button type="submit">중복 체크</button><br>
	
	 <c:if test="${result==1}">  <!-- 중복된 아이디가 있다 -->
	 	<script type="text/javascript">
	 		// 부모창(opener)에 입력된 아이디 값 제거
	 		opener.document.frm.memberId.value='';
	 	</script>
	 	${memberId}는 이미 사용중인 아이디입니다.
	 </c:if>
	 
	<c:if test="${result==-1}">  <!-- 중복된 아이디가 없다 -->
	 	${userid}는 사용 가능한 아이디 입니다.
	 	<button type="button" onclick="idOk()">사용</button> 
	 </c:if>
	 
</form>
</body>
</html>