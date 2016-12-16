package me.lv.market.pojo;

public class CustomerLogin {
	private int id;
	private String password;
	private Customer customer;

	public CustomerLogin() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerLogin [id=" + id + ", password=" + password + "]";
	}

}
