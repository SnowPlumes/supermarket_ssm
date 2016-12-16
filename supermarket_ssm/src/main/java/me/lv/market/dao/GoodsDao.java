package me.lv.market.dao;

import java.util.List;

import me.lv.market.pojo.Goods;

public interface GoodsDao {
	Goods getGoodsById(int goodsId);

	Goods getGoodsByName(String goodsName);

	List<Goods> selectGoods();

	int updateGoods(Goods goods);

	int deleteGoodsById(int goodsId);

	int insertGoods(Goods goods);
}
