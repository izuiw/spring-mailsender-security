package regService.member;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("LoginCommand")
public class LoginCommand {
	@NotEmpty(message="아이디를 입력해주세요.")
	private String id;
	@NotEmpty(message="비밀번호를 입력해주세요.")
	private String pwd;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

	@Override
	public String toString() {
		return "LoginCommand [id=" + id + ", pwd=" + pwd + "]";
	}
	
	
	
	
	

}
