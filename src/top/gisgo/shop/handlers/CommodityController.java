package top.gisgo.shop.handlers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping("admin/addCommodity")
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
        return "redirect:success.jsp";		
	}
	
	/*
	 *通过商品ID删除商品 
	 */
	@RequestMapping("admin/deleteCommodityById")
	public void deleteCommodityById(int id) {
		commodityDaoImpl.deleteCommodityById(id);
	}

}
