package kr.kosmo.jobkorea.commonbiz.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kosmo.jobkorea.commonbiz.dao.QnaDAO;
import kr.kosmo.jobkorea.commonbiz.model.QnaListVO;

@Service("/QnaSercive")
public class QnaServiceImpl implements QnaService{
	
	
	@Autowired
	QnaDAO qdao;
	
	// Qna 목록 뿌리기 
	@Override
	public List<QnaListVO> qndList(Map<String, Object> paramMap) throws Exception {
		
		/*
		 * // Qna 수 구하기 int cnt = qdao.selectQnaListCnt(paramMap);
		 * System.out.println("cnt 는?? : " + cnt);
		 */
		// 넘길 리스트 값 선언 
		List<QnaListVO> qndList = null;
		
		// 글 수가 0건보 다 많으면 리스트 불러오기 
		//if(cnt > 0) {
			qndList = qdao.selectQnaList(paramMap);
		//}
		
		return qndList;
	}

	// 큐엔에이 목록 갯수 확인 
	@Override
	public int qnaTotalCnt(Map<String, Object> paramMap) throws Exception {
		int totalCnt = qdao.selectQnaListCnt(paramMap);
		return totalCnt;
	}

	// 큐엔에이 상세정보 
	@Override
	public QnaListVO selectDetail(Map<String, Object> paramMap) throws Exception {
		
		// 게시판 조회 수 증가시키기
		qdao.addReadCnt(paramMap);
		
		// 상세정보 가져오기 
		QnaListVO detail = qdao.selectDetail(paramMap);
		return detail;
	}

	// QnA 추가 
	@Override
	public int insertQna(Map<String, Object> paramMap) throws Exception {
		int numResult = qdao.numPlus();
		
		paramMap.put("num", numResult); // 번호 여기에 추가 
		int resultCnt = qdao.insertOne(paramMap);
		return resultCnt;
	}

	// QnA 수정
	@Override
	public int updateQna(Map<String, Object> paramMap) throws Exception {
		int resultCnt = qdao.updateOne(paramMap);
		return resultCnt;
	}

	// QnA 삭제 
	@Override
	public int deleteQna(Map<String, Object> paramMap) throws Exception {
		int resultCnt = qdao.deleteOne(paramMap);
		return 0;
	}
	
	
	
	

}
