<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice</title>
</head>
<body>
<h3>notice</h3>
<script>
function clearVal() {
	var inputval=document.getElementById("q");
	inputval.value="";
}
</script>
<c:if test="${empty sessionScope.uid }">
	<a href="../login/login.do">login</a>
	<a href="../joinus/join.jsp">join</a>
	로그인 or 가입해주세요.
</c:if>

<c:if test="${not empty sessionScope.uid }">
	<a href="../login/logoutproc.do">logout</a>
	${sessionScope.uid }님 반값습니다.
</c:if>

<br />

<hr />


<form action="notice.do" method="get">
	<select name="f">
		<option ${param.f=="title"?"selected":"" } value="title">제목</option>
		<option  ${param.f=="content"?"selected":"" }  value="content">내용</option>	
	</select>
	<input type="text" id="q" name="q" value="${query }" onclick="clearVal();" />
	<input type="submit" value="검색" />
</form>
<table width="500" border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
	<c:forEach items="${list }" var="n">
	
		<tr>
			<td>${n.seq }</td>
			<td><a href="noticeDetail.do?c=${n.seq }&h=${n.hit }">${n.title }</a></td>
			<td>${n.writer }</td>
			<td>${n.regdate }</td>
			<td>${n.hit }</td>
		</tr>
	</c:forEach>	
</table>
<a href="noticeReg.jsp">write</a>
</body>
</html>




