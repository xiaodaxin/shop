package top.gisgo.shop.handlers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import top.gisgo.shop.dao.CategoryDaoImpl;
import top.gisgo.shop.dao.StoreDaoImpl;
import top.gisgo.shop.models.Category;
import top.gisgo.shop.models.Store;

@Controller
public class IndexPageController {

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	CategoryDaoImpl categoryDaoImpl = (CategoryDaoImpl) context.getBean("categoryDaoImpl");
	StoreDaoImpl storeDaoImpl=(StoreDaoImpl) context.getBean("storeDaoImpl");
	
	@RequestMapping("/home")
	public ModelAndView index() {
		
		List<Category> categories=categoryDaoImpl.queryAll();
		Store store=storeDaoImpl.queryStore();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("categories",categories);
		mv.addObject("store",store);
		return mv;
	}
	
}
