<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded",function() {
	document.querySelector("div.view_btn").addEventListener("click",function(ev) {
		
		let className = ev.target.className
		
		if(className == "btn_update") {
			document.location.href = "${rootPath}/todo/update?td_seq=" + ${TD.td_seq}
		} else if(className == "btn_delete") {
			if(confirm("할일 삭제합니다")) {
				document
				.location
				.replace( "${rootPath}/todo/delete?td_seq=" + ${TD.td_seq} )
			}
		}
		
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
	<table>
		<tr>
			<th>No.</th>
			<td>${TD.td_seq}</td>
			<th>할 일</th>
			<td>${TD.td_work}</td>
			<th>장소</th>
			<td>${TD.td_space}</td>
			<th>작성일</th>
			<td>${TD.td_date}</td>
		</tr>
	</table>
	<div class="view_btn">
		<button class="btn_update">수정</button>
		<button class="btn_delete">삭제</button>
	</div>

</body>
</html>