package me.lv.market.pojo;

public class GetAdress {
	private int id;
	private String adress;
	private String getName;
	private String getPhone;
	private Customer customer;

	public GetAdress() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getGetName() {
		return getName;
	}

	public void setGetName(String getName) {
		this.getName = getName;
	}

	public String getGetPhone() {
		return getPhone;
	}

	public void setGetPhone(String getPhone) {
		this.getPhone = getPhone;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "GetAdress [id=" + id + ", adress=" + adress + ", getName=" + getName + ", getPhone=" + getPhone + "]";
	}

}
