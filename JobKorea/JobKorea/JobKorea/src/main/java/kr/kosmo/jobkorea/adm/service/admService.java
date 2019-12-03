package kr.kosmo.jobkorea.adm.service;

import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.adm.dto.AdmUserDTO;
import kr.kosmo.jobkorea.system.model.ComnGrpCodModel;

public interface admService {
	
	public List<AdmUserDTO> selectUserList(Map<String, Object> map) throws Exception;
	
	public int countListPerson(Map<String, Object> map) throws Exception;
	
}
