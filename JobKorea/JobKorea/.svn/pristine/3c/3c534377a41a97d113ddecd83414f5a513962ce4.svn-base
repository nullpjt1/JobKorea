package kr.kosmo.jobkorea.roomlist.controller;



import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kosmo.jobkorea.cmnt.model.CmntBbsAtmtFilModel;

import kr.kosmo.jobkorea.roomlist.model.RoomListModel;
import kr.kosmo.jobkorea.roomlist.service.RoomlistService;




@Controller
@RequestMapping("/room")
 public class RoomController {
	
	@Autowired
	RoomlistService roomListService;
	
	// Root path for file upload 
		@Value("${fileUpload.rootPath}")
		private String rootPath;
	
		// comment path for file upload
		@Value("${fileUpload.bbsPath}")
		private String bbsPath;		
		
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	
	
	//자료실 진입
	@RequestMapping(value = "roomlist.do")
	public String roomlist(@RequestParam Map<String, String> paramMap, Model model,
			HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception
	{
		logger.info("+ Start " + className + ".roomlist");
		logger.info("   - paramMap : " + paramMap);
		
		logger.info("+ End " + className + ".roomlist");

		model.addAttribute("loginId",session.getAttribute("loginId"));
		
		
		return "room/roomlist";
	}
	
	
	//조회
	@RequestMapping("SelectRoomList.do")
	public String SelectRoomList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".SelectRoomList");
		logger.info("   - paramMap : " + paramMap.toString());
		
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호
				
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		// 공통 그룹코드 목록 조회
		List<RoomListModel> listRoomModel = roomListService.SelectRoomList(paramMap);
		model.addAttribute("listRoomModel", listRoomModel);
		
		// 공통 그룹코드 목록 카운트 조회
		int totalCount = roomListService.countRoomlist(paramMap);
		model.addAttribute("totalCountRoom", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPage",currentPage);
		
		logger.info("+ End " + className + ".SelectRoomList");

		return "/room/roomSelectlist";
	}	
	
	
	
	@RequestMapping("RoomlistForm.do")
	@ResponseBody
	public Map<String, Object> RoomlistForm(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".RoomlistForm");
		logger.info("   - paramMap : " + paramMap);
		
		String action = (String)paramMap.get("action");
		String result = "SUCCESS";
		String resultMsg = "저장 되었습니다.";
		
		// 사용자 정보 설정
		paramMap.put("regID", session.getAttribute("regID"));
		if ("I".equals(action)) {
			// 그룹코드 신규 저장
			roomListService.insertRoom(paramMap, request);
		} else if("U".equals(action)) {
			// 그룹코드 수정 저장
			roomListService.updateRoom(paramMap, request);
		} else {
			result = "FALSE";
			resultMsg = "알수 없는 요청 입니다.";
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".RoomlistForm");
		
		return resultMap;
	}
	
	//수정 후 저장하기 
	  @RequestMapping("ViewRoom.do")
	  @ResponseBody 
	  public Map<String, Object> ViewRoom (Model model,@RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	  HttpServletResponse response, HttpSession session) throws Exception {
	  
	  logger.info("+ Start " + className + ".ViewRoom");
	  logger.info("   - paramMap : " + paramMap);
	  
	  String result = "SUCCESS"; 
	  String resultMsg = "조회 되었습니다.";
	  
	  // 공통 그룹 코드 단건 조회 
	  RoomListModel roomListModel = roomListService.ViewRoom(paramMap);
	  
	  Map<String, Object> resultMap = new HashMap<String, Object>();
	  resultMap.put("result", result); 
	  resultMap.put("resultMsg", resultMsg);
	  resultMap.put("roomListModel", roomListModel);
	  
	  logger.info("+ End " + className + ".ViewRoom");
	  
	  return resultMap; }
	
	 
	  
	  /**
		 *  그룹코드 삭제
		 */
		@RequestMapping("deleteRoom.do")
		@ResponseBody
		public Map<String, Object> deleteRoom(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) throws Exception {
			
			logger.info("+ Start " + className + ".deleteRoom");
			logger.info("   - paramMap : " + paramMap);

			String result = "SUCCESS";
			String resultMsg = "삭제 되었습니다.";
			
			// 그룹코드 삭제
			roomListService.deleteRoom(paramMap);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("result", result);
			resultMap.put("resultMsg", resultMsg);
			
			logger.info("+ End " + className + ".deleteRoom");
			
			return resultMap;
		}
		
		
		/**
		 * 첨부파일 다운로드
		 */
		@RequestMapping("downloadFile.do")
		public void downloadFile(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) throws Exception {
		
			logger.info("+ Start " + className + ".downloadFile");
			logger.info("   - paramMap : " + paramMap);
			
			// 첨부파일 조회
			RoomListModel roomListModel = roomListService.ViewRoom(paramMap);
			
			byte fileByte[] = FileUtils.readFileToByteArray(new File(rootPath+File.separator+bbsPath+File.separator+roomListModel.getWno()+File.separator+roomListModel.getFile_name()));
			    
			response.setContentType("application/octet-stream");
		    response.setContentLength(fileByte.length);
		    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(roomListModel.getFile_name(),"UTF-8")+"\";");
		    response.setHeader("Content-Transfer-Encoding", "binary");
		    response.getOutputStream().write(fileByte);
		     
		    response.getOutputStream().flush();
		    response.getOutputStream().close();

			logger.info("+ End " + className + ".downloadFile");
		}
		  
	
	
}