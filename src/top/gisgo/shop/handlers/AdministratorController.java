package top.gisgo.shop.handlers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.gisgo.shop.dao.AdministratorDaoImpl;

@Controller
public class AdministratorController {

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	AdministratorDaoImpl administratorDaoImpl = (AdministratorDaoImpl) context.getBean("administratorDaoImpl");

	@RequestMapping("admin/login")
	public String login(String phone, String password) {
		System.out.println(administratorDaoImpl.doLogin(phone, password));
		
		return "redirect:success.jsp";
	}
}
