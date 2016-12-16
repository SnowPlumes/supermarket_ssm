package me.lv.market.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.lv.market.pojo.Goods;
import me.lv.market.pojo.GoodsType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:springmvc.xml" })
public class TestGoodsDao {

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private GoodsTypeDao goodsTypeDao;

	@Test
	public void testGetGoodsById() {
		Goods goods = goodsDao.getGoodsById(1);
		System.out.println(goods);
		System.out.println(goods.getGoodsType());
		System.out.println(goods.getGoodsType().getSubType());
		System.out.println(goods.getGoodsSum());
	}

	@Test
	public void testGetGoodsByName() {
		Goods goods = goodsDao.getGoodsByName("苹果");
		System.out.println(goods);
	}

	@Test
	public void testUpdateGoods() {
		Goods goods = goodsDao.getGoodsById(1);
		goods.setPrice(16);
		goods.setDiscount(9);
		goodsDao.updateGoods(goods);
	}

	@Test
	public void testInsertGoods() {
		Goods goods = new Goods("羽绒服", 300, 256, "2016-12-16", 100, "服装厂", "S,M,L");
		GoodsType goodsType = goodsTypeDao.getGoodsTypeById(2);
		goods.setGoodsType(goodsType);
		goodsDao.insertGoods(goods);
	}

}
