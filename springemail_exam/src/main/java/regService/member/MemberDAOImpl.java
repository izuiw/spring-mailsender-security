package regService.member;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlST;
	
	public MemberDAOImpl (SqlSessionTemplate sqlST) {
		this.sqlST = sqlST;
	}

	@Override
	public void insert(MemberVO memberVO) {
		// TODO Auto-generated method stub
		sqlST.insert("insert", memberVO);
		
	}

	@Override
	public void updateAuth(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		sqlST.update("updateAuth", map);
		
		
	}

	@Override
	public void updateAuthStatus(HashMap<String,String> map) {
		// TODO Auto-generated method stub
		sqlST.update("updateAuthStatus", map);
	}

	@Override
	public MemberVO login(String id) {
		// TODO Auto-generated method stub
		return sqlST.selectOne("login", id);
	}

	@Override
	public String idCheck(String id) {
		// TODO Auto-generated method stub
		return sqlST.selectOne("idCheck", id);
	}

	@Override
	public MemberVO findPwd(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return sqlST.selectOne("findPwd", map);
	}

	@Override
	public void updateTmpPwd(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		sqlST.update("updateTmpPwd", map);
		
	}




}
