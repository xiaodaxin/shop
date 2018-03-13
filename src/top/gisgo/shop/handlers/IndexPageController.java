package top.gisgo.shop.handlers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import top.gisgo.shop.dao.CategoryDaoImpl;
import top.gisgo.shop.dao.CommodityDaoImpl;
import top.gisgo.shop.dao.StoreDaoImpl;
import top.gisgo.shop.models.Category;
import top.gisgo.shop.models.Commodity;
import top.gisgo.shop.models.Store;

@Controller
public class IndexPageController {

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	CategoryDaoImpl categoryDaoImpl = (CategoryDaoImpl) context.getBean("categoryDaoImpl");
	StoreDaoImpl storeDaoImpl=(StoreDaoImpl) context.getBean("storeDaoImpl");
	CommodityDaoImpl commodityDaoImpl = (CommodityDaoImpl) context.getBean("commodityDaoImpl");
	
	@RequestMapping("/home")
	public ModelAndView index(HttpSession httpSession) {
		
		List<Category> categories=categoryDaoImpl.queryAll();
		Store store=storeDaoImpl.queryStore();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("categories",categories);
		httpSession.setAttribute("categories", categories);
		mv.addObject("store",store);
		httpSession.setAttribute("store", store);
		return mv;
	}
	
	@RequestMapping("/queryCommodityModelByCategoryId")
	public ModelAndView queryCommodityModelByCategoryId(int categoryId) {
		List<Commodity> commodities=commodityDaoImpl.queryCommodityByCategoryId(categoryId);
		Category category=categoryDaoImpl.queryById(categoryId);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("commodity");
		mv.addObject("commodities",commodities);
		mv.addObject("category",category);
		return mv;
		
	}
	
}
