package regService.member;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("regService")
public class RegService {
	
	
	public RegService() {}
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	
	public void signup(MemberVO memberVO) {
		
		memberDAO.insert(memberVO);
		
	}
	
	public void updateAuth(HashMap<String, String> map) {
		memberDAO.updateAuth(map);
	}
	
	public void updateAuthStatus(String email) {
		memberDAO.updateAuthStatus(email);
	}
	
	


}
