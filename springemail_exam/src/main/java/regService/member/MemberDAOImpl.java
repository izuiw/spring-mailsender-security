package regService.member;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
	public void updateAuthStatus(String email) {
		// TODO Auto-generated method stub
		sqlST.update("updateAuthStatus", email);
	}

	@Override
	public MemberVO login(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return sqlST.selectOne("login", map);
	}

	@Override
	public String idCheck(String id) {
		// TODO Auto-generated method stub
		return sqlST.selectOne("idCheck", id);
	}




}