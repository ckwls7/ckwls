<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<a href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> <a href="write_view">글작성</a> </td>
		</tr>
	</table>
	
	
		<c:if test="${pageMaker.prev}"><!--pageMaker.getprev출력, 트루이게되면 링크를걸음 -->
			<a href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
			<!--get방식의 key value를 넘김, 함수를 다이렉트로 추출하는 소스(직접호출) -->
		</c:if>
			<!-- var="idx"하게되면 1씩증가  -->
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
			<c:out value="${pageMaker.cri.page == idx?'':''}" />
			<a href="list2${pageMaker.makeQuery(idx)}">${idx}</a>
		</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<a href="list2${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a>
			</c:if> <br>
		<!-- <button type="submit">글쓰기</button> -->
	
</body>
</html>