package cn.tedu.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import cn.tedu.entity.Product;

@Service
public class ProductService {
	
	List<Product> products;
	
	@PostConstruct
	private void init(){
		products = new ArrayList<Product>();
		products.add(new Product(
			1,"大黄蜂",24.5,"变形金刚经典系列"));
		products.add(new Product(
			2,"擎天柱",88.5,"变形金刚经典系列"));
		products.add(new Product(
			3,"光头强",12.5,"大笨熊你粗来!"));
		products.add(new Product(
			4,"李老师",22.5,"胡说派诗人!"));
		products.add(new Product(
			5,"范传奇",23.5,"变形金刚消费者!"));
	}
	
	public List<Product> getProducts(){
		return products;
	}
}
