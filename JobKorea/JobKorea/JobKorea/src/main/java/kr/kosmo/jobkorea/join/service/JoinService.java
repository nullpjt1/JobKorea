package kr.kosmo.jobkorea.join.service;

import java.util.Map;


public interface JoinService {

	//회원가입
	public void insertjoin(Map<String, String> paramMap) throws Exception;
	
}
