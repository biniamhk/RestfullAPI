package se.biniam.restdemo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {
	private int id;
	private String name;
	private int point;
	public Contact() {
		
	}
	
	public Contact(int id,String name, int point) {
		this.id=id;
		this.name = name;
		this.point = point;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", point=" + point + "]";
	}
	

}
