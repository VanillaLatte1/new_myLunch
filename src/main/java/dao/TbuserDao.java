package dao;

import dto.tbUser;

public interface TbuserDao {
	//회원가입
	//로그인
	public tbUser selectLogin(String userId, String userPw);
	//아이디 체크

}
