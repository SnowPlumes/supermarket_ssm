package me.lv.market.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.lv.market.pojo.GoodsType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:springmvc.xml" })
public class TestGoodsTypeDao {

	@Autowired
	private GoodsTypeDao goodsTypeDao;

	@Test
	public void testGetGoodsTypeById() {
		GoodsType goodsType = goodsTypeDao.getGoodsTypeById(1);
		System.out.println(goodsType);
		System.out.println(goodsType.getSubType());
	}

	@Test
	public void testGetGoodsTypeByName() {
		GoodsType goodsType = goodsTypeDao.getGoodsTypeByName("水果");
		System.out.println(goodsType);
		System.out.println(goodsType.getSubType());
	}

	@Test
	public void testSelectGoodsType() {
		List<GoodsType> goodsTypes = goodsTypeDao.selectGoodsTypes();
		for (GoodsType goodsType : goodsTypes) {
			System.out.println(goodsType);
		}
	}
}
