package service;

import model.Member;

public interface MemberService {
	//c
	void addMember(Member member);
	
	
	//r
	Member Login(String username,String password);
	boolean isUsernameBeenUse(String username);
	
	//u
	
	
	//d
	

}
