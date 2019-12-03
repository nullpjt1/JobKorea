package kr.kosmo.jobkorea.cop.controller;


import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.kosmo.jobkorea.cop.service.CopService;



@Controller
@RequestMapping(value = "/cop/")
public class CopController {
    
	@Autowired
	CopService service;
	
	@RequestMapping(value = "officeReg.do")
	public String admProject() 
	{
		
		
		return "cop/officeReg";
	}
	
	@RequestMapping(value = "officeSave.do")
	public String officeSave(@RequestParam Map<String,String> map)throws Exception {
		
		int n = service.officeSave(map);
		return "/login.do";
	}
	
	
}
