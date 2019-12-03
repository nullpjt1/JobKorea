package kr.kosmo.jobkorea.adm.controller;


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

import kr.kosmo.jobkorea.adm.dto.AdmProjectDTO;
import kr.kosmo.jobkorea.adm.dto.AdmUserDTO;
import kr.kosmo.jobkorea.adm.service.AdmProjectService;
import kr.kosmo.jobkorea.adm.service.admService;
import kr.kosmo.jobkorea.common.comnUtils.ComnCodUtil;
import kr.kosmo.jobkorea.system.model.ComnCodUtilModel;
import kr.kosmo.jobkorea.system.model.ComnGrpCodModel;


@Controller
@RequestMapping(value = "/adm/")
public class AdmUserController {

	@Autowired
	admService service;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	
	@RequestMapping(value = "free.do")
	public String copUserList(@RequestParam Map<String, Object> map ,Model model) throws Exception {
		
		List<ComnCodUtilModel> listLstNum = ComnCodUtil.getComnCod("areaCD"); 
		List<ComnCodUtilModel> listInsNum = ComnCodUtil.getComnCod("industryCD");
		model.addAttribute("listLstNum", listLstNum);		
		model.addAttribute("listInsNum", listInsNum);
		logger.info("listLstNum.size() : " + listLstNum.size());
		//model.addAttribute("test",list);
		return "adm/PersonList";		
		
	}
	 
	@RequestMapping("listPerson.do")
	public String PersonList(Model model, @RequestParam Map<String, Object> map, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".listPerson");
		logger.info("   - map : " + map);
		
		logger.info("   - map : " + map.toString());
		
		System.out.println(" controller  - map : " + map.toString());
		
		int currentPage = Integer.parseInt((String)map.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)map.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호
				
		map.put("pageIndex", pageIndex); 
		map.put("pageSize", pageSize);
		
		// 공통 그룹코드 목록 조회
		List<AdmUserDTO> list = service.selectUserList(map);
		model.addAttribute("test", list);
		
		// 공통 그룹코드 목록 카운트 조회
		int totalCount = service.countListPerson(map);
		model.addAttribute("totalCntProject", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPagePerson",currentPage);
		
		logger.info("+ End " + className + ".listPerson");

		return "adm/admPersonList";
	}
	
	@RequestMapping("PersonList.do")
	public String admPerson(@RequestParam Map<String, Object> map ,Model model ,
			HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		List<AdmUserDTO> list = service.selectUserList(map);
		System.out.println(map+"맵값");
		model.addAttribute("test",list);
		return "adm/PersonList";
	}	
	
	
		
	
}