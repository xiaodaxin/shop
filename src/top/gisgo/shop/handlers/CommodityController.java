package top.gisgo.shop.handlers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import top.gisgo.shop.dao.CommodityDaoImpl;
import top.gisgo.shop.models.Commodity;

@Controller
public class CommodityController {
	
	public static final String PATH="F://Program Files/apache-tomcat-9.0.2/webapps/imgs/";
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	CommodityDaoImpl commodityDaoImpl = (CommodityDaoImpl) context.getBean("commodityDaoImpl");
	
	/*
	 * 增加商品
	 * 
	 */
	@RequestMapping("/addCommodity")
	public String addCommodity(@RequestParam("imgFile") MultipartFile file,HttpServletRequest request,@ModelAttribute Commodity commodity) {
		
//      获取源文件的文件名
        String fileName = file.getOriginalFilename();
        
//      获得系统时间作为名字前缀
        Date day=new Date();    
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");     
        String imgname=df.format(day)+ fileName;

//      创建目标文件，制定文件存储路径和文件名
        File targetFile = new File(PATH+imgname);
        
        if(fileName!=null&&fileName.length()>0){
            try {
//              将源文件转移到目标文件，使用transferTo方法
                file.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        commodity.setImgUrl("http://localhost:8080/imgs/"+imgname);
        commodityDaoImpl.addCommodity(commodity);
        return "redirect:../admin/add.html";		
	}
	
	/*
	 *通过商品ID删除商品 
	 */
	@RequestMapping("/deleteCommodityById")
	public void deleteCommodityById(int id) {
		commodityDaoImpl.deleteCommodityById(id);
	}
	
	
	@RequestMapping("/queryCommodityByCategoryId")
	public void queryCommodityByCategoryId(int id,HttpServletResponse response) throws IOException {
		List<Commodity> commodities=commodityDaoImpl.queryCommodityByCategoryId(id);
		String json =JSON.toJSONString(commodities);
		System.out.println(json);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

}
