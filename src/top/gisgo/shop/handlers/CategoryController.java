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

import top.gisgo.shop.dao.CategoryDaoImpl;
import top.gisgo.shop.models.Category;

@Controller
public class CategoryController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	CategoryDaoImpl categoryDaoImpl = (CategoryDaoImpl) context.getBean("categoryDaoImpl");

	@RequestMapping("/addCategory")
	public String addCategory(@RequestParam("imgFile") MultipartFile file,HttpServletRequest request,@ModelAttribute Category category) {
		
//      鑾峰彇婧愭枃浠剁殑鏂囦欢鍚�
        String fileName = file.getOriginalFilename();
        
//      鑾峰緱绯荤粺鏃堕棿浣滀负鍚嶅瓧鍓嶇紑
        Date day=new Date();    
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");     
        String imgname=df.format(day)+ fileName;

        String path=request.getSession().getServletContext().getRealPath("") ;
        System.out.println(path);
//      鍒涘缓鐩爣鏂囦欢锛屽埗瀹氭枃浠跺瓨鍌ㄨ矾寰勫拰鏂囦欢鍚�
        
        String p=new File(path).getParent()+"\\imgs\\category\\";
        System.out.println(p);
        File targetFile = new File(p+imgname);
        
        if(fileName!=null&&fileName.length()>0){
            try {
//              灏嗘簮鏂囦欢杞Щ鍒扮洰鏍囨枃浠讹紝浣跨敤transferTo鏂规硶
                file.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        category.setImgUrl("http://localhost:8080/imgs/category/"+imgname);
		boolean boo = categoryDaoImpl.add(category);
		System.out.println("添加分类是否成功："+boo);
		return "redirect:../admin/category.html";
	}
	
	
	@RequestMapping(value = "/queryAllCategory", produces = "text/html;charset=UTF-8")
	public void queryAllCategory(HttpServletResponse response) throws IOException {

		List<Category> categorys = categoryDaoImpl.queryAll();
		String json = JSON.toJSONString(categorys);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
		System.out.println(json);
	}
}
