package regService.member;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public LoginService() {}
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	public MemberVO login (String id, String pwd) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		return memberDAO.login(map);
	}
}
