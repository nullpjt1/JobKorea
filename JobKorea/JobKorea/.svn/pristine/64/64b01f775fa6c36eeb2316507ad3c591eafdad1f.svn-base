package kr.kosmo.jobkorea.join.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kosmo.jobkorea.join.service.JoinService;

@Controller
@RequestMapping("/join/")
public class joinController {
	
	@Autowired
	JoinService joinService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	
	/** 회원가입 창(작성화면) **/
	
	@RequestMapping("/JoinPopup.do")
	public String JoinPopup(Model model, HttpServletRequest request) {
		

		return "JoinPopup";
	}
		
	/*회원가입 폼 저장*/
	@RequestMapping("/joinSave.do")
	//@ResponseBody
	public Map<String, String> joinSave(Model model, Map<String, String> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session)  throws Exception {
		
		logger.info("+ Start " + className + ".joinSave");
		logger.info("   - paramMap : " + paramMap);
		
		String action=(String)paramMap.get("action");
		String result ="Success!";
		String resultMsg = "저장 되었습니다!";
		
		if("I".equals(action)) {
			joinService.insertjoin(paramMap);
		}
		else {
			result ="FALSE";
			resultMsg ="알수없어요~";
		}
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".joinSave");
		

		return resultMap;
	}
	
	
			


}
