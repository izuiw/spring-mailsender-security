<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	alert("회원가입 완료! 이메일을 인증을 완료해 주세요.");
	document.location.href="<c:url value='/main'/>";
</script>