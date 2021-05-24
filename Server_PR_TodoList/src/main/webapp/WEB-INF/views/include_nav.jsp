<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded",function(){
	
	document.querySelector("nav#home").addEventListener("click", function(ev){
		
		let text = ev.target.textContext;
		alert(text + "을 클릭했구만 자네")
		
		let url ="${rootPath}"
		if(text == "목록"){
			url += "/"
		}
		
		document.location.herf = url
		
	})
	
})	
</script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>해야 할 일은 차곡차곡 쌓아둡시다</h1>
	<nav id="home">
	<ul>
		<li><a href="${rootPath}/">목록</a></li>
	</ul>
	</nav>

</body>
</html>