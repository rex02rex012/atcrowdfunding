package com.atguigu.crowd.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.exception.AccessForbiddenException;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1.通過request 對象獲取Session 對象
		HttpSession session = request.getSession();
		// 2.嘗試從Session 域中獲取Admin 對象
		Admin admin = (Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);
		// 3.判斷admin 對象是否為空
		if (admin == null) {
			// 4.拋出異常
			throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDEN);
		}
		// 5.如果Admin 對象不為null，則返回true 放行
		return true;
	}
}