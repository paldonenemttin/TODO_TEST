
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp"%>
	<section>
		<form>
			<input name="text">
		</form>
		<button>검색</button>
		<button class="btn_insert">할일 또 미루기</button>
	</section>
	<tr>
		<th>No.</th>
		<th>미룬거</th>
		<th>작성일</th>
		<th>장소</th>
	</tr>
	<table id="tdList">
		<c:forEach items="${TDLIST}" var="TD">
			<tr data-seq="${TD.td_seq}">
				<td>${TD.td_seq}</td>
				<td>${TD.td_work}</td>
				<td>${TD.td_date}</td>
				<td>${TD.td_space}</td>
				<td><button>수정</button></td>
				<td><button>삭제</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>