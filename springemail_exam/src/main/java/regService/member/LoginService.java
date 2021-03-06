package regService.member;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public LoginService() {}
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	public MemberVO login (String id) {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("id", id);
//		map.put("pwd", pwd);
		
		return memberDAO.login(id);
	}
	
	public MemberVO findPwd (String id, String email) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("email", email);
		return memberDAO.findPwd(map);
	}
	
	public void updateTmpPwd(String encodePwd, String id,String email) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("tmpPwd", encodePwd);
		map.put("id", id);
		map.put("email", email);
		memberDAO.updateTmpPwd(map);
		
	}

}
