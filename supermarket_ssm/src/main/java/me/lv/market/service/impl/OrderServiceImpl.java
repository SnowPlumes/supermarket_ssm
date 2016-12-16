package me.lv.market.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.lv.market.dao.OrderDao;
import me.lv.market.pojo.Order;
import me.lv.market.pojo.OrderStatus;
import me.lv.market.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	public List<Order> selectOrders() {
		return orderDao.selectOrders();
	}

	public int ship(HttpServletRequest request, HttpServletResponse response) {
		String orderNum = request.getParameter("orderNum");
		Order order = new Order();
		order.setOrderNum(orderNum);
		order.setOrderStatus(new OrderStatus(3));
		return orderDao.updateOrder(order);
	}

	public int deleteOrder(HttpServletRequest request, HttpServletResponse response) {
		String orderNum = request.getParameter("orderNum");
		Order order = new Order();
		order.setOrderNum(orderNum);
		order.setIsdelete("Y");
		return orderDao.updateOrder(order);
	}

}
