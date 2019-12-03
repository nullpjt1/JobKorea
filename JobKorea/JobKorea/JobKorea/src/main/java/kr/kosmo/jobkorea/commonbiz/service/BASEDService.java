package kr.kosmo.jobkorea.commonbiz.service;

import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.adm.dto.AdmUserDTO;

public interface BASEDService {
	
	public List<AdmUserDTO> selectProjectList(Map<String, Object> map) throws Exception;
	
	public List<AdmUserDTO> selectApplyProject(Map<String, Object> map) throws Exception;
	
	public List<AdmUserDTO> listPerson(Map<String, Object> map) throws Exception;
	
	public int countListProject(Map<String, Object> map) throws Exception;
}
