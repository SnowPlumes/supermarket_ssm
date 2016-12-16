package me.lv.market.pojo;

public class Employee {
	private Integer id;
	private String eID;
	private String name;
	private String phone;
	private String email;
	private String password;
	private String isDelete;
	private EmployeeLimit employeeLimit;

	public Employee() {
		super();
	}

	public Employee(String eID, String name, String phone, String email, EmployeeLimit employeeLimit) {
		super();
		this.eID = eID;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.employeeLimit = employeeLimit;
	}

	public Employee(Integer id, String eID, String name, String phone, String email, String password, String isDelete,
			EmployeeLimit employeeLimit) {
		super();
		this.id = id;
		this.eID = eID;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.isDelete = isDelete;
		this.employeeLimit = employeeLimit;
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

	public String geteID() {
		return eID;
	}

	public void seteID(String eID) {
		this.eID = eID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsdelete() {
		return isDelete;
	}

	public void setIsdelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public EmployeeLimit getEmployeeLimit() {
		return employeeLimit;
	}

	public void setEmployeeLimit(EmployeeLimit employeeLimit) {
		this.employeeLimit = employeeLimit;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", eID=" + eID + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", isDelete=" + isDelete + "]";
	}

}
