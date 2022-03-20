<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	text-align: center;
}

table {
	margin: auto;
	width: 50%;
	height: 150px;
}
</style>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<form:form commandName="loginMemberData">
		<table border="1">
			<tr>
				<td>아이디 : </td>
				<td><form:input path="id" placeholder="필수입력"/>
				<form:errors path="id"/></td>
			</tr>

			<tr>
				<td>비밀번호 : </td>
				<td><form:input path="pwd" type="password" placeholder="필수입력"/>
				<form:errors path="pwd"/></td>
			</tr>
		
		</table>
		<br>
		${msg}<br><br>
		<input type="submit" value="로그인" />
		<input type="button" value="회원가입" onclick="location.href='<c:url value='/member/signup'/>'"/>
	</form:form>

		

</body>
</html>