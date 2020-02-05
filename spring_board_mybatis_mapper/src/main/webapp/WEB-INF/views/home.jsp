<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>메인페이지</title>
</head>
<body>
	<h1>
		메인페이지 
	</h1>
	<!--익명사용자가 오게되면 로그인 페이지를 보여준다  -->
	<sec:authorize access="isAnonymous()">
		<p><a href="<c:url value="/login/loginForm"/>">로그인</a></p>
	</sec:authorize>
	
	<!--검증된 사람이 접근을 할때 유저홈 관리자홈을 띄움  -->
	<sec:authorize access="isAuthenticated()">
		<form:form action="${pageContext.request.contextPath }/logout" method="POST">
			<input type="submit" value="로그아웃" />
		</form:form>
		<p><a href="<c:url value="/loginInfo"/>">로그아웃 정보 확인방법 3가지</a>
	</sec:authorize>
	
	<h3>
		[<a href="<c:url value="/user/userHome"/>">유저홈</a>]
		[<a href="<c:url value="/admin/adminHome"/>">관리자홈</a>]<!--admin페이지를 이렇게주게되면 유저가 접근을 못한다  -->
	
	</h3>
	
	
	
	
</body>
</html>
