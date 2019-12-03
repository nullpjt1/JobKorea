package kr.kosmo.jobkorea.qna.dao;

import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.qna.model.CommentsVO;
import kr.kosmo.jobkorea.qna.model.QnaListVO2;

public interface QnaDAO {
	
	// Qna 수 구하기
	public int selectQnaListCnt(Map<String,Object> paramMap);
	
	// Qna 목록 뿌리기 
	public List<QnaListVO2> selectQnaList(Map<String,Object> paramMap);
	
	// Qna 상세정보 보기 
	public QnaListVO2 selectDetail(Map<String,Object> paramMap);
	
	// num +1 하기 
	public int numPlus();
	
	// 조회수 + 1하기 
	public int addReadCnt(Map<String,Object> paramMap);
	
	// QnA 신규 추가 
	public int insertOne(Map<String,Object> paramMap);
	
	// QnA 답변글 추가 
	public int insertTwo(Map<String,Object> paramMap);
	
	// QnA 수정
	public int updateOne(Map<String,Object> paramMap);
	
	// QnA 삭제
	public int deleteOne(Map<String,Object> paramMap);
	
	// 댓글 불러오기 
	public List<CommentsVO> selectComments(Map<String,Object> paramMap);
	
	// 댓글 저장하기 
	public int insertComments(Map<String,Object> paramMap);
	
}
