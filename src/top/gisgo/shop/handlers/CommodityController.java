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
	
	// public static final String PATH="F://Program Files/apache-tomcat-9.0.2/webapps/imgs/";
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	CommodityDaoImpl commodityDaoImpl = (CommodityDaoImpl) context.getBean("commodityDaoImpl");
	
	/*
	 * 澧炲姞鍟嗗搧
	 * 
	 */
	@RequestMapping("/addCommodity")
	public String addCommodity(@RequestParam("imgFile") MultipartFile file,HttpServletRequest request,@ModelAttribute Commodity commodity) {
		
//      鑾峰彇婧愭枃浠剁殑鏂囦欢鍚�
        String fileName = file.getOriginalFilename();
        
//      鑾峰緱绯荤粺鏃堕棿浣滀负鍚嶅瓧鍓嶇紑
        Date day=new Date();    
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");     
        String imgname=df.format(day)+ fileName;

        String path=request.getSession().getServletContext().getRealPath("/")+"imgs\\" ;
        System.out.println(path);
//      鍒涘缓鐩爣鏂囦欢锛屽埗瀹氭枃浠跺瓨鍌ㄨ矾寰勫拰鏂囦欢鍚�
        File targetFile = new File(path+imgname);
        
        if(fileName!=null&&fileName.length()>0){
            try {
//              灏嗘簮鏂囦欢杞Щ鍒扮洰鏍囨枃浠讹紝浣跨敤transferTo鏂规硶
                file.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        commodity.setImgUrl("http://localhost:8080/shop/imgs/"+imgname);
        commodityDaoImpl.addCommodity(commodity);
        return "redirect:../admin/add.html";		
	}
	
	/*
	 *閫氳繃鍟嗗搧ID鍒犻櫎鍟嗗搧 
	 */
	@RequestMapping("/deleteCommodityById")
	public void deleteCommodityById(int id,HttpServletResponse response) throws IOException {
		commodityDaoImpl.deleteCommodityById(id);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("true");
	}
	
	/**
	 * 
	 * 通过种类ID查找商品
	 * **/
	@RequestMapping("/queryCommodityByCategoryId")
	public void queryCommodityByCategoryId(int categoryId,HttpServletResponse response) throws IOException {
		List<Commodity> commodities=commodityDaoImpl.queryCommodityByCategoryId(categoryId);
		String json =JSON.toJSONString(commodities);
		System.out.println(json);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

}
