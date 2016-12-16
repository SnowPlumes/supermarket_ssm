package me.lv.market.pojo;

public class EmployeeLimit {
	private Integer id;
	private String level;

	public EmployeeLimit() {
		super();
	}

	public EmployeeLimit(Integer id, String level) {
		super();
		this.id = id;
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "EmployeeLimit [id=" + id + ", level=" + level + "]";
	}

}
