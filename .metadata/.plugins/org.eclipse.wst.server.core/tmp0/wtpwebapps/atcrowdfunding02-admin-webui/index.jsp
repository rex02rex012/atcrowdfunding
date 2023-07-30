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
		
		
		
		
		
		
		$("#btn4").click(function(){
			
			// 準備要發送的數據
			var student = {
				"stuId": 5,
				"stuName":"tom",
				"address": {
					"province": "廣東",
					"city": "深圳",
					"street":"後瑞"
				}, 
				"subjectList": [
					{
						"subjectName": "JavaSE",
						"subjectScore": 100
					},{
						"subjectName": "SSM",
						"subjectScore": 99
					}
				],
				"map": {
					"k1":"v1",
					"k2":"v2"
				}
			};
			
			// 將JSON對象轉換為JSON字元串
			var requestBody = JSON.stringify(student);
			
			// 發送Ajax請求
			$.ajax({
				"url":"send/compose/object.json",
				"type":"post",
				"data":requestBody,
				"contentType":"application/json;charset=UTF-8",
				"dataType":"json",
				"success":function(response){
					console.log(response);
				},
				"error":function(response){
					console.log(response);
				}
			});
			
		});
		
		$("#btn3").click(function(){ //主要的方式
			
			// 準備好要發送到服務器端的數組
			var array = [5, 8, 12];
			console.log(array.length);//3
			
			// 將JSON數組轉換為JSON字元串
			var requestBody = JSON.stringify(array);
			// "['5','8','12']"
			console.log(requestBody.length);//8
			
			$.ajax({
				"url": "send/array/three.html",		// 請求目標資源的地址
				"type": "post",				// 請求方式
				"data": requestBody,				// 請求體
				"contentType": "application/json;charset=UTF-8",	// 設置請求體的內容類型，告訴服務器端本次請求的請求體是JSON數據
				"dataType": "text",					// 如何對待服務器端返回的數據
				"success": function(response) {		// 服務器端成功處理請求後調用的回調函數，response是響應體數據
					alert(response);
				},
				"error":function(response) {		// 服務器端處理請求失敗後調用的回調函數，response是響應體數據
					alert(response);
				}
			});
			
		});
		
		$("#btn2").click(function(){
			
			$.ajax({
				"url": "send/array/two.html",			// 請求目標資源的地址
				"type": "post",						// 請求方式
				"data": {							// 要發送的請求參數
					"array[0]": 5,
					"array[1]": 8,
					"array[2]": 12
				},
				"dataType": "text",					// 如何對待服務器端返回的數據
				"success": function(response) {		// 服務器端成功處理請求後調用的回調函數，response是響應體數據
					alert(response);
				},
				"error":function(response) {		// 服務器端處理請求失敗後調用的回調函數，response是響應體數據
					alert(response);
				}
			});
			
		});
		
		$("#btn1").click(function(){
			
			$.ajax({
				"url": "send/array/one.html",		// 請求目標資源的地址
				"type": "post",				// 請求方式
				"data": {					// 要發送的請求參數
					"array": [5,8,12]
				},
				"dataType": "text",				// 如何對待服務器端返回的數據
				"success": function(response) {		// 服務器端成功處理請求後調用的回調函數，response是響應體數據
					alert(response);
				},
				"error":function(response) {		// 服務器端處理請求失敗後調用的回調函數，response是響應體數據
					alert(response);
				}
			});
			
		});
	});
	
</script>
</head>
<body>

	<a href="test/ssm.html">測試SSM整合環境</a>
	
	<br/>
	<br/>
	
	<button id="btn1">Send [5,8,12] One</button>
	
	<br/>
	<br/>
	
	<button id="btn2">Send [5,8,12] Two</button>
	
	<br/>
	<br/>
	
	<button id="btn3">Send [5,8,12] Three</button>
	
	<br/>
	<br/>
	
	<button id="btn4">Send Compose Object</button>

</body>
</html>