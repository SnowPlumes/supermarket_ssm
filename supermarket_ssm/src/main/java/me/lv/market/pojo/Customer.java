package me.lv.market.pojo;

import java.util.List;

public class Customer {
	private int id;
	private String username;
	private String nickname;
	private String sex;
	private String email;
	private String phone;
	private String isdelete;
	private List<Order> orders;
	private CustomerLogin customerLogin;
	private GetAdress getAdress;

	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public CustomerLogin getCustomerLogin() {
		return customerLogin;
	}

	public void setCustomerLogin(CustomerLogin customerLogin) {
		this.customerLogin = customerLogin;
	}

	public GetAdress getGetAdress() {
		return getAdress;
	}

	public void setGetAdress(GetAdress getAdress) {
		this.getAdress = getAdress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", nickname=" + nickname + ", sex=" + sex + ", email="
				+ email + ", phone=" + phone + ", isdelete=" + isdelete + "]";
	}

}
