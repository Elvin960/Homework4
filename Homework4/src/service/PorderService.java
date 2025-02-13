package service;

import java.util.List;

import model.Porder;

public interface PorderService {
	//c
	void addPorder(Porder porder);
	
	//r
	String AllPorder();
	List<Porder> findAllPorder();	
	Porder findById(int id);
	
	//u
	void updatePorder(String name,int id);
	void updatePorder(int lcd,int ram,int mouse,int id);
	void updatePorder(Porder porder);
	
	//d
	void deletePorderById(int id);

	String AllPorder2();

}
