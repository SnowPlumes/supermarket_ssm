package me.lv.market.pojo;

public class GoodsType {
	private int id;
	private String name;
	private SubType subType;

	public GoodsType() {
		super();
	}

	public GoodsType(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SubType getSubType() {
		return subType;
	}

	public void setSubType(SubType subType) {
		this.subType = subType;
	}

	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", name=" + name + "]";
	}

}
