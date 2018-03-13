package top.gisgo.shop.dao;

import top.gisgo.shop.models.Administrator;

public interface AdministratorDao {
	public void addAdministrator(Administrator administrator);
	public Administrator getAdministratorByPhone(String phone); 
	public Administrator doLogin(String phone,String password);
}
