package top.gisgo.shop.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import top.gisgo.shop.models.Administrator;

public class AdministratorDaoImpl implements AdministratorDao {
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject; 
	
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	@Override
	public void addAdministrator(Administrator administrator) {
		String SQL = "insert into administrator (phone, password,name) values (?, ?, ?)";     
		System.out.println(administrator.getName());
	      jdbcTemplateObject.update(SQL, administrator.getPhone(), administrator.getPassword(),administrator.getName());
	      System.out.println("注册成功");
	      return;
	}

	@Override
	public Administrator getAdministratorByPhone(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator doLogin(String phone, String password) {
		// TODO Auto-generated method stub
		Administrator administrator;
		String sql="select * from administrator where phone='"
				+ phone
				+ "'and password='"
				+ password
				+ "'";
		RowMapper<Administrator> rowMapper=new BeanPropertyRowMapper<>(Administrator.class);
		try {
		 administrator = jdbcTemplateObject.queryForObject(sql, rowMapper);
			
		}catch(Exception e) {
			administrator=null;
		}
		
		return administrator;
	}

}
