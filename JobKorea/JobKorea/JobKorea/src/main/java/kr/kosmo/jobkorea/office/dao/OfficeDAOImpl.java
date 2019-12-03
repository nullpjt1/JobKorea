package kr.kosmo.jobkorea.office.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.MySQLConnection;

import kr.kosmo.jobkorea.office.dto.OfficeMemberDTO;

@Service
public class OfficeDAOImpl implements OfficeMemberDAO {

	
	@Autowired
	private SqlSessionTemplate mysqlSqlSessionTemplate;


	@Override
	public List<OfficeMemberDTO> OfficeMemList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OfficeMemberDTO OfficeMemInfo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int OfficeMemInsert(OfficeMemberDTO officeDTO) {
		// TODO Auto-generated method stub
		return mysqlSqlSessionTemplate.insert("kr.kosmo.jobkorea.office.dao.OfficeMemberDAO.OfficeMemjoin",officeDTO);
		
	}


	@Override
	public OfficeMemberDTO updateInfo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OfficeMemberDTO OfficeMemDelete(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
	