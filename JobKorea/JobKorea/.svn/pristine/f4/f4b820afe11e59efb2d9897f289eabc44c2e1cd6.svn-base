package kr.kosmo.jobkorea.office.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kosmo.jobkorea.office.dto.OfficeMemberDTO;
import kr.kosmo.jobkorea.system.service.ComnCodService;


@Controller
@RequestMapping("/office/")
public class OfficeController {
	
	
	
	
	@Autowired
	ComnCodService comnCodService;
	
	// Set logger
	private final org.apache.log4j.Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();	
		
	@RequestMapping("officejoin.do")	
	public String officejoin(Local locale, Model model) throws Exception{
		
		
		return "/office/officejoin";
	}
	

	
	@RequestMapping("saveComnGrpCod.do")
	public String saveComnGrpCod(@RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		System.out.println(paramMap+"map값");
		logger.info("+ Start OfficeController.saveComnGrpCod.do");
		logger.info("   - paramMap : " + paramMap);
		
		String action = (String)paramMap.get("action");
		String result = "SUCCESS";
		String resultMsg = "가입 되었습니다.";
		
		// 사용자 정보 설정
		paramMap.put("OfficeId", session.getAttribute("OfficeId"));
		
		if ("I".equals(action)) {
			//  신규 저장
			int n= comnCodService.insertComnGrpCod(paramMap);
		} else if("U".equals(action)) {
			// 수정 저장
			int m =comnCodService.updateComnGrpCod(paramMap);
		} else {
			result = "FALSE";
			resultMsg = "알수 없는 요청 입니다.";
		}
		
		Map<Object, Object> resultMap = new HashMap<Object, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End OfficeController.saveComnGrpCod");
		
		return "/login/login";
	}
	
	
	
	

}
