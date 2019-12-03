package kr.kosmo.jobkorea.dashboard.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.kosmo.jobkorea.dashboard.dao.DashboardDao;
import kr.kosmo.jobkorea.dashboard.dto.DashboardDTO;
import kr.kosmo.jobkorea.dashboard.dto.ProjectDTO;
import kr.kosmo.jobkorea.adm.dto.AdmProjectDTO;
import kr.kosmo.jobkorea.cmnt.dao.CmntBbsDao;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsAtmtFilModel;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsCmtModel;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsModel;
import kr.kosmo.jobkorea.common.comnUtils.FileUtil;
import kr.kosmo.jobkorea.common.comnUtils.FileUtilModel;
//import kr.kosmo.jobkorea.makmgr.model.MakCmtAtmtFilModel;
//import kr.kosmo.jobkorea.makmgr.model.MakCmtModel;

@Service
public class DashboardServiceImpl implements DashboardService {

@Autowired
DashboardDao dao;
	
	/** 프로젝트목록검색 */
	public List<DashboardDTO> selectAdmList(Map<String, Object> map) throws Exception{
		List<DashboardDTO> list = dao.selectAdmList(map);
		return list;
	}
	/** 프로젝트저장*/
	public int projectSave(Map<String, Object> map) throws Exception{
		int n = dao.projectSave(map);
		return n;
	}
	
	//공지사항 목록
	@Override
	public List<DashboardDTO> getNoticeList(Map<String, Object> paramMap) {
		List<DashboardDTO> list = dao.getNoticeList(paramMap);
		return list;
	}
	
	//프로젝트 목록
	@Override
	public List<ProjectDTO> getProjectList(Map<String, Object> paramMap) {
		List<ProjectDTO> proList = dao.getProjectList(paramMap);
		return proList;
	}
	
	//프로젝트 갯수
	@Override
	public int countListProject(Map<String, Object> paramMap) {
		int proListCnt = dao.getProjectListCnt(paramMap);
		return proListCnt;
	}
	
	//공지사항 갯수
	@Override
	public int countListNotice(Map<String, Object> paramMap) {
		int noListCnt = dao.getNoticeListCnt(paramMap);
		return noListCnt;
	}
	
	//공지사항 상세보기
	@Override
	public DashboardDTO getNoticeDtl(Map<String, Object> paramMap) {
		DashboardDTO noticeDtl = dao.getNoticeDtl(paramMap);
		return noticeDtl;
	}
	
}
