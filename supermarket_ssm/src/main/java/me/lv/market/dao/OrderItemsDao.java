package me.lv.market.dao;

import java.util.List;

import me.lv.market.pojo.OrderItems;

public interface OrderItemsDao {
	List<OrderItems> selectOrderItems();
}
