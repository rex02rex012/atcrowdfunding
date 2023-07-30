package com.atguigu.crowd.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.api.AdminService;

// ���wSpring ��Junit ���Ѫ��B�澹��
@RunWith(SpringJUnit4ClassRunner.class)
// �[��Spring �t�m��󪺵���
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class CrowdTest {

	@Autowired
	private DataSource dataSource;

	
	
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private AdminService adminService;
	

	@Autowired
	private RoleMapper roleMapper;
	
	@Test
	public void testRoleSave() {
		for(int i = 0; i < 235; i++) {
			roleMapper.insert(new Role(null, "role"+i));
		}
	}
	
	@Test
	public void test() {
		for(int i = 0; i < 238; i++) {
			adminMapper.insert(new Admin(null, "loginAcct"+i, "userPswd"+i, "userName"+i, "email"+i, null));
		}
	}
	
	
	@Test
	public void testTx() {
		Admin admin = new Admin(null, "jerry", "123456", "�Ƿ�", "jerry@qq.com", null);
		adminService.saveAdmin(admin);
	}
	
	
	@Test
	public void testLog() {
		
		// 1.���Logger��H�A�o�̶ǤJ��Class��H�N�O��e���L��x����
		Logger logger = LoggerFactory.getLogger(CrowdTest.class); //�ϥΤ�k
		
		// 2.�ھڤ��P��x�ŧO���L��x
		logger.debug("Hello I am Debug level!!!");
		logger.debug("Hello I am Debug level!!!");
		logger.debug("Hello I am Debug level!!!");
		
		logger.info("Info level!!!");
		logger.info("Info level!!!");
		logger.info("Info level!!!");
		
		logger.warn("Warn level!!!");
		logger.warn("Warn level!!!");
		logger.warn("Warn level!!!");
		
		logger.error("Error level!!!");
		logger.error("Error level!!!");
		logger.error("Error level!!!");
	}
	
	
	@Test
	public void testInsertAdmin() {
		Admin admin = new Admin(null, "tom", "123123", "���i", "tom@qq.com", null);
		int count = adminMapper.insert(admin);//�|��^���v�T�����
		

		adminMapper.insert(admin); //insertSelective()�U�Ӧr�q���Ȫ��~�|�O�s��insert�y�y��

		// �p�G�b��ڶ}�o���A�Ҧ��Q�d�ݼƭȪ��a�賣�ϥ�sysout�覡���L�A�|�����ؤW�u�B��a�Ӱ��D�I
		// sysout����W�O�@��IO�ާ@�A�q�`IO���ާ@�O������өʯ઺�C�p�G���ؤ�sysout�ܦh�A�����ʯ઺�v�T�N����j�F�C
		// �Y�ϤW�u�e�M����ɶ��R���N�X����sysout�A�]�ܥi�঳��|�A�ӥB�D�`�·СC
		// �Ӧp�G�ϥΤ�x�t�ΡA����q�L��x�ŧO�N�i�H��q������H�������L�C
		System.out.println("���v�T�����="+count);
	}
	
	
	
	@Test
	public void testDataSource() throws SQLException {
            // 1.�q�L�ƾڷ���H����ƾڷ��s��
		Connection connection = dataSource.getConnection();
            // 2.���L�ƾڮw�s��
		System.out.println(connection);

//		System.out.println("connection");
	}
}
