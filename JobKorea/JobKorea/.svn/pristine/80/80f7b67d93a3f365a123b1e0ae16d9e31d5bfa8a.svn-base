package kr.kosmo.jobkorea.adm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kosmo.jobkorea.adm.dao.AdmProjectDao;
import kr.kosmo.jobkorea.adm.dao.AdmUserDAO;
import kr.kosmo.jobkorea.adm.dto.AdmUserDTO;

@Service
public class admServiceImpl implements admService {

@Autowired
AdmUserDAO dao;
	
	@Override
	public List<AdmUserDTO> selectUserList(Map<String, Object> map) throws Exception {
		
		System.out.println("   - map : " + map.toString());
		
		List<AdmUserDTO> list = dao.selectUserList(map);
		return list;
	}

	@Override
	public int countListPerson(Map<String, Object> map) throws Exception {
		int totalCount = dao.countListPerson(map);
		
		return totalCount;
	}
	
	
		

}
