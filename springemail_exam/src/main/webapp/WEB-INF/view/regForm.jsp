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
<title>회원 가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form:form commandName="regMemberData">
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

			<tr>
				<td>Email : </td>
				<td><form:input path="email" placeholder="필수입력"/>
				<form:errors path="email"/></td>
				
			</tr>
			


		</table>
		<br>
		<input type="submit" value="가입하기" />
	</form:form>

</body>
</html>