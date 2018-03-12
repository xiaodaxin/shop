package top.gisgo.shop.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import top.gisgo.shop.models.Store;

public class StoreDaoImpl implements StoreDao {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject; 
	
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	@Override
	public void update(Store store) {
		// TODO Auto-generated method stub
		
		String sql="update store set title = ?,address=?,phone=?,description=?,boss=?";
		jdbcTemplateObject.update(sql, store.getTitle(),store.getAddress(),store.getPhone(),store.getDescription(),store.getBoss());
		System.out.println("成功修改商家信息："+store);
	}

	@Override
	public Store queryStore() {
		// TODO Auto-generated method stub
		String sql="select * from store";
		List<Store>stores;
		try {
			stores = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper<Store>(Store.class));
			
		}catch(Exception e) {
			return null;
		}
		System.out.println("商家信息："+stores.get(0));
		return stores.get(0);
	}
	
}
