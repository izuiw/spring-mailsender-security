package regService.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {

	public LoginService() {}
	
	@Autowired
	private MemberDAO memberDAO;
	
	
}
