package kr.kosmo.jobkorea.commonbiz.service;

import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.commonbiz.model.QnaListVO;


public interface QnaService {

	
	// 게시판 목록보기 
	public List<QnaListVO> qndList(Map<String, Object> paramMap) throws Exception;

	// qna 게시판 목록 수 확인 
	public int qnaTotalCnt(Map<String, Object>paramMap) throws Exception;
	
	// 게시판 상세페이지 
	public QnaListVO selectDetail(Map<String, Object> paramMap) throws Exception;
	
	// QnA 추가 
	public int insertQna(Map<String, Object> paramMap) throws Exception;
	
	// QnA 수정 
	public int updateQna(Map<String, Object> paramMap) throws Exception;
	
	// QnA 삭제 
	public int deleteQna(Map<String, Object> paramMap) throws Exception;
	
}
