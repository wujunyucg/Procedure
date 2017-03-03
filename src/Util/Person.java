package Util;

public class Person {

	private int id;
	private int money;
	private int thing;
	private String name;
	@Override
	public String toString() {
		return "Person [id=" + id + ", money=" + money + ", thing=" + thing
				+ ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getThing() {
		return thing;
	}
	public void setThing(int thing) {
		this.thing = thing;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
