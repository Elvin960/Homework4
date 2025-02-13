package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	//c
	void add(Member member);
	
	//r
	List<Member> selectAll();
	List<Member> selectUsernameAndPassword(String username,String password);
	List<Member> selectById(int id);
	List<Member> selectByUsername(String username);
	
	//u
	void update(Member member);
	
	//d
	void delete(int id);
}
