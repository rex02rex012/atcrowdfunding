package com.atguigu.crowd.mvc.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.atguigu.crowd.constant.CrowdConstant;

// 表示當前類是一個配置類
@Configuration

// 啟用Web環境下權限控制功能
@EnableWebSecurity

// 啟用全局方法權限控制功能，並且設置prePostEnabled = true。保證@PreAuthority、@PostAuthority、@PreFilter、@PostFilter生效
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/*
	 * 
	在這裏聲明，無法在XxxService中裝配
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		
		// 臨時使用內存版登錄的模式測試代碼
		// builder.inMemoryAuthentication().withUser("tom").password("123123").roles("ADMIN");
		
		// 正式功能中使用基於數據庫的認證
		builder
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
		
	}
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		
		security
			.authorizeRequests()	// 對請求進行授權
			.antMatchers("/admin/to/login/page.html")	// 針對登錄頁進行設置
			.permitAll()			// 無條件訪問
			.antMatchers("/bootstrap/**")	// 針對靜態資源進行設置，無條件訪問
			.permitAll()                    // 針對靜態資源進行設置，無條件訪問
			.antMatchers("/crowd/**")       // 針對靜態資源進行設置，無條件訪問
			.permitAll()                    // 針對靜態資源進行設置，無條件訪問
			.antMatchers("/css/**")         // 針對靜態資源進行設置，無條件訪問
			.permitAll()                    // 針對靜態資源進行設置，無條件訪問
			.antMatchers("/fonts/**")       // 針對靜態資源進行設置，無條件訪問
			.permitAll()                    // 針對靜態資源進行設置，無條件訪問
			.antMatchers("/img/**")         // 針對靜態資源進行設置，無條件訪問
			.permitAll()                    // 針對靜態資源進行設置，無條件訪問
			.antMatchers("/jquery/**")      // 針對靜態資源進行設置，無條件訪問
			.permitAll()                    // 針對靜態資源進行設置，無條件訪問
			.antMatchers("/layer/**")       // 針對靜態資源進行設置，無條件訪問
			.permitAll()                    // 針對靜態資源進行設置，無條件訪問
			.antMatchers("/script/**")      // 針對靜態資源進行設置，無條件訪問
			.permitAll()                    // 針對靜態資源進行設置，無條件訪問
			.antMatchers("/ztree/**")       // 針對靜態資源進行設置，無條件訪問
			.permitAll()
			.antMatchers("/admin/get/page.html")	// 針對分頁顯示Admin數據設定訪問控制
			// .hasRole("經理")					// 要求具備經理角色
			.access("hasRole('經理') OR hasAuthority('user:get')")	// 要求具備“經理”角色和“user:get”權限二者之一
			.anyRequest()					// 其他任意請求
			.authenticated()				// 認證後訪問
			.and()
			.exceptionHandling()
			.accessDeniedHandler(new AccessDeniedHandler() {
				
				public void handle(HttpServletRequest request, HttpServletResponse response,
						AccessDeniedException accessDeniedException) throws IOException, ServletException {
					request.setAttribute("exception", new Exception(CrowdConstant.MESSAGE_ACCESS_DENIED));
					request.getRequestDispatcher("/WEB-INF/system-error.jsp").forward(request, response);
				}
			})
			.and()
			.csrf()							// 防跨站請求偽造功能
			.disable()						// 禁用
			.formLogin()					// 開啟表單登錄的功能
			.loginPage("/admin/to/login/page.html")	// 指定登錄頁面
			.loginProcessingUrl("/security/do/login.html")	// 指定處理登錄請求的地址
			.defaultSuccessUrl("/admin/to/main/page.html")	// 指定登錄成功後前往的地址
			.usernameParameter("loginAcct")	// 賬號的請求參數名稱
			.passwordParameter("userPswd")	// 密碼的請求參數名稱
			.and()
			.logout()						// 開啟退出登錄功能
			.logoutUrl("/seucrity/do/logout.html")			// 指定退出登錄地址
			.logoutSuccessUrl("/admin/to/login/page.html")	// 指定退出成功以後前往的地址
			;
		
	}

}
