package com.atguigu.crowd.mvc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.service.api.AuthService;
import com.atguigu.crowd.service.api.RoleService;

@Component
public class CrowdUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthService authService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 1.�ھڽ㸹�W�٬d��Admin��H
		Admin admin = adminService.getAdminByLoginAcct(username);
		
		// 2.���adminId
		Integer adminId = admin.getId();
		
		// 3.�ھ�adminId�d�ߨ���H��
		List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
		
		// 4.�ھ�adminId�d���v���H��
		List<String> authNameList = authService.getAssignedAuthNameByAdminId(adminId);
		
		// 5.�Ыض��X��H�ΨӦs�xGrantedAuthority
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		// 6.�M��assignedRoleList�s�J����H��
		for (Role role : assignedRoleList) {
			
			// ���N�G���n�ѤF�[�e��I
			String roleName = "ROLE_" + role.getName();
			
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);
			
			authorities.add(simpleGrantedAuthority);
		}
		
		// 7.�M��authNameList�s�J�v���H��
		for (String authName : authNameList) {
			
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authName);
			
			authorities.add(simpleGrantedAuthority);
		}
		
		// 8.�ʸ�SecurityAdmin��H
		SecurityAdmin securityAdmin = new SecurityAdmin(admin, authorities);
		
		return securityAdmin;
	}

}