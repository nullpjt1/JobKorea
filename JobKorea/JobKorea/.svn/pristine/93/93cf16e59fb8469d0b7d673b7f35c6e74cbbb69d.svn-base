package kr.kosmo.jobkorea.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kosmo.jobkorea.adm.dto.AdmProjectDTO;
import kr.kosmo.jobkorea.adm.service.AdmProjectService;
import kr.kosmo.jobkorea.dashboard.dto.DashboardDTO;
import kr.kosmo.jobkorea.dashboard.dto.ProjectDTO;
import kr.kosmo.jobkorea.dashboard.service.DashboardService;
import kr.kosmo.jobkorea.system.model.ComnGrpCodModel;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	private final Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	DashboardService dashService;

	// Get class name for logger
	private final String className = this.getClass().toString();

	@RequestMapping("/dashboard.do")
	public String initDashboard(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".initDashboard");
		/* ############## set input data################# */
		paramMap.put("loginId", session.getAttribute("loginId")); // 제목
		paramMap.put("userType", session.getAttribute("userType")); // 오피스 구분 // 코드
		paramMap.put("reg_date", session.getAttribute("reg_date")); // 등록 일자
		logger.info("   - paramMap : " + paramMap);

		String returnType = "/dashboard/dashboardMgr";

		logger.info("+ end " + className + ".initDashboard");

		return returnType;
	}

	// 프로젝트 목록
	@RequestMapping("proList.do")
	public String proList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("   - proListParamMap : " + paramMap);

		if (paramMap != null) {
			int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재 페이지 번호
			int pageSize = Integer.parseInt((String) paramMap.get("pageSize")); // 페이지 사이즈
			int pageIndex = (currentPage - 1) * pageSize; // 페이지 시작 row 번호

			logger.info("P 현재 :" + currentPage + " 사이즈 : " + pageSize + " 인덱스 :" + pageIndex);

			paramMap.put("pageIndex", pageIndex);
			paramMap.put("pageSize", pageSize);

			model.addAttribute("pageSize", pageSize);
			model.addAttribute("currentPageProCod", currentPage);
			
			logger.info("프로젝트 목록 가지러 감");
			List<ProjectDTO> plist = dashService.getProjectList(paramMap);
			model.addAttribute("project", plist);
		}

		logger.info("프로젝트 목록 가지러 감");
		List<ProjectDTO> plist = dashService.getProjectList(paramMap);
		model.addAttribute("project", plist);

		// 프로젝트 갯수
		int totalCount = dashService.countListProject(paramMap);
		model.addAttribute("totalCntProCod", totalCount);

		return "/dashboard/projectList";
	}

	// 공지사항 목록
	@RequestMapping("noList.do")
	public String noList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("   - paramMap : " + paramMap);

		int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재 페이지 번호
		int pageSize = Integer.parseInt((String) paramMap.get("pageSize")); // 페이지 사이즈
		int pageIndex = (currentPage - 1) * pageSize; // 페이지 시작 row 번호

		logger.info("N 현재 :" + currentPage + " 사이즈 : " + pageSize + " 인덱스 :" + pageIndex);

		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);

		logger.info("공지사항 가지러 감");
		List<DashboardDTO> nlist = dashService.getNoticeList(paramMap);
		model.addAttribute("notice", nlist);

		// 공지사항 글 갯수
		int totalCount = dashService.countListNotice(paramMap);
		model.addAttribute("totalCntNoCod", totalCount);

		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageNoCod", currentPage);

		return "/dashboard/noticeList";
	}
	
	@RequestMapping("/project.do")
	public String project(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".initDashboard");
		/* ############## set input data################# */
		paramMap.put("loginId", session.getAttribute("loginId")); // 제목
		paramMap.put("userType", session.getAttribute("userType")); // 오피스 구분 // 코드
		paramMap.put("reg_date", session.getAttribute("reg_date")); // 등록 일자
		logger.info("   - paramMap : " + paramMap);

		String returnType = "/dashboard/ULproject";

		logger.info("일반회원 -> 프로젝트 목록 찾으러 갑니다 뿌뿌");

		return returnType;
	}
	
	//공지사항 상세보기
	@RequestMapping("/selectNotice.do")
	@ResponseBody
	public Map<String, Object> selectNotice(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".initDashboard");
		/* ############## set input data################# */
		paramMap.put("loginId", session.getAttribute("loginId")); // 제목
		paramMap.put("userType", session.getAttribute("userType")); // 오피스 구분 // 코드
		paramMap.put("reg_date", session.getAttribute("reg_date")); // 등록 일자
		logger.info("   - Notice paramMap : " + paramMap);

		logger.info("공지사항 상세보기 찾으러 갑니다 뿌뿌");
		
		DashboardDTO nDetail = dashService.getNoticeDtl(paramMap);
		
		String result = "SUCCESS";
		String resultMsg="조회성공";
		
		logger.info(resultMsg);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		resultMap.put("nDetail", nDetail);

		return resultMap;
	}
	
	//프로젝트 상세보기
	@RequestMapping("/selectProject.do")
	public Map<String, Object> selectProject(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".initDashboard");
		/* ############## set input data################# */
		paramMap.put("loginId", session.getAttribute("loginId")); // 제목
		paramMap.put("userType", session.getAttribute("userType")); // 오피스 구분 // 코드
		paramMap.put("reg_date", session.getAttribute("reg_date")); // 등록 일자
		logger.info("   - Project paramMap : " + paramMap);

		logger.info("프로젝트 상세보기 찾으러 갑니다 뿌뿌");

		String result = "SUCCESS";
		String resultMsg="조회성공";
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		//resultMap.put("nDetail", nDetail);
		
		return resultMap;
	}

}
