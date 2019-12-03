package kr.kosmo.jobkorea.freeboard.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import kr.kosmo.jobkorea.freeboard.dao.FreeboardDAO;
import kr.kosmo.jobkorea.system.model.ComnDtlCodModel;
import kr.kosmo.jobkorea.system.model.ComnGrpCodModel;

public class FreeboardServiceImpl {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	FreeboardDAO freeboardDao;
	
	/** 그룹코드 목록 조회 */
	public List<ComnGrpCodModel> listComnGrpCod(Map<String, Object> paramMap) throws Exception {
		
		List<ComnGrpCodModel> listComnGrpCod = freeboardDao.listComnGrpCod(paramMap);
		
		return listComnGrpCod;
	}
	
	/** 그룹코드 목록 카운트 조회 */
	public int countListComnGrpCod(Map<String, Object> paramMap) throws Exception {
		
		int totalCount = freeboardDao.countListComnGrpCod(paramMap);
		
		return totalCount;
	}
	
	/** 그룹코드 단건 조회 */
	public ComnGrpCodModel selectlist(Map<String, Object> paramMap) throws Exception {
		
		ComnGrpCodModel comnGrpCodModel = freeboardDao.selectComnGrpCod(paramMap);
		return comnGrpCodModel;
	}
	
	/** 그룹코드 저장 */
	public int insertsave(Map<String, Object> paramMap) throws Exception {
		
		int ret = freeboardDao.insertComnGrpCod(paramMap);
		
		return ret;
	}
	
	/** 상세코드 목록 조회 */
	public List<ComnDtlCodModel> listComnDtlCod(Map<String, Object> paramMap) throws Exception {
		
		List<ComnDtlCodModel> listComnGrpCod = freeboardDao.listComnDtlCod(paramMap);
		
		return listComnGrpCod;
	}
	
	/** 그룹코드 목록 카운트 조회 */
	public int countListComnDtlCod(Map<String, Object> paramMap) throws Exception {
		
		int totalCount = freeboardDao.countListComnDtlCod(paramMap);
		
		return totalCount;
	}
	
	/** 상세코드 단건 조회 */
	public ComnDtlCodModel selectComnDtlCod(Map<String, Object> paramMap) throws Exception {
		
		ComnDtlCodModel comnDtlCodModel = freeboardDao.selectComnDtlCod(paramMap);
		return comnDtlCodModel;
	}
	
	/** 상세코드 저장 */
	public int insertComnDtlCod(Map<String, Object> paramMap) throws Exception {
		
		int ret = freeboardDao.insertComnDtlCod(paramMap);
		return ret;
	}
	
		

}
