package com.atguigu.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.entity.RoleExample;
import com.atguigu.crowd.entity.RoleExample.Criteria;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.api.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	
	
	public List<Role> getAssignedRole(Integer adminId) {
		
		return roleMapper.selectAssignedRole(adminId);
	}

	public List<Role> getUnAssignedRole(Integer adminId) {
		return roleMapper.selectUnAssignedRole(adminId);
	}
	
	
	public void removeRole(List<Integer> roleIdList) {
		
		RoleExample example = new RoleExample();
		
		Criteria criteria = example.createCriteria();
		
		//delete from t_role where id in (5,8,12)
		criteria.andIdIn(roleIdList);
		
		roleMapper.deleteByExample(example);
	}
	
	public void updateRole(Role role) {
		roleMapper.updateByPrimaryKey(role);
	}
	
	
	public void saveRole(Role role) {
		roleMapper.insert(role);
	}
	

	public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {
		
		// 1.開啟分頁功能
		PageHelper.startPage(pageNum, pageSize);
		
		// 2.執行查詢
		List<Role> roleList = roleMapper.selectRoleByKeyword(keyword);
		
		// 3.封裝為PageInfo對象返回
		return new PageInfo<Role>(roleList);
	}







}
