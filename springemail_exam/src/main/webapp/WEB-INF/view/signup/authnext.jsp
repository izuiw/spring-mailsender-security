<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

	alert("이메일 인증 완료. ${email}님 화원가입을 축하합니다.");
	document.location.href="<c:url value='/login'/>";
</script>