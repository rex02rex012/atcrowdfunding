<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- http://localhost:8080/atcrowdfunding02-admin-webui/test/ssm.html -->
<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"/>
<script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn5").click(function(){
			layer.msg("layer的彈框")
		});
	});
</script>
</head>
<body>
	<button id="btn5">Send [5,8,12] One</button>
</body>
</html>