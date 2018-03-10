package top.gisgo.shop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import top.gisgo.shop.models.Category;

public class CategoryDaoImpl implements CategoryDao {
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject; 
	
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	@Override
	public Category queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> queryAll() {
		
		String sql="select * from category";
		SqlRowSet rs=jdbcTemplateObject.queryForRowSet(sql);
		
		List<Category> categorys=new ArrayList<>();
		
		while(rs.next()) {
			
			Category category=new Category();
			category.setId(rs.getInt(1));
			category.setName(rs.getString(2));
			category.setTitle(rs.getString(3));
			categorys.add(category);
		}
		
		return categorys;
	}

	@Override
	public boolean add(Category category) {

		String SQL = "insert into category (name, title) values (?, ?)";     
		System.out.println(category.getName());
		int i=jdbcTemplateObject.update(SQL, category.getName(),category.getTitle());
	    if(i==1) {
	    	System.out.println("插入成功"+i);
	    	 return true;
	    }else {
	    	System.out.println("插入失败");
	    	 return false;
	    }

	}

}
