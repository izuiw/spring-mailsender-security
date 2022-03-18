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
</style>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
<br><br>
	<a href= "<c:url value='/member/signup'/>"><button>회원가입</button></a>
	<a href= "<c:url value='/member/login'/>"><button>로그인</button></a>

</body>
</html>