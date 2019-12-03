package kr.kosmo.jobkorea.office.dao;

import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.office.dto.OfficeMemberDTO;

public interface OfficeMemberDAO{
	
	
	/*회원 목록 조회*/
	public List<OfficeMemberDTO> OfficeMemList(Map<String, Object> paramMap);
	
	/*회원 정보 */
	public OfficeMemberDTO OfficeMemInfo(Map<String, Object> paramMap);
	
	/*회원 저장*/
	public int OfficeMemInsert(OfficeMemberDTO officeDTO);
	
	/*회원정보 수정*/
	public  OfficeMemberDTO updateInfo(Map<String, Object> paramMap);
	
	/*회원 탈퇴*/
	public  OfficeMemberDTO OfficeMemDelete(Map<String, Object> paramMap);

	
	

	
	
	
	
}
