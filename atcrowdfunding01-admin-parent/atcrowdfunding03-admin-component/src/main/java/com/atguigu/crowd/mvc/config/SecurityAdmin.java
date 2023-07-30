package com.atguigu.crowd.mvc.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.atguigu.crowd.entity.Admin;

/**
 * �Ҽ{��User��H���ȶȥ]�t�㸹�M�K�X�A���F���������l��Admin��H�A�M���Ыسo������User���i���X�i
 * @author Lenovo
 *
 */
public class SecurityAdmin extends User {
	
	private static final long serialVersionUID = 1L;
	
	// ��l��Admin��H�A�]�tAdmin��H�������ݩ�
	private Admin originalAdmin;
	
	public SecurityAdmin(
			// �ǤJ��l��Admin��H
			Admin originalAdmin, 
			
			// �Ыب���B�v���H�������X
			List<GrantedAuthority> authorities) {
		
		// �եΤ����c�y��
		super(originalAdmin.getLoginAcct(), originalAdmin.getUserPswd(), authorities);
		
		// ��������this.originalAdmin���
		this.originalAdmin = originalAdmin;
		
		// �N��lAdmin��H�����K�X����
		this.originalAdmin.setUserPswd(null);
		
	}
	
	// ��~���Ѫ������lAdmin��H��getXxx()��k
	public Admin getOriginalAdmin() {
		return originalAdmin;
	}

}
