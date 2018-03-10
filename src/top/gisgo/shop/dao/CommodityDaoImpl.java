package top.gisgo.shop.dao;

import java.util.List;

import javax.sql.DataSource;

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
	    System.out.println("添加商品成功："+commodity);
	}

	@Override
	public void deleteCommodityById(int id) {

		String sql ="delete from commodity where id="+id;
		jdbcTemplateObject.update(sql);
		System.out.println("----------删除商品成功-----------");
	}

	@Override
	public List<Commodity> queryCommodityByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commodity queryCommodityById(int commodityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
