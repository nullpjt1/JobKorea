package kr.kosmo.jobkorea.dashboard.model;

public class DashboardModel {
	// 환자 ID
	private String ptet_id;
	// 환자 명
	private String ptet_nm;
	// 최신 진행 단계
	private String wrq_stp_nm;
	// 의사 ID
	private String ofc_psnl_id;
	// 담당의사 명
	private String psnl_nm;
	// 환자 차트 번호
	private String chat_num;
	// 오피스 ID
	private String ofc_id;
	// 오피스 명
	private String ofc_nm;
	// 코멘트 갯수
	private String cmt_cnt;
	/**
	 * @return the ptet_id
	 */
	public String getPtet_id() {
		return ptet_id;
	}
	/**
	 * @param ptet_id the ptet_id to set
	 */
	public void setPtet_id(String ptet_id) {
		this.ptet_id = ptet_id;
	}
	/**
	 * @return the ptet_nm
	 */
	public String getPtet_nm() {
		return ptet_nm;
	}
	/**
	 * @param ptet_nm the ptet_nm to set
	 */
	public void setPtet_nm(String ptet_nm) {
		this.ptet_nm = ptet_nm;
	}
	/**
	 * @return the wrq_stp_nm
	 */
	public String getWrq_stp_nm() {
		return wrq_stp_nm;
	}
	/**
	 * @param wrq_stp_nm the wrq_stp_nm to set
	 */
	public void setWrq_stp_nm(String wrq_stp_nm) {
		this.wrq_stp_nm = wrq_stp_nm;
	}
	/**
	 * @return the ofc_psnl_id
	 */
	public String getOfc_psnl_id() {
		return ofc_psnl_id;
	}
	/**
	 * @param ofc_psnl_id the ofc_psnl_id to set
	 */
	public void setOfc_psnl_id(String ofc_psnl_id) {
		this.ofc_psnl_id = ofc_psnl_id;
	}
	/**
	 * @return the psnl_nm
	 */
	public String getPsnl_nm() {
		return psnl_nm;
	}
	/**
	 * @param psnl_nm the psnl_nm to set
	 */
	public void setPsnl_nm(String psnl_nm) {
		this.psnl_nm = psnl_nm;
	}
	/**
	 * @return the chat_num
	 */
	public String getChat_num() {
		return chat_num;
	}
	/**
	 * @param chat_num the chat_num to set
	 */
	public void setChat_num(String chat_num) {
		this.chat_num = chat_num;
	}
	/**
	 * @return the ofc_id
	 */
	public String getOfc_id() {
		return ofc_id;
	}
	/**
	 * @param ofc_id the ofc_id to set
	 */
	public void setOfc_id(String ofc_id) {
		this.ofc_id = ofc_id;
	}
	/**
	 * @return the ofc_nm
	 */
	public String getOfc_nm() {
		return ofc_nm;
	}
	/**
	 * @param ofc_nm the ofc_nm to set
	 */
	public void setOfc_nm(String ofc_nm) {
		this.ofc_nm = ofc_nm;
	}
	/**
	 * @return the cmt_cnt
	 */
	public String getCmt_cnt() {
		return cmt_cnt;
	}
	/**
	 * @param cmt_cnt the cmt_cnt to set
	 */
	public void setCmt_cnt(String cmt_cnt) {
		this.cmt_cnt = cmt_cnt;
	}
}
