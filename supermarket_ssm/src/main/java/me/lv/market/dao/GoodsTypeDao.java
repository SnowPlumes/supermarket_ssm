package me.lv.market.dao;

import java.util.List;

import me.lv.market.pojo.GoodsType;

public interface GoodsTypeDao {
	GoodsType getGoodsTypeById(int goodsTypeId);

	GoodsType getGoodsTypeByName(String goodsTypeName);

	List<GoodsType> selectGoodsTypes();
}
