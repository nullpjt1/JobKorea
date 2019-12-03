package kr.kosmo.jobkorea.commonbiz.dao;

import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.commonbiz.model.QnaListVO;

public interface QnaDAO {
	
	// Qna 수 구하기
	public int selectQnaListCnt(Map<String,Object> paramMap);
	
	// Qna 목록 뿌리기 
	public List<QnaListVO> selectQnaList(Map<String,Object> paramMap);
	
	// Qna 상세정보 보기 
	public QnaListVO selectDetail(Map<String,Object> paramMap);
	
	// num +1 하기 
	public int numPlus();
	
	// 조회수 + 1하기 
	public int addReadCnt(Map<String,Object> paramMap);
	
	// QnA 추가 
	public int insertOne(Map<String,Object> paramMap);
	
	// QnA 수정
	public int updateOne(Map<String,Object> paramMap);
	
	// QnA 삭제
	public int deleteOne(Map<String,Object> paramMap);
	
}
