package top.gisgo.shop.dao;

import java.util.List;

import top.gisgo.shop.models.Category;

public interface  CategoryDao {
	
	public Category queryById(int id);
	public List<Category> queryAll();
	public boolean add(Category category);
}
