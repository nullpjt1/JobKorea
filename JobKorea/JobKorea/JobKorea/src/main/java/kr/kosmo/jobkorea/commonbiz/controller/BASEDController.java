package kr.kosmo.jobkorea.commonbiz.controller;

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

import kr.kosmo.jobkorea.adm.dto.AdmUserDTO;
import kr.kosmo.jobkorea.adm.service.admService;
import kr.kosmo.jobkorea.common.comnUtils.ComnCodUtil;
import kr.kosmo.jobkorea.commonbiz.service.BASEDService;
import kr.kosmo.jobkorea.system.model.ComnCodUtilModel;

@Controller
@RequestMapping("/combiz/")
public class BASEDController {
	
	@Autowired
	BASEDService service;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	
	@RequestMapping(value = "/applylist.do")
	public String applylist(@RequestParam Map<String, Object> map ,Model model,
		HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		List<AdmUserDTO> list = service.selectApplyProject(map);
		
		model.addAttribute("cop", list);	
		
		return "combiz/applylist";	
		
	}
	
	@RequestMapping(value = "/applyprojectlist.do")
	public String applyprojectlist(@RequestParam Map<String, Object> map ,Model model,
		HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		List<AdmUserDTO> list = service.selectProjectList(map);
		
		
		model.addAttribute("test", list);
		return "combiz/applyprojectlist";	
		
	}
	
	@RequestMapping("/listProject.do")
	public String listProject(Model model, @RequestParam Map<String, Object> map, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".listProject");
		logger.info("   - map : " + map);
		
		logger.info("   - map : " + map.toString());
		
		int currentPage = Integer.parseInt((String)map.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)map.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;
		
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		
		// 프로젝트 인원 조회
		List<AdmUserDTO> listPerson = service.listPerson(map);
		model.addAttribute("listPerson", listPerson);
		
		// 프로젝트 인원 카운트 조회
		int totalCount = service.countListProject(map);
		model.addAttribute("totalCntProject", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPagePerson", currentPage);
		
		logger.info("+ End " + className + ".listProject");
		
		return "/combiz/listProjectPerson";
	}
	
}
