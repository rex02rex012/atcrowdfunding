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

// @ControllerAdvice表示當前類是一個基於註解的異常處理器類
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

	// 表示捕獲到Exception
	@ExceptionHandler(value = ArithmeticException.class)
	public ModelAndView resolveMathException(ArithmeticException exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String viewName = "system-error";

		return commonResolve(viewName, exception, request, response);
	}

	// 表示捕獲到Exception
	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView resolveNullPointerException(NullPointerException exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String viewName = "system-error";

		return commonResolve(viewName, exception, request, response);
	}

	// 表示捕獲到Exception 類型的異常對象由當前方法處理
	@ExceptionHandler(value = Exception.class)
	public ModelAndView resolveException(Exception exception, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 只是指定當前異常對應的頁面即可
		String viewName = "system-error";
		return commonResolve(viewName, exception, request, response);
	}

	/**
	 * 核心異常處理方法
	 * 
	 * @param exception SpringMVC 捕獲到的異常對象
	 * @param request   為了判斷當前請求是“普通請求”還是“Ajax 請求” 需要傳入原生request 對象
	 * @param response  為了能夠將JSON 字元串作為當前請求的響應數 據返回給瀏覽器
	 * @param viewName  指定要前往的視圖名稱
	 * @return ModelAndView
	 * @throws IOException
	 */
	// @ExceptionHandler將一個具體的異常類型和一個方法關聯起來
	private ModelAndView commonResolve(

			// 異常處理完成後要去的頁面
			String viewName,

			// 實際捕獲到的異常類型
			Exception exception,

			// 當前請求對象
			HttpServletRequest request,

			// 當前響應對象
			HttpServletResponse response) throws IOException {

		// 1.判斷當前請求類型
		boolean judgeResult = CrowdUtil.judgeRequestType(request);

		// 2.如果是Ajax請求
		if (judgeResult) {

			// 3.創建ResultEntity對象
			ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());

			// 4.創建Gson對象
			Gson gson = new Gson();

			// 5.將ResultEntity對象轉換為JSON字元串
			String json = gson.toJson(resultEntity);

			// 6.將JSON字元串作為響應體返回給瀏覽器
			response.getWriter().write(json);

			// 7.由於上面已經通過原生的response對象返回了響應，所以不提供ModelAndView對象
			return null;
		}

		// 8.如果不是Ajax請求則創建ModelAndView對象
		ModelAndView modelAndView = new ModelAndView();

		// 9.將Exception對象存入模型
		modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);

		// 10.設置對應的視圖名稱
		modelAndView.setViewName(viewName);

		// 11.返回modelAndView對象
		return modelAndView;
	}

}
