package me.lv.market.pojo;

public class OrderStatus {
	private int id;
	private String status;

	public OrderStatus() {
		super();
	}

	public OrderStatus(int id) {
		super();
		this.id = id;
	}

	public OrderStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderStatus [id=" + id + ", status=" + status + "]";
	}

}
