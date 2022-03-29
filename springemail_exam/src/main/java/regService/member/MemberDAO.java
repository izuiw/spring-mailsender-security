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
	
	//비밀번호 찾기 
	public MemberVO findPwd (HashMap<String, String> map);
	
	//임시비밀번호로 변경
	public void updateTmpPwd(HashMap<String, String> map);
	
	

}
