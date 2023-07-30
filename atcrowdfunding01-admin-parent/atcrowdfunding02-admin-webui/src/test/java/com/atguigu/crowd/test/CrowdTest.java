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

// 指定Spring 給Junit 提供的運行器類
@RunWith(SpringJUnit4ClassRunner.class)
// 加載Spring 配置文件的註解
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
		Admin admin = new Admin(null, "jerry", "123456", "傑瑞", "jerry@qq.com", null);
		adminService.saveAdmin(admin);
	}
	
	
	@Test
	public void testLog() {
		
		// 1.獲取Logger對象，這裡傳入的Class對象就是當前打印日誌的類
		Logger logger = LoggerFactory.getLogger(CrowdTest.class); //使用方法
		
		// 2.根據不同日誌級別打印日誌
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
		Admin admin = new Admin(null, "tom", "123123", "湯姆", "tom@qq.com", null);
		int count = adminMapper.insert(admin);//會返回受影響的行數
		

		adminMapper.insert(admin); //insertSelective()各個字段有值的才會保存到insert語句當中

		// 如果在實際開發中，所有想查看數值的地方都使用sysout方式打印，會給項目上線運行帶來問題！
		// sysout本質上是一個IO操作，通常IO的操作是比較消耗性能的。如果項目中sysout很多，那麼對性能的影響就比較大了。
		// 即使上線前專門花時間刪除代碼中的sysout，也很可能有遺漏，而且非常麻煩。
		// 而如果使用日誌系統，那麼通過日誌級別就可以批量的控制信息的打印。
		System.out.println("受影響的行數="+count);
	}
	
	
	
	@Test
	public void testDataSource() throws SQLException {
            // 1.通過數據源對象獲取數據源連接
		Connection connection = dataSource.getConnection();
            // 2.打印數據庫連接
		System.out.println(connection);

//		System.out.println("connection");
	}
}
