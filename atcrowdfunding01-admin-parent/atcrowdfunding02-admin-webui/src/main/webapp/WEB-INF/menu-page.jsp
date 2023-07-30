<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp"%>
<link rel="stylesheet" href="ztree/zTreeStyle.css"/>
<script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="crowd/my-menu.js"></script>
<script type="text/javascript">

	$(function(){
		
		// 調用專門封裝好的函數初始化樹形結構
		generateTree();
		
		// 給添加子節點按鈕綁定單擊響應函數
		$("#treeDemo").on("click",".addBtn",function(){
			
			// 將當前節點的id，作為新節點的pid保存到全局變量
			window.pid = this.id;
			
			// 打開模態框
			$("#menuAddModal").modal("show");
			
			return false;
		});
		
		// 給添加子節點的模態框中的保存按鈕綁定單擊響應函數
		$("#menuSaveBtn").click(function(){
			
			// 收集表單項中用戶輸入的數據
			var name = $.trim($("#menuAddModal [name=name]").val());
			var url = $.trim($("#menuAddModal [name=url]").val());
			
			// 單選按鈕要定位到“被選中”的那一個
			var icon = $("#menuAddModal [name=icon]:checked").val();
			
			// 發送Ajax請求
			$.ajax({
				"url":"menu/save.json",
				"type":"post",
				"data":{
					"pid": window.pid,
					"name":name,
					"url":url,
					"icon":icon
				},
				"dataType":"json",
				"success":function(response){
					var result = response.result;
					
					if(result == "SUCCESS") {
						layer.msg("操作成功！");
						
						// 重新加載樹形結構，註意：要在確認服務器端完成保存操作後再刷新
						// 否則有可能刷新不到最新的數據，因為這裏是異步的
						generateTree();
					}
					
					if(result == "FAILED") {
						layer.msg("操作失敗！"+response.message);
					}
				},
				"error":function(response){
					layer.msg(response.status+" "+response.statusText);
				}
			});
			
			// 關閉模態框
			$("#menuAddModal").modal("hide");
			
			// 清空表單
			// jQuery對象調用click()函數，裏面不傳任何參數，相當於用戶點擊了一下
			$("#menuResetBtn").click();
		});
		
		// 給編輯按鈕綁定單擊響應函數
		$("#treeDemo").on("click",".editBtn",function(){
			
			// 將當前節點的id保存到全局變量
			window.id = this.id;
			
			// 打開模態框
			$("#menuEditModal").modal("show");
		
			// 獲取zTreeObj對象
			var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");
			
			// 根據id屬性查詢節點對象
			// 用來搜索節點的屬性名
			var key = "id";
			
			// 用來搜索節點的屬性值
			var value = window.id;
			
			var currentNode = zTreeObj.getNodeByParam(key, value);
			
			// 回顯表單數據
			$("#menuEditModal [name=name]").val(currentNode.name);
			$("#menuEditModal [name=url]").val(currentNode.url);
			
			// 回顯radio可以這樣理解：被選中的radio的value屬性可以組成一個數組，
			// 然後再用這個數組設置回radio，就能夠把對應的值選中
			$("#menuEditModal [name=icon]").val([currentNode.icon]);
			
			return false;
		});
		
		// 給更新模態框中的更新按鈕綁定單擊響應函數
		$("#menuEditBtn").click(function(){
			
			// 收集表單數據
			var name = $("#menuEditModal [name=name]").val();
			var url = $("#menuEditModal [name=url]").val();
			var icon = $("#menuEditModal [name=icon]:checked").val();
			
			// 發送Ajax請求
			$.ajax({
				"url":"menu/update.json",
				"type":"post",
				"data":{
					"id": window.id,
					"name":name,
					"url":url,
					"icon":icon
				},
				"dataType":"json",
				"success":function(response){
					var result = response.result;
					
					if(result == "SUCCESS") {
						layer.msg("操作成功！");
						
						// 重新加載樹形結構，註意：要在確認服務器端完成保存操作後再刷新
						// 否則有可能刷新不到最新的數據，因為這裏是異步的
						generateTree();
					}
					
					if(result == "FAILED") {
						layer.msg("操作失敗！"+response.message);
					}
				},
				"error":function(response){
					layer.msg(response.status+" "+response.statusText);
				}
			});
			
			// 關閉模態框
			$("#menuEditModal").modal("hide");
			
		});
		
		// 給“×”按鈕綁定單擊響應函數
		$("#treeDemo").on("click",".removeBtn",function(){
			
			// 將當前節點的id保存到全局變量
			window.id = this.id;
			
			// 打開模態框
			$("#menuConfirmModal").modal("show");
		
			// 獲取zTreeObj對象
			var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");
			
			// 根據id屬性查詢節點對象
			// 用來搜索節點的屬性名
			var key = "id";
			
			// 用來搜索節點的屬性值
			var value = window.id;
			
			var currentNode = zTreeObj.getNodeByParam(key, value);
			
			$("#removeNodeSpan").html("【<i class='"+currentNode.icon+"'></i>"+currentNode.name+"】");
			
			return false;
		});
		
		// 給確認模態框中的OK按鈕綁定單擊響應函數
		$("#confirmBtn").click(function(){
			
			$.ajax({
				"url":"menu/remove.json",
				"type":"post",
				"data":{
					"id":window.id
				},
				"dataType":"json",
				"success":function(response){
					var result = response.result;
					
					if(result == "SUCCESS") {
						layer.msg("操作成功！");
						
						// 重新加載樹形結構，註意：要在確認服務器端完成保存操作後再刷新
						// 否則有可能刷新不到最新的數據，因為這裏是異步的
						generateTree();
					}
					
					if(result == "FAILED") {
						layer.msg("操作失敗！"+response.message);
					}
				},
				"error":function(response){
					layer.msg(response.status+" "+response.statusText);
				}
			});
			
			// 關閉模態框
			$("#menuConfirmModal").modal("hide");
		});
		
	});

</script>
<body>

	<%@ include file="/WEB-INF/include-nav.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/WEB-INF/include-sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="glyphicon glyphicon-th-list"></i> 權限菜單列表
						<div style="float: right; cursor: pointer;" data-toggle="modal"
							data-target="#myModal">
							<i class="glyphicon glyphicon-question-sign"></i>
						</div>
					</div>
					<div class="panel-body">
						<!-- 這個ul標簽是zTree動態生成的節點所依附的靜態節點 -->
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="/WEB-INF/modal-menu-add.jsp" %>
	<%@include file="/WEB-INF/modal-menu-confirm.jsp" %>
	<%@include file="/WEB-INF/modal-menu-edit.jsp" %>
</body>
</html>