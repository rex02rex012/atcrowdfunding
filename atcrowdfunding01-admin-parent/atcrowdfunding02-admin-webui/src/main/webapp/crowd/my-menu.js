// 生成樹形結構的函數
function generateTree() {
	// 1.準備生成樹形結構的JSON數據，數據的來源是發送Ajax請求得到
	$.ajax({
		"url": "menu/get/whole/tree.json",
		"type":"post",
		"dataType":"json",
		"success":function(response){
			var result = response.result;
			if(result == "SUCCESS") {
				
				// 2.創建JSON對象用於存儲對zTree所做的設置
				var setting = {
					"view": {
						"addDiyDom": myAddDiyDom,
						"addHoverDom": myAddHoverDom,
						"removeHoverDom": myRemoveHoverDom
					},
					"data": {
						"key": {
							"url": "maomi"
						}
					}
				};
				
				// 3.從響應體中獲取用來生成樹形結構的JSON數據
				var zNodes = response.data;
				
				// 4.初始化樹形結構
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			}
			
			if(result == "FAILED") {
				layer.msg(response.message);
			}
		}
	});
}

// 在鼠標離開節點範圍時刪除按鈕組
function myRemoveHoverDom(treeId, treeNode) {
	
	// 拼接按鈕組的id
	var btnGroupId = treeNode.tId + "_btnGrp";
	
	// 移除對應的元素
	$("#"+btnGroupId).remove();
	
}

// 在鼠標移入節點範圍時添加按鈕組
function myAddHoverDom(treeId, treeNode) {
	
	// 按鈕組的標簽結構：<span><a><i></i></a><a><i></i></a></span>
	// 按鈕組出現的位置：節點中treeDemo_n_a超鏈接的後面
	
	// 為了在需要移除按鈕組的時候能夠精確定位到按鈕組所在span，需要給span設置有規律的id
	var btnGroupId = treeNode.tId + "_btnGrp";

	// 判斷一下以前是否已經添加了按鈕組
	if($("#"+btnGroupId).length > 0) {
		return ;
	}
	
	// 準備各個按鈕的HTML標簽
	var addBtn = "<a id='"+treeNode.id+"' class='addBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px;padding-top:0px;' href='#' title='添加子節點'>&nbsp;&nbsp;<i class='fa fa-fw fa-plus rbg '></i></a>";
	var removeBtn = "<a id='"+treeNode.id+"' class='removeBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px;padding-top:0px;' href='#' title='刪除節點'>&nbsp;&nbsp;<i class='fa fa-fw fa-times rbg '></i></a>";
	var editBtn = "<a id='"+treeNode.id+"' class='editBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px;padding-top:0px;' href='#' title='修改節點'>&nbsp;&nbsp;<i class='fa fa-fw fa-edit rbg '></i></a>";
	
	// 獲取當前節點的級別數據
	var level = treeNode.level;
	
	// 聲明變量存儲拼裝好的按鈕代碼
	var btnHTML = "";
	
	// 判斷當前節點的級別
	if(level == 0) {
		// 級別為0時是根節點，只能添加子節點
		btnHTML = addBtn;
	}
	
	if(level == 1) {
		// 級別為1時是分支節點，可以添加子節點、修改
		btnHTML = addBtn + " " + editBtn;
		
		// 獲取當前節點的子節點數量
		var length = treeNode.children.length;
		
		// 如果沒有子節點，可以刪除
		if(length == 0) {
			btnHTML = btnHTML + " " + removeBtn;
		}
		
	}
	
	if(level == 2) {
		// 級別為2時是葉子節點，可以修改、刪除
		btnHTML = editBtn + " " + removeBtn;
	}
	
	// 找到附著按鈕組的超鏈接
	var anchorId = treeNode.tId + "_a";
	
	// 執行在超鏈接後面附加span元素的操作
	$("#"+anchorId).after("<span id='"+btnGroupId+"'>"+btnHTML+"</span>");
	
}

// 修改默認的圖標
function myAddDiyDom(treeId, treeNode) {
	
	// treeId是整個樹形結構附著的ul標簽的id
	console.log("treeId="+treeId);
	
	// 當前樹形節點的全部的數據，包括從後端查詢得到的Menu對象的全部屬性
	console.log(treeNode);
	
	// zTree生成id的規則
	// 例子：treeDemo_7_ico
	// 解析：ul標簽的id_當前節點的序號_功能
	// 提示：“ul標簽的id_當前節點的序號”部分可以通過訪問treeNode的tId屬性得到
	// 根據id的生成規則拼接出來span標簽的id
	var spanId = treeNode.tId + "_ico";
	
	// 根據控制圖標的span標簽的id找到這個span標簽
	// 刪除舊的class
	// 添加新的class
	$("#"+spanId)
		.removeClass()
		.addClass(treeNode.icon);
	
}