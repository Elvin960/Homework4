package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService{

	public static void main(String[] args) {
		System.out.println(new PorderServiceImpl().findById(6));

	}
	
	private static PorderDaoImpl porderdaoimpl=new PorderDaoImpl();
	
	
	@Override
	public void addPorder(Porder porder) {
		if(porder.getBlackcoffee()>=0 && porder.getCappuccino()>=0 && porder.getMocha()>=0)
		{
			porderdaoimpl.add(porder);
		}
		
	}

	@Override
	public String AllPorder() {
		List<Porder> l=porderdaoimpl.selectAll();
		String show="";
		
		for(Porder p:l)
		{
			int sum=p.getBlackcoffee()*65+p.getCappuccino()*85+p.getMocha()*80;
			
			show=show+"訂單編號:"+p.getId()+
					"\t客戶名稱:"+p.getName()+
					"\t黑咖啡:"+p.getBlackcoffee()+
					"\t卡布其諾:"+p.getCappuccino()+
					"\t摩卡:"+p.getMocha()+
					"\t金額:"+sum+"元\n";
		}
		
		
		return show;
	}

	@Override
	public String AllPorder2() {
		List<Porder> l=porderdaoimpl.selectAll();
		String show="";
		
		for(Porder p:l)
		{
			int sum=p.getBlackcoffee()*65+p.getCappuccino()*85+p.getMocha()*80;
			
			show=show+"==========="+
					"訂單編號:"+p.getId()+
					"==========="+
					"\n客戶名稱:"+p.getName()+
					"\n黑咖啡:"+p.getBlackcoffee()+
					"\n卡布其諾:"+p.getCappuccino()+
					"\n摩卡:"+p.getMocha()+
					"\n金額:"+sum+"元\n";
		}
		
		
		return show;
	}
	
	
	@Override
	public List<Porder> findAllPorder() {
		
		return porderdaoimpl.selectAll();
	}

	@Override
	public Porder findById(int id) {
	
		Porder porder=null;
		if(id>0)
		{
			List<Porder> l=porderdaoimpl.selectById(id);
			if(l.size()>0)
			{
				porder=l.get(0);
			}
			
		}	
		
		
		
		return porder;
	}

	@Override
	public void updatePorder(String name, int id) {
		Porder p=findById(id);
		p.setName(name);
		
		porderdaoimpl.update(p);
		
	}

	@Override
	public void updatePorder(int blackcoffee, int cappuccino, int mocha, int id) {
		Porder p=findById(id);
		p.setBlackcoffee(blackcoffee);
		p.setCappuccino(cappuccino);
		p.setMocha(mocha);
		
		porderdaoimpl.update(p);
		
	}

	@Override
	public void updatePorder(Porder porder) {
		Porder p=findById(porder.getId());
	
	}

	@Override
	public void deletePorderById(int id) {
		if(id>0)
		{
			porderdaoimpl.delete(id);
		}
		
	}

}
