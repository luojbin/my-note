package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * 自定义比较与自定义排序 
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		Product p1 = 
			new Product("新西兰空气", 5.9);
		Product p2 = 
			new Product("加勒比海海水", 6);
		Product p3 = 
			new Product("喜马拉雅山雪", 6);
		ByWeight byWeight = new ByWeight();
		int n1 = byWeight.compare(p1, p2);
		int n2 = byWeight.compare(p2, p1);
		int n3 = byWeight.compare(p2, p3);
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
	
		List<Product> list=
			new ArrayList<Product>();
		list.add(p3);
		list.add(p2);
		list.add(p1);
		list.add(new Product(
				"阿拉斯加的土", 2)); 
		//Java中的自定义排序
		//将集合中的元素按照给定的自定义比较器
		//的比较结果进行排序。
		Collections.sort(list, byWeight);
		System.out.println(list);
	}
}
/*
 * 按照商品重量进行自定义比较
 */
class ByWeight 
	implements Comparator<Product>{
	public int compare(
			Product o1, Product o2) {
		double val = o1.weight-o2.weight;
		if(val>0){return -1;}
		if(val<0){return 1;}
		return 0;
	}
}
class Product{ //产品
	String name;
	double weight;//重量
	public Product(
			String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	public String toString() {
		return "Product [name=" + name + ", weight=" + weight + "]";
	}
}