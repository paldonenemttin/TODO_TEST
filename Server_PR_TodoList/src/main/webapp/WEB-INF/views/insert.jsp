<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function() {

		document.querySelector("button.btn_sv").addEventListener(
				"click",
				function(ev) {
					let dom = document;
					let td_work = dom.querySelector("input[name='td_work']");

					let td_space = dom.querySelector("input[name='td_space']");

					let gb_content = dom.querySelector("textarea");
					if (td_work.value == "") {
						alert("할 일은 반드시 입력");
						td_work.focus();
						return false;
					}

					alert("저장" + td_work.value + "\n" + td_date.value + "\n"
							+ td_space.value)

					dom.querySelector("form.in").submit();
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
	<form class="in" method="POST">
		<fieldset>
			<legend>할 일 작성</legend>
			<div>
				<label>할 일</label> <input name="td_work" type="text"
					value="${TD.td_work}">
			</div>
			<div>
				<label>장소</label> <input name="td_space" type="text"
					value="${TD.td_space}">
			</div>
			<div>
				<label>작성일</label> <input name="td_date" type="date"
					value="${TD.td_date}">
			</div>
			<div>
				<button class="btn_sv" type="button">저장</button>
				<button type="reset">재작성</button>
			</div>
		</fieldset>

	</form>
</body>
</html>