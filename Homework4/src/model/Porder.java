package model;

public class Porder {
	
	private Integer id;
	private String name;
	private Integer blackcoffee;
	private Integer cappuccino;
	private Integer mocha;
	public Porder(String name, Integer blackcoffee, Integer cappuccino, Integer mocha) {
		super();
		
		this.name = name;
		this.blackcoffee = blackcoffee;
		this.cappuccino = cappuccino;
		this.mocha = mocha;
	}
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBlackcoffee() {
		return blackcoffee;
	}
	public void setBlackcoffee(Integer blackcoffee) {
		this.blackcoffee = blackcoffee;
	}
	public Integer getCappuccino() {
		return cappuccino;
	}
	public void setCappuccino(Integer cappuccino) {
		this.cappuccino = cappuccino;
	}
	public Integer getMocha() {
		return mocha;
	}
	public void setMocha(Integer mocha) {
		this.mocha = mocha;
	}
	
	
}
