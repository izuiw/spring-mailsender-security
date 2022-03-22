<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<style>
	body{
		text-align: center;
	}
	table {
		margin: auto;
		text-align: center;
		width: 30%;
	}
</style>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
<br><br>
	<c:if test="${empty memberVO}">
	<a href= "<c:url value='/member/signup'/>"><button>회원가입</button></a>
	<a href= "<c:url value='/member/login'/>"><button>로그인</button></a>
	</c:if>
	
	<c:if test="${!empty memberVO}">
		<h2>로그인 성공</h2>
		<table border="1">
			<tr>
				<th>회원 번호</th>
				<th>회원 ID</th>
				<th>회원 인증 여부</th>
			</tr>
			<tr>
				<td>${memberVO.num}</td>
				<td>${memberVO.id}</td>
				<td>${memberVO.authstatus}</td>
			</tr>
		</table>
	<a href= "<c:url value='/member/logout'/>"><button>로그아웃</button></a>
	</c:if>
</body>
</html>