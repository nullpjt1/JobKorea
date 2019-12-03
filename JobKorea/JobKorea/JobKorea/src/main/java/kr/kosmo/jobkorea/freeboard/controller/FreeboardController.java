package kr.kosmo.jobkorea.freeboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kosmo.jobkorea.freeboard.service.FreeboardService;
import kr.kosmo.jobkorea.system.model.ComnDtlCodModel;
import kr.kosmo.jobkorea.system.model.ComnGrpCodModel;

public class FreeboardController {

	@Autowired
	FreeboardService freeboard;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	/** 자유게시판 목록 조회 
	 * @return **/
	@RequestMapping("/freeboardlist.do")
	public String freeboardList(Model model,@RequestParam Map<String, String>param
			,HttpServletRequest req,HttpSession session)throws Exception {
		
		logger.info("+ Start " + className + ".freeboardList");
		logger.info("   - param : " + param);
		
		int currentPage = Integer.parseInt((String)param.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)param.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;							// 페이지 시작 row 번호
	
		//paramMap.put("pageIndex", pageIndex);
		//paramMap.put("pageSize", pageSize);
		
		// 공통 그룹코드 목록 조회
		List<ComnGrpCodModel> listComnGrpCodModel = FreeboardService.freelist(param);
		model.addAttribute("listComnGrpCodModel", listComnGrpCodModel);
		
		// 공통 그룹코드 목록 카운트 조회
		int totalCount = FreeboardService.FreeboardList(param);
		model.addAttribute("totalCntComnGrpCod", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageComnGrpCod",currentPage);
		
		logger.info("+ End " + className + ".listComnGrpCod");

		return "/combiz/freeboardlist";


		
	}
	
	/* 자유게시판 저장 */
	@RequestMapping("/saveFreeboard.do")
	@ResponseBody
	public Map<String, Object> saveFreeboard(Model model, @RequestParam Map<String, Object> paramMap, 
			HttpServletRequest req, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".saveFreeboard");
		logger.info("   - paramMap : " + paramMap);

		String action = (String)paramMap.get("action");
		String result = "SUCCESS";
		String resultMsg = "저장 되었습니다.";
		
		// 사용자 정보 설정
		paramMap.put("fst_rgst_sst_id", session.getAttribute("userId"));
		paramMap.put("fnl_mdfr_sst_id", session.getAttribute("usrSstId"));
		
		if ("I".equals(action)) {
			// 상세코드 신규 저장
			FreeboardService.insertboard(paramMap);
		} else if("U".equals(action)) {
			// 상세코드 수정 저장
			FreeboardService.updateboard(paramMap);
		} else {
			result = "FALSE";
			resultMsg = "알수 없는 요청 입니다.";
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".saveFreeboard");
		
		return resultMap;
	}
	

	
	
}
