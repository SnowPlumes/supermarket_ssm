package me.lv.market.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.lv.market.pojo.OrderItems;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:springmvc.xml" })
public class TestOrderItemsDao {

	@Autowired
	private OrderItemsDao orderItemsDao;

	@Test
	public void testSelectOrderItems() {
		List<OrderItems> orderItemses = orderItemsDao.selectOrderItems();
		for (OrderItems orderItems : orderItemses) {
			System.out.println(orderItems);
			System.out.println(orderItems.getGoods());
		}
	}

}
