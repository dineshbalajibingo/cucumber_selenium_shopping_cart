package com.nordstrom.demo.cucumber;

public class Product {
	
	private String name; 
	private int price;
	private int quantity; 
	private int weight;
	private int subtotal;
	
	public Product(String name,int price ) {
		
		this.name = name;
		this.price = price;
		this.quantity ++;
		
	}
	
	public Product(String name,int price,int weight ) {
		
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.quantity ++;
		
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + ", weight=" + weight
				+ ", subtotal=" + subtotal + "]";
	}

}
