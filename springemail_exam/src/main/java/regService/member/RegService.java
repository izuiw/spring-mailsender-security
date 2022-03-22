package regService.member;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegService {
	
	
	public RegService() {}
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	
	public void signup(MemberVO memberVO) {
		
		memberDAO.insert(memberVO);
		
	}
	
	public void updateAuth(String email, String auth) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("auth", auth);
		memberDAO.updateAuth(map);
	}
	

	public void updateAuthStatus(String email, String authkey) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email",email);
		map.put("auth", authkey);
		//System.out.println("regService HashMap : " + map.toString());
		memberDAO.updateAuthStatus(map);
	}
	
	


}
