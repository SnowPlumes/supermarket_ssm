package me.lv.market.pojo;

public class Goods {
	private int id;
	private String name;
	private String url;
	private double price;
	private double discount;
	private String creatDate;
	private int expiryDate;
	private String producer;
	private String desc;
	private String isdelete;
	private GoodsType goodsType;
	private String size;
	private GoodsSum goodsSum;

	public Goods() {
		super();
	}

	public Goods(String name, double price, double discount, String creatDate, int expiryDate, String producer,
			String size) {
		super();
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.creatDate = creatDate;
		this.expiryDate = expiryDate;
		this.producer = producer;
		this.size = size;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

	public int getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(int expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public GoodsSum getGoodsSum() {
		return goodsSum;
	}

	public void setGoodsSum(GoodsSum goodsSum) {
		this.goodsSum = goodsSum;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", url=" + url + ", price=" + price + ", discount=" + discount
				+ ", creatDate=" + creatDate + ", expiryDate=" + expiryDate + ", producer=" + producer + ", desc="
				+ desc + ", isdelete=" + isdelete + ", goodsType=" + goodsType + ", size=" + size + "]";
	}

}
