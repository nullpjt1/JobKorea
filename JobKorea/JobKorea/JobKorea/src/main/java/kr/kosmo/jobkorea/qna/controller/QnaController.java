package kr.kosmo.jobkorea.qna.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kosmo.jobkorea.qna.model.CommentsVO;
import kr.kosmo.jobkorea.qna.model.QnaListVO2;
import kr.kosmo.jobkorea.qna.service.QnaService;

@Controller
@RequestMapping("/qna/")
public class QnaController {

	
	@Autowired
	QnaService qnaService;
	
	/* QnA 리스트 - 초기 화면 */
	@RequestMapping("qnalist.do")
	public String initComnCod(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
			// 로그인해서 리스트를 먼저 뿌린다.		
			model.addAttribute("writer",session.getAttribute("loginId"));
			// 작성 초기 단계에서 쓰려고 미리 뿌린다. 
			//System.out.println("writer : " + session.getAttribute("loginId"));
		return "qna/qnaList";
	}
	
	
	/* qna 리스트 뿌리기 */
	@RequestMapping("qnaReallist.do")
	public String qnaList(Model model, @RequestParam Map<String,Object> paramMap, HttpServletRequest req,
			HttpServletResponse res, HttpSession session) throws Exception {
		
			System.out.println("param에서 넘어온 값을 찍어봅시다.: " + paramMap);
			
			// jsp페이지에서 넘어온 파람 값 정리 (페이징 처리를 위해 필요)
			int currentPage = Integer.parseInt((String)paramMap.get("currentPage")); // 현재페이지 
			int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
			int pageIndex = (currentPage -1)*pageSize;
			
			// 사이즈는 int형으로, index는 2개로 만들어서 -> 다시 파람으로 만들어서 보낸다.
			paramMap.put("pageIndex", pageIndex);
			paramMap.put("pageSize", pageSize);
		
			// 서비스 호출
			List<QnaListVO2> qnalist = qnaService.qndList(paramMap);
			model.addAttribute("qnaList", qnalist);
			
			// 목록 숫자 추출하여 보내기 
			int totalCnt = qnaService.qnaTotalCnt(paramMap);
			model.addAttribute("totalCnt", totalCnt);
			
			System.out.println("자 컨트롤러에서 값을 가지고 jsp로 갑니다~ : " + qnalist.size());
			
		return "qna/qnaRealList";	
	}
	
	
	/* 상세 정보 뿌리기 */
	@RequestMapping("detailQnAlist.do")
	@ResponseBody
	public Map<String,Object> detailList(Model model, @RequestParam Map<String,Object> paramMap, HttpServletRequest req,
			HttpServletResponse res, HttpSession session) throws Exception {
		
		System.out.println("상세정보 보기를 위한 param에서 넘어온 값을 찍어봅시다.: " + paramMap);
		String result="";
		
		// 선택된 게시판 1건 조회 
		QnaListVO2 qna_one = qnaService.selectDetail(paramMap);
		//List<CommentsVO> comments = null;
		
		if(qna_one != null) {
			
			/*
			 * comments = qnaService.selectComments(paramMap); // 댓글 가지고오기 if(comments !=
			 * null) { System.out.println("댓글도 소환완료!"); }
			 */
			result = "SUCCESS";  // 성공시 찍습니다. 
			
		}else {
			result = "FAIL / 불러오기에 실패했습니다.";  // null이면 실패입니다.
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", qna_one); // 리턴 값 해쉬에 담기 
		//resultMap.put("resultComments", comments);
		resultMap.put("resultMsg", result); // success 용어 담기 
		
		System.out.println("결과 글 찍어봅세 " + result);
		System.out.println("결과 글 찍어봅세 " + qna_one);
		
		return resultMap;
	}
	
	
	/* QnA 게시글 등록하기 */
	@RequestMapping("qnaSave.do")
	@ResponseBody
	public Map<String,Object> savaList(Model model, @RequestParam Map<String,Object> paramMap, HttpServletRequest req,
			HttpServletResponse res, HttpSession session) throws Exception {
		
		System.out.println("저장키를 먹나요~~~~?? : " + paramMap.toString());
		
		String action = (String)paramMap.get("action"); // 구분하는 키값 
		System.out.println("action 값 찍어보기 : " + action);
		
		String content = (String)paramMap.get("commentContent");
		System.out.println("아아앙아아아아아아아악 댃글 컨텐트!! " + content);
		
		// 사용자 정보 설정하기 
		// paramMap.put("fst_rgst_sst_id", session.getAttribute("usrSstId"));
		
		String resultMsg = "";
		String id = (String) session.getAttribute("loginId"); // 아이디 
		paramMap.put("writer", id); // session을 통해 아이디 가져옴 
		
		// insert 인지, update 수정인지 확인하기 
		if("I".equals(action)) {
			qnaService.insertQna(paramMap); // 저장 service
			resultMsg = "SUCCESS";
			
		}else if("U".equals(action)) {
			qnaService.updateQna(paramMap); // 수정 service
			resultMsg = "UPDATE";
			
		}else if("D".equals(action)) {
			qnaService.deleteQna(paramMap); // 수정 service
			resultMsg = "DELETE";
			
		}else if("C".equals(action)) {    // 답변글 insert 하기 
			qnaService.insertQna2(paramMap);
			//qnaService.insertComments(paramMap);
			resultMsg = "답변글 insert하기~";
			
		}else {
			resultMsg ="FALSE / 등록에 실패했습니다.";
		}
		
		
		// 결과 값 전송
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultMsg", resultMsg);
		
		return resultMap;
	}
	
	
}
