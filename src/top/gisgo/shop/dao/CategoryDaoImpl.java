package top.gisgo.shop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

		String sql="select * from category where id="+id;
		
		List<Category>category;
		try {
			category = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
			
		}catch(Exception e) {
			return null;
		}
		System.out.println("分类信息："+category.get(0));
		return category.get(0);
	
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
			category.setImgUrl(rs.getString(3));
			category.setDescription(rs.getString(4));
			categorys.add(category);
		}
		return categorys;
	}

	@Override
	public boolean add(Category category) {

		String SQL = "insert into category (name, imgUrl,description) values (?, ?,?)";     
		System.out.println(category.getName());
		int i=jdbcTemplateObject.update(SQL, category.getName(),category.getImgUrl(),category.getDescription());
	    if(i==1) {
	    	System.out.println("插入分类成功"+category);
	    	 return true;
	    }else {
	    	System.out.println("插入失败");
	    	 return false;
	    }

	}

}
