package top.gisgo.shop.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import top.gisgo.shop.dao.CategoryDaoImpl;
import top.gisgo.shop.models.Category;

@Controller
public class CategoryController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	CategoryDaoImpl categoryDaoImpl = (CategoryDaoImpl) context.getBean("categoryDaoImpl");

	@RequestMapping("admin/addCategory")
	public String addCategory(@ModelAttribute Category category) {

		boolean boo = categoryDaoImpl.add(category);
		System.out.println("添加分类是否成功："+boo);
		return "redirect:success.jsp";
	}

	@RequestMapping(value = "admin/queryAllCategory", produces = "text/html;charset=UTF-8")
	public void queryAllCategory(HttpServletResponse response) throws IOException {

		List<Category> categorys = categoryDaoImpl.queryAll();
		String json = JSON.toJSONString(categorys);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
		System.out.println(json);
	}
}
