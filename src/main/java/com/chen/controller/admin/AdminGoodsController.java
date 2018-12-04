package com.chen.controller.admin;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.pojo.Goods;
import com.chen.service.GoodsServiceImpl;

@Controller
@RequestMapping("/adminGood")
public class AdminGoodsController {

	@Autowired
	private GoodsServiceImpl goodsServiceImpl;
	
	/**
	 * 查询商品列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		List<Goods> listgoods=goodsServiceImpl.getAll();
		request.getSession().setAttribute("listgoods", listgoods);
		return "admin/goodsList";
	}
	
	/**
	 * 搜索
	 * @return
	 */
	@RequestMapping("/fuzzy")
	public String fuzzy(HttpServletRequest request){
		String goods=request.getParameter("goods");
		List<Goods> listgoods=goodsServiceImpl.getGoodByName("%"+goods+"%");
		request.getSession().setAttribute("listgoods", listgoods);
		return "admin/goodsList";
	}
	
	
	/**
	 * 根据id删除
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/del")
	public String del(HttpServletRequest request) throws UnsupportedEncodingException{
		
		String id=request.getParameter("id");
//		id=new String(id.getBytes("ISO-8859-1"),"UTF-8");
		Goods goods=new Goods();
		goods.setId(id);
		int result=goodsServiceImpl.delete(goods);
		if(result==1){
			request.setAttribute("success", "删除成功！");
			return "redirect:/adminGood/list";
		}else{
			request.setAttribute("error", "删除失败！");
			return "redirect:/adminGood/list";
		}
	}
	
	
	@RequestMapping("/updateGoods")
	public String updateGoods(HttpServletRequest request){
		String id=request.getParameter("id");
		Goods goods = new Goods();
		goods.setId(id);
		List<Goods> listgoods=goodsServiceImpl.getGoodById(goods);
		request.getSession().setAttribute("adminGood", listgoods.get(0));
		return "admin/updateGoods";
	}
	
	
	@RequestMapping("/insertGoods")
	public String insertGoods(HttpServletRequest request){
		return "admin/insertGoods";
	}
	
	
	/**
	 * 修改商品
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/update")
	public String update(HttpServletRequest request) throws UnsupportedEncodingException{
		
		String id=request.getParameter("id");
	  	String name=request.getParameter("name");
//	  	name=new String(name.getBytes("ISO-8859-1"),"utf-8");
	  	String price=request.getParameter("price");
	  	String stock=request.getParameter("stock");
	  	String img1=request.getParameter("img1");
	  	String img2=request.getParameter("img2");
	  	String img3=request.getParameter("img3");
	  	String img4=request.getParameter("img4");
	  	Goods goods=new Goods();
	  	goods.setId(id);
	  	goods.setName(name);
	  	goods.setPrice(Double.parseDouble(price));
	  	goods.setStock(Integer.parseInt(stock));
	  	goods.setImg1(img1);
	  	goods.setImg2(img2);
	  	goods.setImg3(img3);
	  	goods.setImg4(img4);
		int result=goodsServiceImpl.update(goods);
		if(result==1){
			request.setAttribute("success", "修改信息成功！");
			return "redirect:/adminGood/list";
	    }else{
	    	request.setAttribute("error", "修改信息失败！");
	    	return "redirect:/adminGood/list";
		}
	}
	
	/**
	 * 添加商品
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request){
		//上传文件的服务器端存储路径
		String uploadFilePath=request.getSession().getServletContext().getRealPath("img/");
		//获得文件的工厂类
		FileItemFactory factory=new DiskFileItemFactory();
		//通过工厂类创建一个Servelet文件上传类
		ServletFileUpload upload=new ServletFileUpload(factory);
		//把请求中的数据读取出来，并且封装成FileItem对象，然后存入List集合
		try {
			List<FileItem> items=upload.parseRequest(request);
			Goods goods=new Goods();
			for(FileItem item:items){
				if(item.isFormField()){
					if (item.getFieldName().equals("id")) {
						goods.setId(item.getString("utf-8"));
					}
					if(item.getFieldName().equals("name")){
						goods.setName(item.getString("utf-8"));
					}
					if(item.getFieldName().equals("price")){
						goods.setPrice(Double.parseDouble(item.getString("utf-8")));
					}
					if(item.getFieldName().equals("stock")){
						goods.setStock(Integer.parseInt(item.getString("utf-8")));
					}
				}else{
					String fileName=item.getName();
					if(item.getFieldName().equals("img1")){
						goods.setImg1(fileName);
					}
					if(item.getFieldName().equals("img2")){
						goods.setImg2(fileName);
					}
					if(item.getFieldName().equals("img3")){
						goods.setImg3(fileName);
					}
					if(item.getFieldName().equals("img4")){
						goods.setImg4(fileName);
					}
					if(fileName!=null&& !fileName.equals("")){
						File fullFile=new File(fileName);
						File saveFile=new File(uploadFilePath,fullFile.getName());
						item.write(saveFile);
					}
				}
			}

			int result=goodsServiceImpl.insert(goods);
			if(result==1){
				request.setAttribute("success", "添加商品成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/adminGood/list";
	}
	
}
