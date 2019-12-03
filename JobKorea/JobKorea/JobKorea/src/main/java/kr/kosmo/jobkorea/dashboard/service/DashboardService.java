package kr.kosmo.jobkorea.dashboard.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import kr.kosmo.jobkorea.dashboard.dto.DashboardDTO;
import kr.kosmo.jobkorea.dashboard.dto.ProjectDTO;
import kr.kosmo.jobkorea.adm.dto.AdmProjectDTO;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsAtmtFilModel;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsCmtModel;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsModel;
import kr.kosmo.jobkorea.common.comnUtils.FileUtilModel;

public interface DashboardService {

	List<DashboardDTO> selectAdmList(Map<String, Object> map) throws Exception;

	int projectSave(Map<String, Object> map) throws Exception;

	//공지사항 목록
	List<DashboardDTO> getNoticeList(Map<String, Object> paramMap);

	//프로젝트 목록
	List<ProjectDTO> getProjectList(Map<String, Object> paramMap);

	//프로젝트 갯수
	int countListProject(Map<String, Object> paramMap);

	//공지사항 갯수
	int countListNotice(Map<String, Object> paramMap);

	//공지사항 상세보기
	DashboardDTO getNoticeDtl(Map<String, Object> paramMap);

	
	
	
}
