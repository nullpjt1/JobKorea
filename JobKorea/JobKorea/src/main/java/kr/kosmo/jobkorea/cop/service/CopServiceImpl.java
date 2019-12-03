package kr.kosmo.jobkorea.cop.service;

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

import kr.kosmo.jobkorea.adm.dao.AdmProjectDao;
import kr.kosmo.jobkorea.adm.dto.AdmProjectDTO;
import kr.kosmo.jobkorea.cmnt.dao.CmntBbsDao;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsAtmtFilModel;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsCmtModel;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsModel;
import kr.kosmo.jobkorea.common.comnUtils.FileUtil;
import kr.kosmo.jobkorea.common.comnUtils.FileUtilModel;
//import kr.kosmo.jobkorea.makmgr.model.MakCmtAtmtFilModel;
//import kr.kosmo.jobkorea.makmgr.model.MakCmtModel;
import kr.kosmo.jobkorea.cop.dao.CopDao;

@Service
public class CopServiceImpl implements CopService {

@Autowired
CopDao dao;
	
	
	/** 프로젝트저장*/
	public int officeSave(Map<String, String> map)  throws Exception{
		int n = dao.officeSave(map);
		return n;
	}
	
}
