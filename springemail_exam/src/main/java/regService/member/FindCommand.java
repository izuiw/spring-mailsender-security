package regService.member;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("FindCommand")
public class FindCommand {
	@NotEmpty(message="아이디를 입력해주세요.")
	private String id;
	private String pwd;
	@NotEmpty(message="이메일을 입력해주세요.")
	private String email;
	
	private String tmpPwd;
	
	public String getTmpPwd() {
		return tmpPwd;
	}
	public void setTmpPwd(String tmpPwd) {
		this.tmpPwd = tmpPwd;
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
	
	@Override
	public String toString() {
		return "FIndCommand [id=" + id + ", pwd=" + pwd + ", email=" + email + "]";
	}
	
	

}
