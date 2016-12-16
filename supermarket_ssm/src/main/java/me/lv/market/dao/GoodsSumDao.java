package me.lv.market.dao;

import me.lv.market.pojo.GoodsSum;

public interface GoodsSumDao {
	GoodsSum getGoodsSumById(int goodsId);

	int updateGoodsSum(GoodsSum goodsSum);

	int insertSum(GoodsSum goodsSum);
}
