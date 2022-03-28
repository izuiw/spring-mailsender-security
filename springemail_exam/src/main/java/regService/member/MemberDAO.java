package regService.member;

import java.util.HashMap;

public interface MemberDAO {
		
	//회원 가입 관련
	public void insert(MemberVO memberVO);
	
	public void updateAuth(HashMap<String, String> map);
	
	public void updateAuthStatus(HashMap<String, String> map);
	
	public String idCheck(String id);
	
	//로그인 관련
	public MemberVO login(String id);
	
	
	

}
