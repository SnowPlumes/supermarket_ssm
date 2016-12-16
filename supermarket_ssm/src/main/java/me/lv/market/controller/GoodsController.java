package me.lv.market.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.lv.market.dao.GoodsTypeDao;
import me.lv.market.pojo.Goods;
import me.lv.market.pojo.GoodsType;
import me.lv.market.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private GoodsTypeDao goodsTypeDao;

	@RequestMapping("/showGoods")
	public String showGoods(HttpServletRequest request, HttpServletResponse response) {
		List<Goods> goods = goodsService.selectGoods();
		List<GoodsType> goodsTypes = goodsTypeDao.selectGoodsTypes();
		request.setAttribute("goods", goods);
		request.setAttribute("goodsTypes", goodsTypes);
		return "goods";
	}

	@RequestMapping("/chGoods")
	public void chGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = goodsService.chGoods(request, response);
		PrintWriter out = response.getWriter();
		out.write(result);
		out.close();
	}

	@RequestMapping("/deleteGoods")
	public void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = goodsService.deleteGoodsById(request, response);
		PrintWriter out = response.getWriter();
		out.write(result);
		out.close();
	}

}
