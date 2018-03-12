package top.gisgo.shop.handlers;

import java.io.IOException;

import javax.servlet.ServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import top.gisgo.shop.dao.StoreDaoImpl;
import top.gisgo.shop.models.Store;

@Controller
public class StoreController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	StoreDaoImpl storeDaoImpl = (StoreDaoImpl) context.getBean("storeDaoImpl");
	
	@RequestMapping("/updateStore")
	public String updateStore(@ModelAttribute Store store){
		
		storeDaoImpl.update(store);
		
		return "redirect:../admin/store.html";
	}
	
	
	@RequestMapping("/queryStore")
	public void queryStore(ServletResponse response) throws IOException {
		
		Store store=storeDaoImpl.queryStore();
		String json=JSON.toJSONString(store);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

}
