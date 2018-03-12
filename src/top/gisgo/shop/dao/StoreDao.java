package top.gisgo.shop.dao;

import top.gisgo.shop.models.Store;

public interface StoreDao {
	public void update(Store store);
	public Store queryStore();

}
