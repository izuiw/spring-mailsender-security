package regService.member;

public class MemberVO {
	
	private Long num;
	private String id;
	private String pwd;
	private String email;
	private String auth;
	private int authstatus;
	
	
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
	public int getAuthstatus() {
		return authstatus;
	}
	public void setAuthstatus(int authstatus) {
		this.authstatus = authstatus;
	}
	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pwd=" + pwd + ", email=" + email + ", auth=" + auth
				+ ", authstatus=" + authstatus + "]";
	}


	
	

}
