package me.lv.market.dao;

import me.lv.market.pojo.OrderStatus;

public interface OrderStatusDao {
	OrderStatus getOrderStatusById(int orderStatusId);
}
