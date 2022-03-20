<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

	alert("${memberVO.id}님 로그인 성공.");
	document.location.href="<c:url value='/main'/>";
</script>