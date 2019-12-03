package kr.kosmo.jobkorea.roomlist.dao;

import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.cmnt.model.CmntBbsAtmtFilModel;
import kr.kosmo.jobkorea.roomlist.model.RoomListModel;

public interface RoomDAO {
	
	//자료실 리스트 조회
	public List<RoomListModel> SelectRoomList(Map<String, Object> paramMap);
	
	//자료실 리스트 count
	public int countRoomlist(Map<String, Object> paramMap);
	
	public int insertRoom(Map<String, Object> paramMap);
	
	public int updateRoom(Map<String, Object> paramMap);
	
	public RoomListModel ViewRoom(Map<String, Object> paramMap);

	public int deleteRoom(Map<String, Object> paramMap);
	
	public String insertkey();
	
	/** 게시글 첨부 목록 조회 */
	public List<CmntBbsAtmtFilModel> listCmntBbsAtmtFil(Map<String, Object>paramMap);
	
	public CmntBbsAtmtFilModel selectCmntBbsAtmtFil(Map<String, Object>paramMap);
	
	/** 게시글 첨부 파일 저장 */
	public int saveCmntBbsAtmtFil(Map<String, Object>paramMap);
	
	/** 게시글 첨부 파일 수정 */
	public int updateCmntBbsAtmtFil(Map<String, Object>paramMap);
	
	public int deleteCmntBbsAtmtFil(Map<String, Object>paramMap);
}
