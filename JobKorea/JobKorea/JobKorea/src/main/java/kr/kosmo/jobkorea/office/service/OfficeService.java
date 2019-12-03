package kr.kosmo.jobkorea.office.service;

import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.office.dto.OfficeMemberDTO;

public interface OfficeService{

	/*회원 목록 조회*/
	public List<OfficeMemberDTO> OfficeMemList(Map<String, Object> paramMap) throws Exception;
	
	/*회원 정보 */
	public OfficeMemberDTO OfficeMemInfo(Map<String, Object> paramMap) throws Exception;
	
	/*회원 저장*/
	public int OfficeMemInsert(Map<String, Object> paramMap) throws Exception;
	
	/*회원정보 수정*/
	public  OfficeMemberDTO updateInfo(Map<String, Object> paramMap) throws Exception;
	
	/*회원 탈퇴*/
	public  OfficeMemberDTO OfficeMemDelete(Map<String, Object> paramMap) throws Exception;

	
	
	


	


	
	
	
	
	
	
	
}