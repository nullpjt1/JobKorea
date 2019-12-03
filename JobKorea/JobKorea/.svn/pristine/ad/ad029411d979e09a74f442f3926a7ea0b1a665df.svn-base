package kr.kosmo.jobkorea.office.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kosmo.jobkorea.office.dao.ComnDAO;
import kr.kosmo.jobkorea.office.dao.OfficeMemberDAO;
import kr.kosmo.jobkorea.office.dto.OfficeMemberDTO;
import kr.kosmo.jobkorea.system.model.ComnCodUtilModel;
import kr.kosmo.jobkorea.system.model.ComnDtlCodModel;
import kr.kosmo.jobkorea.system.model.ComnGrpCodModel;
import kr.kosmo.jobkorea.system.service.ComnCodService;

@Service
public abstract  class  comnCodimpl implements ComnCodService{
	
	@Autowired
	ComnDAO dao;
	
	private SqlSessionTemplate mysqlSqlSessionTemplate;
	

	@Override
	public int insertComnGrpCod(OfficeMemberDTO officeDTO) throws Exception {
		return mysqlSqlSessionTemplate.insert("kr.kosmo.jobkorea.office.dao.OfficeMemberDAO.OfficeMemjoin",officeDTO);
	}

	@Override
	public int updateComnGrpCod(Map<String, Object> paramMap) throws Exception {
		int n = dao.updateComnGrpCod(paramMap);
		return n;
	}


	

}
