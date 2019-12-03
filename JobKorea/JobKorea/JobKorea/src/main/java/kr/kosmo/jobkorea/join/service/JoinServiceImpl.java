package kr.kosmo.jobkorea.join.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kosmo.jobkorea.system.dao.ComnCodDao;
import kr.kosmo.jobkorea.system.model.ComnCodUtilModel;
import kr.kosmo.jobkorea.system.model.ComnDtlCodModel;
import kr.kosmo.jobkorea.system.model.ComnGrpCodModel;
import kr.kosmo.jobkorea.join.dao.JoinDAO;
import kr.kosmo.jobkorea.join.dto.JoinDTO;
import kr.kosmo.jobkorea.join.service.JoinService;
@Service
public class JoinServiceImpl implements JoinService {
	@Autowired
	private JoinDAO joinDAO;

	@Override
	public void insertjoin(Map<String, String> paramMap) throws Exception {
		
		joinDAO.insertjoin(paramMap);
		
	}
	
}
