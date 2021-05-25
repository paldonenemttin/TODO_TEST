
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<script type="text/javascript">
	document
			.addEventListener(
					"DOMContentLoaded",
					function() {

						document
								.querySelector("table#tdList")
								.addEventListener(
										"click",
										function(ev) {

											//ev.preventDefault();
											//ev.stopPropagation();
											//가장 안쪽 tag(TD)의 이름을 가져와라
											let tag_name = ev.target.tagName;

											if (tag_name == "TD") {
												let gb_seq = ev.target
														.closest("TR").dataset.seq

												document.location.href = "${rootPath}/todo/view?td_seq="
														+ ${TD.td_seq}

											}

										})

						document
								.querySelector("button.btn_insert")
								.addEventListener(
										"click",
										function(ev) {

											document.location.href = "${rootPath}/todo/insert"
										})
					})
</script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp"%>
	<button class="btn_insert">할일추가</button>

	<table id="tdList">
		<tr>
			<th>No.</th>
			<th>할일</th>
			<th>작성일</th>
			<th>장소</th>
		</tr>
		<c:forEach items="${TDLIST}" var="TD">
			<tr data-seq="${TD.td_seq}">
				<td>${TD.td_seq}</td>
				<td>${TD.td_work}</td>
				<td>${TD.td_date}</td>
				<td>${TD.td_space}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>