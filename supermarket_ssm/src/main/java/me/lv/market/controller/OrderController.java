package me.lv.market.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.lv.market.pojo.Order;
import me.lv.market.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/showOrders")
	public String showOrders(HttpServletRequest request, HttpServletResponse response) {
		List<Order> orders = orderService.selectOrders();
		request.setAttribute("orders", orders);
		return "orders";
	}

	@RequestMapping("/chip")
	public void ship(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int result = orderService.ship(request, response);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
	}

	@RequestMapping("/deleteOrder")
	public void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int result = orderService.deleteOrder(request, response);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
	}

}
