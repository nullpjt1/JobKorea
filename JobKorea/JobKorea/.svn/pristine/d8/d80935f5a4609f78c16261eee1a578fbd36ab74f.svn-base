package kr.kosmo.jobkorea.dashboard.dao;

import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.dashboard.dto.DashboardDTO;
import kr.kosmo.jobkorea.dashboard.dto.ProjectDTO;
import kr.kosmo.jobkorea.adm.dto.AdmProjectDTO;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsAtmtFilModel;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsCmtModel;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsModel;

public interface DashboardDao {
	
		public List<DashboardDTO> selectAdmList(Map<String, Object> map);

		public int projectSave(Map<String, Object> map);

		//공지사항 목록
		public List<DashboardDTO> getNoticeList(Map<String, Object> paramMap);

		//프로젝트 목록
		public List<ProjectDTO> getProjectList(Map<String, Object> paramMap);

		//프로젝트 갯수
		public int getProjectListCnt(Map<String, Object> paramMap);

		//공지사항 갯수
		public int getNoticeListCnt(Map<String, Object> paramMap);

		//공지사항 상세보기
		public DashboardDTO getNoticeDtl(Map<String, Object> paramMap);
	
	
}
