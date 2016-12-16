package me.lv.market.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.lv.market.pojo.Order;
import me.lv.market.pojo.OrderStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:springmvc.xml" })
public class TestOrderDao {

	@Autowired
	private OrderDao orderDao;

	@Test
	public void testSelectOrders() {
		List<Order> orders = orderDao.selectOrders();
		for (Order order : orders) {
			System.out.println(order);
			System.out.println(order.getCustomer());
			System.out.println(order.getCustomer().getGetAdress());
			System.out.println(order.getOrderStatus());
		}
	}

	@Test
	public void testGetOrderByNum() {
		Order order = orderDao.getOrderByNum("asd123");
		System.out.println(order);
		System.out.println(order.getCustomer());
		System.out.println(order.getCustomer().getGetAdress());
		System.out.println(order.getOrderStatus());
	}

	@Test
	public void testUpdateOrder() {
		Order order = new Order();
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setId(1);
		order.setIsdelete("Y");
		order.setOrderNum("asd123");
		order.setOrderStatus(orderStatus);
		int result = orderDao.updateOrder(order);
		System.out.println(result);
	}

}
