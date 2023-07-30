package com.atguigu.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.entity.MenuExample;
import com.atguigu.crowd.mapper.MenuMapper;
import com.atguigu.crowd.service.api.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	public void removeMenu(Integer id) {
		menuMapper.deleteByPrimaryKey(id);
	}
	
	
	public void updateMenu(Menu menu) {
		
		// �ѩ�pid�S���ǤJ�A�@�w�n�ϥΦ���ܪ���s�A�O�ҡ�pid���r�q���|�Q�m��
		menuMapper.updateByPrimaryKeySelective(menu);
	}
	
	public List<Menu> getAll() {
		return menuMapper.selectByExample(new MenuExample());
	}

	public void saveMenu(Menu menu) {
		menuMapper.insert(menu);
	}





}
