package dao;

import java.util.List;

import model.Porder;

public interface PorderDao {
	//c
	void add(Porder porder);
	
	//r
	List<Porder> selectAll();
	List<Porder> selectById(int id);
	
	//u
	void update(Porder porder);
	
	//d
	void delete(int id);
}
