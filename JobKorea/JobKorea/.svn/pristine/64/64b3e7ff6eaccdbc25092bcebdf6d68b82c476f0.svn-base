package kr.kosmo.jobkorea.commonbiz.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kosmo.jobkorea.adm.dao.AdmUserDAO;
import kr.kosmo.jobkorea.adm.dto.AdmUserDTO;
import kr.kosmo.jobkorea.commonbiz.dao.BASEDDAO;

@Service
public class BASEDServiceImpl implements BASEDService {
	
@Autowired
BASEDDAO dao;
	
	@Override
	public List<AdmUserDTO> selectProjectList(Map<String, Object> map) throws Exception {
		List<AdmUserDTO> list = dao.selectProjectList(map);
		return list;
	}

	@Override
	public List<AdmUserDTO> selectApplyProject(Map<String, Object> map) throws Exception {
		List<AdmUserDTO> list = dao.selectApplyProject(map);
		return list;
	}
	
	// 프로젝트 인원 조회
	@Override
	public List<AdmUserDTO> listPerson(Map<String, Object> map) throws Exception {
		List<AdmUserDTO> listPerson = dao.listPerson(map);
		return listPerson;
	}

	@Override
	public int countListProject(Map<String, Object> map) throws Exception {
		int totalCntProject = dao.countListProject(map);
		return totalCntProject;
	}

}
