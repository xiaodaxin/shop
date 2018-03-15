package top.gisgo.shop.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import top.gisgo.shop.models.Commodity;

public class CommodityDaoImpl implements CommodityDao {
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject; 
	
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	@Override
	public void addCommodity(Commodity commodity) {

		String SQL = "insert into commodity (name, description,imgUrl,money,categoryId) values (?, ?, ?,?,?)";     
	
	    jdbcTemplateObject.update(SQL, commodity.getName(),commodity.getDescription(),commodity.getImgUrl(),commodity.getMoney(),commodity.getCategoryId());
	    System.out.println("娣诲姞鍟嗗搧鎴愬姛锛�"+commodity);
	}

	@Override
	public void deleteCommodityById(int id) {

		String sql ="delete from commodity where id="+id;
		jdbcTemplateObject.update(sql);
		System.out.println("----------删除成功-----------");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> queryCommodityByCategoryId(int categoryId) {

		String sql="select * from commodity where categoryid="+categoryId;
		
		@SuppressWarnings("rawtypes")
		List<Commodity> lists= jdbcTemplateObject.query(sql,new BeanPropertyRowMapper(Commodity.class));
		return lists;
		
	}

	@Override
	public Commodity queryCommodityById(int commodityId) {
		String sql="select * from commodity where id="+commodityId;
		List<Commodity> lists= jdbcTemplateObject.query(sql,new BeanPropertyRowMapper(Commodity.class));
		return lists.get(0);
	}
	
	@Override
	public void updateCommodity(Commodity commodity) {
		System.out.println(commodity);
		String sql="update commodity set name=?,description=?,money=? where id= ?";
		int i=jdbcTemplateObject.update(sql,commodity.getName(),commodity.getDescription(),commodity.getMoney(),commodity.getId());

		if(i>0) {
			System.out.println("update success!!");
		}else {
			System.out.println("update fail!!");
		}
	}

}
