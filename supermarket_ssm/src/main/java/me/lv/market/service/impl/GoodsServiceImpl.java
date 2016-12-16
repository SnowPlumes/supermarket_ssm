package me.lv.market.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.lv.market.dao.GoodsDao;
import me.lv.market.dao.GoodsSumDao;
import me.lv.market.dao.GoodsTypeDao;
import me.lv.market.pojo.Goods;
import me.lv.market.pojo.GoodsSum;
import me.lv.market.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private GoodsSumDao goodsSumDao;

	@Autowired
	private GoodsTypeDao goodsTypeDao;

	public List<Goods> selectGoods() {
		return goodsDao.selectGoods();
	}

	@Transactional
	public String chGoods(HttpServletRequest request, HttpServletResponse response) {
		double goodsPrice;
		double goodsDiscount;
		int goodsSum;
		int goodsExpiryDate;
		try {
			goodsPrice = Double.parseDouble(request.getParameter("goodsPrice"));
			goodsDiscount = Double.parseDouble(request.getParameter("goodsDiscount"));
			goodsSum = Integer.parseInt(request.getParameter("goodsSum"));
			goodsExpiryDate = Integer.parseInt(request.getParameter("goodsExpiryDate"));
		} catch (NumberFormatException e) {
			return "error";
		}
		String goodsName = request.getParameter("goodsName");
		String goodsType = request.getParameter("goodsType");
		String goodsCreatDate = request.getParameter("goodsCreatDate");
		String goodsProducer = request.getParameter("goodsProducer");
		String goodsSize = request.getParameter("goodsSize");

		Goods goods = goodsDao.getGoodsByName(goodsName);

		if (goods != null) {
			updateGoods(goodsPrice, goodsDiscount, goodsSum, goodsSize, goods);
			return "update";
		} else {
			insertGoods(goodsPrice, goodsDiscount, goodsSum, goodsExpiryDate, goodsName, goodsType, goodsCreatDate,
					goodsProducer, goodsSize);
			return "insert";
		}
	}

	private void insertGoods(double goodsPrice, double goodsDiscount, int goodsSum, int goodsExpiryDate,
			String goodsName, String goodsType, String goodsCreatDate, String goodsProducer, String goodsSize) {
		Goods goods = new Goods(goodsName, goodsPrice, goodsDiscount, goodsCreatDate, goodsExpiryDate, goodsProducer,
				goodsSize);
		goods.setGoodsType(goodsTypeDao.getGoodsTypeByName(goodsType));
		goodsDao.insertGoods(goods);
		goods = goodsDao.getGoodsByName(goodsName);
		GoodsSum sum = new GoodsSum(goodsSum, goods);
		goodsSumDao.insertSum(sum);
	}

	private void updateGoods(double goodsPrice, double goodsDiscount, int goodsSum, String goodsSize, Goods goods) {
		goods.setPrice(goodsPrice);
		goods.setDiscount(goodsDiscount);
		goods.setSize(goodsSize);
		goodsDao.updateGoods(goods);
		GoodsSum sum = new GoodsSum(goodsSum, goods);
		goodsSumDao.updateGoodsSum(sum);
	}

	public String deleteGoodsById(HttpServletRequest request, HttpServletResponse response) {
		String GoodsId = request.getParameter("id");
		goodsDao.deleteGoodsById(Integer.parseInt(GoodsId));
		return "success";
	}

}
