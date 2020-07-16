package com.bit.mysite.vo;

public class OrderVo {

	private int no;
	private int product_no;
	private String product_name;
	private int order_product_count;
	private String order_date;
	private String users_no;
	private String users_name;
	private int order_product_price;
	
	
	public int getOrder_product_price() {
		return order_product_price;
	}
	public void setOrder_product_price(int order_product_price) {
		this.order_product_price = order_product_price;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getOrder_product_count() {
		return order_product_count;
	}
	public void setOrder_product_count(int order_product_count) {
		this.order_product_count = order_product_count;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getUsers_no() {
		return users_no;
	}
	public void setUsers_no(String users_no) {
		this.users_no = users_no;
	}
	
	public String getUsers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", product_no=" + product_no + ", product_name=" + product_name
				+ ", order_product_count=" + order_product_count + ", order_date=" + order_date + ", users_no="
				+ users_no + ", users_name=" + users_name + ", order_product_price=" + order_product_price + "]";
	}
	
	
	
	
	
}
