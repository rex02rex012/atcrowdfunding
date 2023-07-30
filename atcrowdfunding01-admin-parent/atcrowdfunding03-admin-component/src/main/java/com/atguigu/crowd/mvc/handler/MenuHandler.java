package com.atguigu.crowd.mvc.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.service.api.MenuService;
import com.atguigu.crowd.util.ResultEntity;

@Controller
public class MenuHandler {
	
	@Autowired
	private MenuService menuService;
	
	@ResponseBody
	@RequestMapping("/menu/remove.json")
	public ResultEntity<String> removeMenu(@RequestParam("id") Integer id) {
		
		menuService.removeMenu(id);
		
		return ResultEntity.successWithoutData();
	}
	
	
	
	@ResponseBody
	@RequestMapping("/menu/update.json")
	public ResultEntity<String> updateMenu(Menu menu) {
		
		menuService.updateMenu(menu);
		
		return ResultEntity.successWithoutData();
	}
	
	
	@ResponseBody
	@RequestMapping("/menu/save.json")
	public ResultEntity<String> saveMenu(Menu menu) {
		
		// Thread.sleep(2000);
		
		menuService.saveMenu(menu);
		
		return ResultEntity.successWithoutData();
	}
	
	
	

	

	

	@ResponseBody
	@RequestMapping("/menu/get/whole/tree.json")
	public ResultEntity<Menu> getWholeTreeNew() {
		
		// 1.查詢全部的Menu對象
		List<Menu> menuList = menuService.getAll();
	
		// 2.聲明一個變量用來存儲找到的根節點
		Menu root = null;
		
		// 3.創建Map對象用來存儲id和Menu對象的對應關系便於查找父節點
		Map<Integer, Menu> menuMap = new HashMap<Integer, Menu>();
		
		// 4.遍歷menuList填充menuMap
		for (Menu menu : menuList) {
			
			Integer id = menu.getId();
			
			menuMap.put(id, menu);
		}
		
		// 5.再次遍歷menuList查找根節點、組裝父子節點
		for (Menu menu : menuList) {
			
			// 6.獲取當前menu對象的pid屬性值
			Integer pid = menu.getPid();
			
			// 7.如果pid為null，判定為根節點
			if(pid == null) {
				root = menu;
				
				// 8.如果當前節點是根節點，那麽肯定沒有父節點，不必繼續執行
				continue ;
			}
			
			// 9.如果pid不為null，說明當前節點有父節點，那麽可以根據pid到menuMap中查找對應的Menu對象
			Menu father = menuMap.get(pid);
			
			// 10.將當前節點存入父節點的children集合
			father.getChildren().add(menu);
		}
		
		// 11.經過上面的運算，根節點包含了整個樹形結構，返回根節點就是返回整個樹
		return ResultEntity.successWithData(root);
	}
	
	public ResultEntity<Menu> getWholeTreeOld() {
		
		// 1.查詢全部的Menu對象
		List<Menu> menuList = menuService.getAll();
		
		// 2.聲明一個變量用來存儲找到的根節點
		Menu root = null;
		
		// 3.遍歷menuList
		for (Menu menu : menuList) {
			
			// 4.獲取當前menu對象的pid屬性值
			Integer pid = menu.getPid();
			
			// 5.檢查pid是否為null
			if(pid == null) {
				
				// 6.把當前正在遍歷的這個menu對象賦值給root
				root = menu;
				
				// 7.停止本次循環，繼續執行下一次循環
				continue ;
			}
			
			// 8.如果pid不為null，說明當前節點有父節點，找到父節點就可以進行組裝，建立父子關系
			for (Menu maybeFather : menuList) {
				
				// 9.獲取maybeFather的id屬性
				Integer id = maybeFather.getId();
				
				// 10.將子節點的pid和疑似父節點的id進行比較
				if(Objects.equals(pid, id)) {
					
					// 11.將子節點存入父節點的children集合
					maybeFather.getChildren().add(menu);
					
					// 12.找到即可停止運行循環
					break ;
				}
				
			}
		}
		
		// 13.將組裝的樹形結構（也就是根節點對象）返回給瀏覽器
		return ResultEntity.successWithData(root);
	}

}
