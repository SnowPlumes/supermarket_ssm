package me.lv.market.dao;

import java.util.List;

import me.lv.market.pojo.Order;

public interface OrderDao {
	List<Order> selectOrders();

	Order getOrderByNum(String orderNum);

	int updateOrder(Order order);
}
