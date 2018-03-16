package top.gisgo.shop.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import top.gisgo.shop.dao.AdministratorDaoImpl;
import top.gisgo.shop.models.Administrator;

@Controller
public class AdministratorController {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	AdministratorDaoImpl administratorDaoImpl = (AdministratorDaoImpl) context.getBean("administratorDaoImpl");

	@RequestMapping("/login")
	public String login(@ModelAttribute Administrator administrator,HttpServletRequest request) {
		System.out.println(administratorDaoImpl.doLogin(administrator.getPhone(), administrator.getPassword()));
		
		request.getSession().setAttribute("user", administrator);
		return "redirect:../admin/index.html";
	}
}
