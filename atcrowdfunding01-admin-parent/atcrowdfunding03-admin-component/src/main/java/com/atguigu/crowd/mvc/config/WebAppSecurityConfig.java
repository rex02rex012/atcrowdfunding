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

// ��ܷ�e���O�@�Ӱt�m��
@Configuration

// �ҥ�Web���ҤU�v������\��
@EnableWebSecurity

// �ҥΥ�����k�v������\��A�åB�]�mprePostEnabled = true�C�O��@PreAuthority�B@PostAuthority�B@PreFilter�B@PostFilter�ͮ�
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/*
	 * 
	�b�o���n���A�L�k�bXxxService���˰t
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		
		// �{�ɨϥΤ��s���n�����Ҧ����եN�X
		// builder.inMemoryAuthentication().withUser("tom").password("123123").roles("ADMIN");
		
		// �����\�त�ϥΰ��ƾڮw���{��
		builder
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
		
	}
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		
		security
			.authorizeRequests()	// ��ШD�i����v
			.antMatchers("/admin/to/login/page.html")	// �w��n�����i��]�m
			.permitAll()			// �L����X��
			.antMatchers("/bootstrap/**")	// �w���R�A�귽�i��]�m�A�L����X��
			.permitAll()                    // �w���R�A�귽�i��]�m�A�L����X��
			.antMatchers("/crowd/**")       // �w���R�A�귽�i��]�m�A�L����X��
			.permitAll()                    // �w���R�A�귽�i��]�m�A�L����X��
			.antMatchers("/css/**")         // �w���R�A�귽�i��]�m�A�L����X��
			.permitAll()                    // �w���R�A�귽�i��]�m�A�L����X��
			.antMatchers("/fonts/**")       // �w���R�A�귽�i��]�m�A�L����X��
			.permitAll()                    // �w���R�A�귽�i��]�m�A�L����X��
			.antMatchers("/img/**")         // �w���R�A�귽�i��]�m�A�L����X��
			.permitAll()                    // �w���R�A�귽�i��]�m�A�L����X��
			.antMatchers("/jquery/**")      // �w���R�A�귽�i��]�m�A�L����X��
			.permitAll()                    // �w���R�A�귽�i��]�m�A�L����X��
			.antMatchers("/layer/**")       // �w���R�A�귽�i��]�m�A�L����X��
			.permitAll()                    // �w���R�A�귽�i��]�m�A�L����X��
			.antMatchers("/script/**")      // �w���R�A�귽�i��]�m�A�L����X��
			.permitAll()                    // �w���R�A�귽�i��]�m�A�L����X��
			.antMatchers("/ztree/**")       // �w���R�A�귽�i��]�m�A�L����X��
			.permitAll()
			.antMatchers("/admin/get/page.html")	// �w��������Admin�ƾڳ]�w�X�ݱ���
			// .hasRole("�g�z")					// �n�D��Ƹg�z����
			.access("hasRole('�g�z') OR hasAuthority('user:get')")	// �n�D��ơ��g�z������M��user:get���v���G�̤��@
			.anyRequest()					// ��L���N�ШD
			.authenticated()				// �{�ҫ�X��
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
			.csrf()							// ���󯸽ШD���y�\��
			.disable()						// �T��
			.formLogin()					// �}�Ҫ��n�����\��
			.loginPage("/admin/to/login/page.html")	// ���w�n������
			.loginProcessingUrl("/security/do/login.html")	// ���w�B�z�n���ШD���a�}
			.defaultSuccessUrl("/admin/to/main/page.html")	// ���w�n�����\��e�����a�}
			.usernameParameter("loginAcct")	// �㸹���ШD�ѼƦW��
			.passwordParameter("userPswd")	// �K�X���ШD�ѼƦW��
			.and()
			.logout()						// �}�Ұh�X�n���\��
			.logoutUrl("/seucrity/do/logout.html")			// ���w�h�X�n���a�}
			.logoutSuccessUrl("/admin/to/login/page.html")	// ���w�h�X���\�H��e�����a�}
			;
		
	}

}
