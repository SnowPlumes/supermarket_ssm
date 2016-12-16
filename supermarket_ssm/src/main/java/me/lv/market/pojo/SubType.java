package me.lv.market.pojo;

import java.util.List;

public class SubType {
	private int id;
	private String name;
	private List<GoodsType> goodsTypes;

	public SubType() {
		super();
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

	public List<GoodsType> getGoodsTypes() {
		return goodsTypes;
	}

	public void setGoodsTypes(List<GoodsType> goodsTypes) {
		this.goodsTypes = goodsTypes;
	}

	@Override
	public String toString() {
		return "SubType [id=" + id + ", name=" + name + "]";
	}

}
