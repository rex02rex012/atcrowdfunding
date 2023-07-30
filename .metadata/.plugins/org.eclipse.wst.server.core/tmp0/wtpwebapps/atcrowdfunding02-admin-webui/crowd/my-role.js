// 聲明專門的函數顯示確認模態框
function showConfirmModal(roleArray) {
	
	// 打開模態框
	$("#confirmModal").modal("show");
	
	// 清除舊的數據
	$("#roleNameDiv").empty();
	
	// 在全局變量範圍創建數組用來存放角色id
	window.roleIdArray = [];
	
	// 遍歷roleArray數組
	for(var i = 0; i < roleArray.length; i++) {
		var role = roleArray[i];
		var roleName = role.roleName;
		$("#roleNameDiv").append(roleName+"<br/>");
		
		var roleId = role.roleId;
		
		// 調用數組對象的push()方法存入新元素
		window.roleIdArray.push(roleId);
	}
	
}

// 執行分頁，生成頁面效果，任何時候調用這個函數都會重新加載頁面
function generatePage() {
	
	// 1.獲取分頁數據
	var pageInfo = getPageInfoRemote();
	
	// 2.填充表格
	fillTableBody(pageInfo);
	
}

// 遠程訪問服務器端程序獲取pageInfo數據
function getPageInfoRemote() {
	
	// 調用$.ajax()函數發送請求並接受$.ajax()函數的返回值
	var ajaxResult = $.ajax({
		"url": "role/get/page/info.json",
		"type":"post",
		"data": {
			"pageNum": window.pageNum,
			"pageSize": window.pageSize,
			"keyword": window.keyword
		},
		"async":false,
		"dataType":"json"
	});
	
	console.log(ajaxResult);
	
	// 判斷當前響應狀態碼是否為200
	var statusCode = ajaxResult.status;
	
	// 如果當前響應狀態碼不是200，說明發生了錯誤或其他意外情況，顯示提示消息，讓當前函數停止執行
	if(statusCode != 200) {
		layer.msg("失敗！響應狀態碼="+statusCode+" 說明信息="+ajaxResult.statusText);
		return null;
	}
	
	// 如果響應狀態碼是200，說明請求處理成功，獲取pageInfo
	var resultEntity = ajaxResult.responseJSON;
	
	// 從resultEntity中獲取result屬性
	var result = resultEntity.result;
	
	// 判斷result是否成功
	if(result == "FAILED") {
		layer.msg(resultEntity.message);
		return null;
	}
	
	// 確認result為成功後獲取pageInfo
	var pageInfo = resultEntity.data;
	
	// 返回pageInfo
	return pageInfo;
}

// 填充表格
function fillTableBody(pageInfo) {
	
	// 清除tbody中的舊的內容
	$("#rolePageBody").empty();
	
	// 這裏清空是為了讓沒有搜索結果時不顯示頁碼導航條
	$("#Pagination").empty();
	
	// 判斷pageInfo對象是否有效
	if(pageInfo == null || pageInfo == undefined || pageInfo.list == null || pageInfo.list.length == 0) {
		$("#rolePageBody").append("<tr><td colspan='4' align='center'>抱歉！沒有查詢到您搜索的數據！</td></tr>");
		
		return ;
	}
	
	// 使用pageInfo的list屬性填充tbody
	for(var i = 0; i < pageInfo.list.length; i++) {
		
		var role = pageInfo.list[i];
		
		var roleId = role.id;
		
		var roleName = role.name;
		
		var numberTd = "<td>"+(i+1)+"</td>";
		var checkboxTd = "<td><input id='"+roleId+"' class='itemBox' type='checkbox'></td>";
		var roleNameTd = "<td>"+roleName+"</td>";
		
		var checkBtn = "<button type='button' class='btn btn-success btn-xs'><i class=' glyphicon glyphicon-check'></i></button>";
		
		// 通過button標簽的id屬性（別的屬性其實也可以）把roleId值傳遞到button按鈕的單擊響應函數中，在單擊響應函數中使用this.id
		var pencilBtn = "<button id='"+roleId+"' type='button' class='btn btn-primary btn-xs pencilBtn'><i class=' glyphicon glyphicon-pencil'></i></button>";
		
		// 通過button標簽的id屬性（別的屬性其實也可以）把roleId值傳遞到button按鈕的單擊響應函數中，在單擊響應函數中使用this.id
		var removeBtn = "<button id='"+roleId+"' type='button' class='btn btn-danger btn-xs removeBtn'><i class=' glyphicon glyphicon-remove'></i></button>";
		
		var buttonTd = "<td>"+checkBtn+" "+pencilBtn+" "+removeBtn+"</td>";
		
		var tr = "<tr>"+numberTd+checkboxTd+roleNameTd+buttonTd+"</tr>";
		
		$("#rolePageBody").append(tr);
	}
	
	// 生成分頁導航條
	generateNavigator(pageInfo);
}

// 生成分頁頁碼導航條
function generateNavigator(pageInfo) {
	
	// 獲取總記錄數
	var totalRecord = pageInfo.total;
	
	// 聲明相關屬性
	var properties = {
		"num_edge_entries": 3,
		"num_display_entries": 5,
		"callback": paginationCallBack,
		"items_per_page": pageInfo.pageSize,
		"current_page": pageInfo.pageNum - 1,
		"prev_text": "上一頁",
		"next_text": "下一頁"
	}
	
	// 調用pagination()函數
	$("#Pagination").pagination(totalRecord, properties);
}

// 翻頁時的回調函數
function paginationCallBack(pageIndex, jQuery) {
	
	// 修改window對象的pageNum屬性
	window.pageNum = pageIndex + 1;
	
	// 調用分頁函數
	generatePage();
	
	// 取消頁碼超鏈接的默認行為
	return false;
	
}