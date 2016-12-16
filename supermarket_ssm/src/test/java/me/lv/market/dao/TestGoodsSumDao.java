package me.lv.market.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.lv.market.pojo.Goods;
import me.lv.market.pojo.GoodsSum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:springmvc.xml" })
public class TestGoodsSumDao {

	@Autowired
	private GoodsSumDao goodsSumDao;

	@Test
	public void testGetGoodsSumById() {
		GoodsSum goodsSum = goodsSumDao.getGoodsSumById(1);
		System.out.println(goodsSum);
	}

	@Test
	public void testUpdateGoodsSum() {
		Goods goods = new Goods();
		goods.setId(1);
		GoodsSum goodsSum = new GoodsSum();
		goodsSum.setGoods(goods);
		goodsSum.setSum(15);
		goodsSumDao.updateGoodsSum(goodsSum);
	}

	@Test
	public void testInsertGoodsSum() {
		Goods goods = new Goods();
		goods.setId(3);
		GoodsSum goodsSum = new GoodsSum(12, goods);
		goodsSumDao.insertSum(goodsSum);
	}

}
