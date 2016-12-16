package me.lv.market.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lv.market.pojo.Goods;

public interface GoodsService {
	List<Goods> selectGoods();

	String chGoods(HttpServletRequest request, HttpServletResponse response);

	String deleteGoodsById(HttpServletRequest request, HttpServletResponse response);
}
