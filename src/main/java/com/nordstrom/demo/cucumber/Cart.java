package com.nordstrom.demo.cucumber;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	
	private Map<String,Product> products; 
	private String couponCode; 
	private int cartTotal; 
	private int shipingCharge;
	
	public Map<String, Product> getProducts() {
		return products;
	}

	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}


	public String getCouponCode() {
		return couponCode;
	}


	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}


	public int getCartTotal() {
		
		return cartTotal;
	}


	public void setCartTotal(int cartTotal) {
		this.cartTotal = cartTotal;
	}


	public int getShipingCharge() {
		return shipingCharge;
	}


	public void setShipingCharge(int shipingCharge) {
		this.shipingCharge = shipingCharge;
	}


	@Override
	public String toString() {
		return "Cart [products=" + products + ", couponCode=" + couponCode + ", cartTotal=" + cartTotal
				+ ", shipingCharge=" + shipingCharge + "]";
	}
	
	
	
	public void addProductToCart(Product product)
	{
		if(this.products == null)
		{
			this.products = new HashMap<String, Product>(1);
		}
		Product productFromCart = this.products.get(product.getName());
		if(productFromCart == null)
		{
			this.products.put(product.getName(), product);
		}
		else
		{
			productFromCart.setQuantity(productFromCart.getQuantity()+1);
		}
		
		this.setCartTotal(getCartTotal()+product.getPrice());
	
	}

	
	public int totalQuantity(Product product)
	{
		Product productFromCart = this.products.get(product.getName());
		productFromCart.setQuantity(productFromCart.getQuantity());
		return productFromCart.getQuantity();
		
	}

	public void calculateTotal()
	{
		Collection<Product> entries = getProducts().values();
		for(Product entry : entries){
			if(getCartTotal() < 100)
			{
				if(entry.getWeight() < 10)
				{
					int totalAfterShipp = getCartTotal()+5;
					setCartTotal(totalAfterShipp);
				} 
				else
				{
					//No shipping charge 
				}
			}
			
			if(entry.getWeight()>10)
			{
				int totalAfterShipp = getCartTotal()+20;
				setCartTotal(totalAfterShipp);
			}
		}
	}
	

	public void addCouponCode(String code)
	{	
		int carTotal = getCartTotal();
		int totalAfterDiscount = carTotal -(carTotal/Integer.parseInt(code));
		setCartTotal(totalAfterDiscount);
	}

		
	}
	


	


