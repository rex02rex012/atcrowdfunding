package com.atguigu.crowd.mvc.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.atguigu.crowd.entity.Admin;

/**
 * 考慮到User對象中僅僅包含賬號和密碼，為了能夠獲取到原始的Admin對象，專門創建這個類對User類進行擴展
 * @author Lenovo
 *
 */
public class SecurityAdmin extends User {
	
	private static final long serialVersionUID = 1L;
	
	// 原始的Admin對象，包含Admin對象的全部屬性
	private Admin originalAdmin;
	
	public SecurityAdmin(
			// 傳入原始的Admin對象
			Admin originalAdmin, 
			
			// 創建角色、權限信息的集合
			List<GrantedAuthority> authorities) {
		
		// 調用父類構造器
		super(originalAdmin.getLoginAcct(), originalAdmin.getUserPswd(), authorities);
		
		// 給本類的this.originalAdmin賦值
		this.originalAdmin = originalAdmin;
		
		// 將原始Admin對象中的密碼擦除
		this.originalAdmin.setUserPswd(null);
		
	}
	
	// 對外提供的獲取原始Admin對象的getXxx()方法
	public Admin getOriginalAdmin() {
		return originalAdmin;
	}

}
