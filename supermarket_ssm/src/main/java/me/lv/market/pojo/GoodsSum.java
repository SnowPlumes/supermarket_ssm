package me.lv.market.pojo;

public class GoodsSum {
	private int id;
	private int sum;
	private Goods goods;

	public GoodsSum() {
		super();
	}

	public GoodsSum(int sum) {
		super();
		this.sum = sum;
	}

	public GoodsSum(int sum, Goods goods) {
		super();
		this.sum = sum;
		this.goods = goods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "GoodsSum [id=" + id + ", sum=" + sum + "]";
	}

}
