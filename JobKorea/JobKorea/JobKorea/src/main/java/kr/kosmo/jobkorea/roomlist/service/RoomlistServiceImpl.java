package kr.kosmo.jobkorea.roomlist.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.kosmo.jobkorea.cmnt.dao.CmntBbsDao;
import kr.kosmo.jobkorea.cmnt.model.CmntBbsAtmtFilModel;
import kr.kosmo.jobkorea.common.comnUtils.FileUtil;
import kr.kosmo.jobkorea.common.comnUtils.FileUtilModel;
import kr.kosmo.jobkorea.roomlist.dao.RoomDAO;
import kr.kosmo.jobkorea.roomlist.model.RoomListModel;

@Service
public class RoomlistServiceImpl implements RoomlistService {
	   
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	// comment path for file upload
	@Value("${fileUpload.bbsPath}")
	private String bbsPath;

	
	@Value("${fileUpload.rootPath}")
	private String rootPath;	
	
	@Autowired
	RoomDAO roomDAO;
	
	
	public List<RoomListModel> SelectRoomList(Map<String, Object> paramMap ) throws Exception {
		
		List<RoomListModel> SelectRoomList = roomDAO.SelectRoomList(paramMap);
		
		return SelectRoomList;
	}
	
	
	public int countRoomlist(Map<String, Object> paramMap) throws Exception {
		
		int totalCount = roomDAO.countRoomlist(paramMap);
		
		return totalCount;
	}
	
	
	  public RoomListModel ViewRoom(Map<String, Object> paramMap) throws Exception
	  {
	  RoomListModel roomListModel = roomDAO.ViewRoom(paramMap);
	  //paramMap.put("file_name", fileUtilModel.getPsc_fil_nm());
	  return roomListModel;
	  
	  }
	
	
	
	public int insertRoom(Map<String, Object> paramMap, HttpServletRequest request) throws Exception{
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		
		String wno = roomDAO.insertkey();
		
		// 파일 저장
		String file_path = bbsPath + File.separator + wno + File.separator;
		FileUtil fileUtil = new FileUtil(multipartHttpServletRequest, rootPath, file_path);
		List<FileUtilModel> listFileUtilModel = fileUtil.uploadFiles();
		
		for (FileUtilModel fileUtilModel : listFileUtilModel) {
			paramMap.put("file_name", fileUtilModel.getLgc_fil_nm());
			//paramMap.put("file_name", fileUtilModel.getPsc_fil_nm());
			paramMap.put("file_path",file_path );
			paramMap.put("file_size", fileUtilModel.getFil_siz());
			//paramMap.put("fil_ets", fileUtilModel.getFil_ets());

			paramMap.put("wno", wno);
			
			int ret = roomDAO.insertRoom(paramMap);
		}
				
		return 0;
	}
	
	public int updateRoom(Map<String, Object> paramMap, HttpServletRequest request) throws Exception{
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		
		String wno = (String) paramMap.get("wno");
		
		RoomListModel selinfo = roomDAO.ViewRoom(paramMap);
		String orgfilename  = selinfo.getFile_name();
		
		String file_path = bbsPath + File.separator + wno + File.separator;
		
		File file = new File(file_path + orgfilename);
		if (file.exists()) file.delete();
		
		// 파일 저장		
  	    FileUtil fileUtil = new FileUtil(multipartHttpServletRequest, rootPath, file_path);
		List<FileUtilModel> listFileUtilModel = fileUtil.uploadFiles();
				
		for (FileUtilModel fileUtilModel : listFileUtilModel) {
			paramMap.put("file_name", fileUtilModel.getLgc_fil_nm());
			//paramMap.put("file_name", fileUtilModel.getPsc_fil_nm());
			paramMap.put("file_path",file_path );
			paramMap.put("file_size", fileUtilModel.getFil_siz());
			//paramMap.put("fil_ets", fileUtilModel.getFil_ets());

			int ret = roomDAO.updateRoom(paramMap);
		}
		
		return 0;
	}
	
	public int deleteRoom(Map<String, Object> paramMap) throws Exception{
		int ret = roomDAO.deleteRoom(paramMap);
		
		return ret;
	}
	

	 

	
	
}
