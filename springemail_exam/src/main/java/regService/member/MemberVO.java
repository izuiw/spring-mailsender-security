package regService.member;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("MemberVO")
public class MemberVO {
	
	private Long num;
	@NotEmpty(message="아이디를 입력해주세요.")
	private String id;
	@NotEmpty(message="비밀번호를 입력해주세요.")
	private String pwd;
	@NotEmpty(message="이메일을 입력해주세요.")
	private String email;
	private String auth;
	private String authstatus;
	
	
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAuthstatus() {
		return authstatus;
	}
	public void setAuthstatus(String authstatus) {
		this.authstatus = authstatus;
	}
	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pwd=" + pwd + ", email=" + email + ", auth=" + auth
				+ ", authstatus=" + authstatus + "]";
	}


	
	

}
