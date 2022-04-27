package com.myspring.domain;

public class ProductVO {
	private String name;
	private double price;
	
	
	public ProductVO() {}	// 기본 생성자
	public ProductVO(String name, double price) {	// 생성자 오버로딩
		super();
		this.name = name;
		this.price = price;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	}
	
	
}
