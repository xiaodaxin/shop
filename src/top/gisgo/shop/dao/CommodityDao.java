package top.gisgo.shop.dao;

import java.util.List;

import top.gisgo.shop.models.Commodity;

public interface CommodityDao {
	
	public void addCommodity(Commodity commodity);
	public void deleteCommodityById(int id);
	public List<Commodity> queryCommodityByCategoryId(int categoryId);
	public Commodity queryCommodityById(int commodityId);
	public void updateCommodity(Commodity commodity);
}
