package com.atguigu.crowd.mvc.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.exception.AccessForbiddenException;
import com.atguigu.crowd.exception.LoginAcctAlreadyInUseException;
import com.atguigu.crowd.exception.LoginAcctAlreadyInUseForUpdateException;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import com.google.gson.Gson;

// @ControllerAdvice��ܷ�e���O�@�Ӱ����Ѫ����`�B�z����
@ControllerAdvice
public class CrowdExceptionResolver {

	
	@ExceptionHandler(value = LoginAcctAlreadyInUseForUpdateException.class)
	public ModelAndView resolveLoginAcctAlreadyInUseForUpdateException(
			LoginAcctAlreadyInUseForUpdateException exception,
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {
		
		String viewName = "system-error";
		
		return commonResolve(viewName, exception, request, response);
	}
	
	
	@ExceptionHandler(value = LoginAcctAlreadyInUseException.class)
	public ModelAndView resolveLoginAcctAlreadyInUseException(LoginAcctAlreadyInUseException exception,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		String viewName = "admin-add";

		return commonResolve(viewName, exception, request, response);
	}

	@ExceptionHandler(value = AccessForbiddenException.class)
	public ModelAndView resolveAccessForbiddenException(AccessForbiddenException exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String viewName = "admin-login";
		return commonResolve(viewName, exception, request, response);
	}

	@ExceptionHandler(value = LoginFailedException.class)
	public ModelAndView resolveLoginFailedException(LoginFailedException exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String viewName = "admin-login";
		return commonResolve(viewName, exception, request, response);
	}

	// ��ܮ����Exception
	@ExceptionHandler(value = ArithmeticException.class)
	public ModelAndView resolveMathException(ArithmeticException exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String viewName = "system-error";

		return commonResolve(viewName, exception, request, response);
	}

	// ��ܮ����Exception
	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView resolveNullPointerException(NullPointerException exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String viewName = "system-error";

		return commonResolve(viewName, exception, request, response);
	}

	// ��ܮ����Exception ���������`��H�ѷ�e��k�B�z
	@ExceptionHandler(value = Exception.class)
	public ModelAndView resolveException(Exception exception, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// �u�O���w��e���`�����������Y�i
		String viewName = "system-error";
		return commonResolve(viewName, exception, request, response);
	}

	/**
	 * �֤߲��`�B�z��k
	 * 
	 * @param exception SpringMVC ����쪺���`��H
	 * @param request   ���F�P�_��e�ШD�O�����q�ШD���٬O��Ajax �ШD�� �ݭn�ǤJ���request ��H
	 * @param response  ���F����NJSON �r����@����e�ШD���T���� �ڪ�^���s����
	 * @param viewName  ���w�n�e�������ϦW��
	 * @return ModelAndView
	 * @throws IOException
	 */
	// @ExceptionHandler�N�@�Ө��骺���`�����M�@�Ӥ�k���p�_��
	private ModelAndView commonResolve(

			// ���`�B�z������n�h������
			String viewName,

			// ��ڮ���쪺���`����
			Exception exception,

			// ��e�ШD��H
			HttpServletRequest request,

			// ��e�T����H
			HttpServletResponse response) throws IOException {

		// 1.�P�_��e�ШD����
		boolean judgeResult = CrowdUtil.judgeRequestType(request);

		// 2.�p�G�OAjax�ШD
		if (judgeResult) {

			// 3.�Ы�ResultEntity��H
			ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());

			// 4.�Ы�Gson��H
			Gson gson = new Gson();

			// 5.�NResultEntity��H�ഫ��JSON�r����
			String json = gson.toJson(resultEntity);

			// 6.�NJSON�r����@���T�����^���s����
			response.getWriter().write(json);

			// 7.�ѩ�W���w�g�q�L��ͪ�response��H��^�F�T���A�ҥH������ModelAndView��H
			return null;
		}

		// 8.�p�G���OAjax�ШD�h�Ы�ModelAndView��H
		ModelAndView modelAndView = new ModelAndView();

		// 9.�NException��H�s�J�ҫ�
		modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);

		// 10.�]�m���������ϦW��
		modelAndView.setViewName(viewName);

		// 11.��^modelAndView��H
		return modelAndView;
	}

}
