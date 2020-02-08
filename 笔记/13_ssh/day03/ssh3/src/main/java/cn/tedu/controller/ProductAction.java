package cn.tedu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.tedu.entity.Product;
import cn.tedu.service.ProductService;

@Controller
@Scope("prototype")
public class ProductAction {
	
	@Resource
	private ProductService productService;
	
	private List<Product> products;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//控制器方法
	public String list(){
		name = "list";
		products = productService.getProducts();
		
		ActionContext context = 
				ActionContext.getContext();
		context.getSession().put(
			"loginUser", "老王");
		
		return "success";
	}
}









