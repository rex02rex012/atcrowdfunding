package com.atguigu.crowd.mvc.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.ParamData;
import com.atguigu.crowd.entity.Student;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;

@Controller
public class TestHandler {
	
	
	@Autowired
	private AdminService adminService;
	
	@ResponseBody
	@RequestMapping("/test/ajax/async.html")
	public String testAsync() throws InterruptedException {
		
		Thread.sleep(5000);
		
		return "success";
	}
	
	
	@ResponseBody
	@RequestMapping("/send/array/one.html")
	public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {
		
		for (Integer number : array) {
			System.out.println("number="+number);
		}
		
		return "success";
	}

	@ResponseBody
	@RequestMapping("/send/array/two.html")
	public String testReceiveArrayTwo(ParamData paramData) {
		
		List<Integer> array = paramData.getArray();
		
		for (Integer number : array) {
			System.out.println("number="+number);
		}
		
		return "success";
	}

	

	private Logger logger = LoggerFactory.getLogger(TestHandler.class);

	
	@ResponseBody
	@RequestMapping("/send/array/three.html")
	public String testReceiveArrayThree(@RequestBody List<Integer> array) {
		
		for (Integer number : array) {
			logger.info("number="+number);
		}
		
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/send/compose/object.json")
	public ResultEntity<Student> testReceiveComposeObject(@RequestBody Student student, HttpServletRequest request) {

		boolean judgeResult = CrowdUtil.judgeRequestType(request);

		logger.info("judgeResult=" + judgeResult);//true，因為return一個json

		logger.info(student.toString());

		// 將“查詢”到的Student對象封裝到ResultEntity中返回
		ResultEntity<Student> resultEntity = ResultEntity.successWithData(student);

		String a = null;//測試nullpointException異常

		System.out.println(a.length());//當執行到這一行的時候，會產生nullpointException ，跳轉到

		return resultEntity;
	}

	


	@RequestMapping("/test/ssm.html")
	public String testSsm(ModelMap modelMap, HttpServletRequest request) {
		
		boolean judgeResult = CrowdUtil.judgeRequestType(request);
		
		logger.info("judgeResult="+judgeResult);//false，因為return一個頁面路徑
		
		List<Admin> adminList = adminService.getAll();
		
		modelMap.addAttribute("adminList", adminList);
		
		String a = null;//測試nullpointException異常
		
		System.out.println(a.length());//當執行到這一行的時候，會產生nullpointException ，跳轉到system-error.jsp頁面
		
		return "target";
	}

}