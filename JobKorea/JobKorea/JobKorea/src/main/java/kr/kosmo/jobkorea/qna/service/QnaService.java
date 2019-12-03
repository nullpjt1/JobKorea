package kr.kosmo.jobkorea.qna.service;

import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.qna.model.CommentsVO;
import kr.kosmo.jobkorea.qna.model.QnaListVO2;


public interface QnaService {

	
	// 게시판 목록보기 
	public List<QnaListVO2> qndList(Map<String, Object> paramMap) throws Exception;

	// qna 게시판 목록 수 확인 
	public int qnaTotalCnt(Map<String, Object>paramMap) throws Exception;
	
	// 게시판 상세페이지 
	public QnaListVO2 selectDetail(Map<String, Object> paramMap) throws Exception;
	
	// 댓글 불러오기 
	public List<CommentsVO> selectComments(Map<String, Object> paramMap) throws Exception;
	
	// 댓글 저장하기 
	public int insertComments(Map<String, Object> paramMap) throws Exception;
	
	// QnA 신규 추가 
	public int insertQna(Map<String, Object> paramMap) throws Exception;
	
	// QnA 답변글 추가 
	public int insertQna2(Map<String, Object> paramMap) throws Exception;
		
	
	// QnA 수정 
	public int updateQna(Map<String, Object> paramMap) throws Exception;
	
	// QnA 삭제 
	public int deleteQna(Map<String, Object> paramMap) throws Exception;
	
	
}
