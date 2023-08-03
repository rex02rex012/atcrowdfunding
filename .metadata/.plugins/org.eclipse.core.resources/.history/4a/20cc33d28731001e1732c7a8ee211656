package com.atguigu.crowd.mvc.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import com.github.pagehelper.PageInfo;

@Controller
public class AdminHandler {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin/to/edit/page.html")
	public String toEditPage(@RequestParam("adminId") Integer adminId, ModelMap modelMap) {

		// 1.根據adminId查詢Admin對象
		Admin admin = adminService.getAdminById(adminId);

		// 2.將Admin對象存入模型
		modelMap.addAttribute("admin", admin);

		return "admin-edit";
	}

	@RequestMapping("/admin/update.html")
	public String update(Admin admin, @RequestParam("pageNum") Integer pageNum,
			@RequestParam("keyword") String keyword) {

		adminService.update(admin);

		return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
	}

	
	
	
	@RequestMapping("/save/admin.html")
	public String saveAdmin(Admin admin) {
		// 執行保存
		adminService.saveAdmin(admin);
		// 重定向到分頁頁面，使用重定向是為了避免刷新瀏覽器重覆提交表單
		return "redirect:/admin/page.html?pageNum=" + Integer.MAX_VALUE;
	}

	@RequestMapping("/admin/remove/{adminId}/{pageNum}/{keyword}.html")
	public String remove(@PathVariable("adminId") Integer adminId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {

		// 執行刪除
		adminService.remove(adminId);

		// 頁面跳轉：回到分頁頁面

		// 嘗試方案1：直接轉發到admin-page.jsp會無法顯示分頁數據
		// return "admin-page";

		// 嘗試方案2：轉發到/admin/get/page.html地址，一旦刷新頁面會重覆執行刪除浪費性能
		// return "forward:/admin/get/page.html";

		// 嘗試方案3：重定向到/admin/get/page.html地址
		// 同時為了保持原本所在的頁面和查詢關鍵詞再附加pageNum和keyword兩個請求參數
		return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
	}


	@RequestMapping("/admin/save.html")
	public String save(Admin admin) {

		adminService.saveAdmin(admin);

		return "redirect:/admin/get/page.html?pageNum=" + Integer.MAX_VALUE;
	}

	@RequestMapping("/admin/get/page.html")
	public String getPageInfo(

			// 使用@RequestParam註解的defaultValue屬性，指定默認值，在請求中沒有攜帶對應參數時使用默認值
			// keyword默認值使用空字符串，和SQL語句配合實現兩種情況適配
			@RequestParam(value = "keyword", defaultValue = "") String keyword,

			// pageNum默認值使用1
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,

			// pageSize默認值使用5
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,

			ModelMap modelMap

	) {

		// 調用Service方法獲取PageInfo對象
		PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);

		// 將PageInfo對象存入模型
		modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);

		return "admin-page";
	}

	@RequestMapping("/admin/do/logout.html")
	public String doLogout(HttpSession session) {
		// 強制Session 失效
		session.invalidate();
		return "redirect:/admin/to/login/page.html";
	}

	@RequestMapping("/admin/do/login.html")
	public String doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("userPswd") String userPswd,
			HttpSession session) {
		// 調用Service 方法執行登錄檢查
		// 這個方法如果能夠返回admin 對象說明登錄成功，如果賬號、密碼不正確則會拋出異常
		Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);
		// 將登錄成功返回的admin 對象存入Session 域
		session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);
		return "redirect:/admin/to/main/page.html";
	}
}
