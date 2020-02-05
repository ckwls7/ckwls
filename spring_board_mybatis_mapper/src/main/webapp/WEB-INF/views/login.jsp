<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<%
	/*  getContextPath()=/board 이게나옴  반드시 / 를 붙여야함*/
		String path = request.getContextPath();
	%>
	<%=path %><!--출력-->
	<c:if test="${member==null}"><!--세션에넣음 서버에있는 기타페이지에도 멤버로 접근을 할 수 있다 -->
		<form role="form" method="post" autocomplete="off" action="<%=path %>/member/login">
			<p>
				<label for="userId">아이디</label>
				<input type="text" id="uesrId" name="id"/>
			</p>
			<p>
				<label for="userPass">패스워드</label>
				<input type="password" id="uesrPass" name="pw"/>
			</p>
			<p><button type="submit">로그인</button></p>
			<!-- <p><a href="/member/register">회원가입</a></p> -->
		</form>
	</c:if>
	
	<c:if test="${msg == false }">
		<p style="color:#f00;">로그인에 실패했습니다. 아이디 또는 패스워드를 다시 입력해주십시오.</p>
	</c:if>
	
	<!-- /board/list 이뒤부터는 프로젝트가 관리하는 번호 -->
	<c:if test="${member != null }">
		<p>${member.username}님 환영합니다.</p>
		<!-- /를 반드시 붙인다 루트(/)로부터 시작하는게 절대경로 -->
		<!--상대경로 :  .현재폴더  | .. 상위폴더  ../list 리스트에있는 상위폴더 -->
		<!-- board/list상대경로,/board/list 절대경로  -->
		<%-- <a href="<%=path%>/list">게시판 리스트로</a><br> --%><!--절대경로  -->
		<a href="<%=path%>/board/list">게시판 리스트로</a><br>
		<a href="<%=path%>/member/logout">로그아웃</a>
	</c:if>
	
	
</body>
</html>