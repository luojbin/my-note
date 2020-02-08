package day12;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析XML文档
 * @author adminitartor
 *
 */
public class ParseXMLDemo {
	public static void main(String[] args) {
		try {
			/*
			 * 解析XML的大致步骤:
			 * 1:创建SAXReader
			 * 2:读取要解析的XML文档并生成
			 *   Document对象。
			 *   这一步就是DOM解析耗时耗资源的
			 *   地方了，因为需要将XML文档都读取
			 *   完毕并载入内存
			 * 3:通过Document对象获取根元素
			 * 4:按照XML文档的结构从根元素开始
			 *   逐级获取子元素以达到遍历XML文档
			 *   数据的目的  
			 */
			//1
			SAXReader reader = new SAXReader();
			
			//2
			Document document 
				= reader.read(new File("emplist.xml"));
//			reader.read(new FileInputStream("emplist.xml"));
			
			/*
			 * 3
			 * Document提供了获取根元素的方法
			 * Element getRootElement()
			 * 返回的Element实例表示XML文档的根元素
			 * 
			 * Element的每一个实例用于表示XML文档中的
			 * 一个元素(一对标签)
			 * 
			 * Element提供了用于获取其表示的标签的信息
			 * 的相关方法:
			 * String getName()
			 * 获取当前标签的名字
			 * 
			 * Element element(String name)
			 * 获取当前标签中指定名字的子标签
			 * 
			 * List elements()
			 * 获取当前标签中的所有子标签
			 * 
			 * List elements(String name)
			 * 获取当前标签中所有同名子标签
			 * 
			 * Attribute attribute(String name)
			 * 获取当前标签中指定名字的属性
			 * 
			 * String getText()
			 * 获取当前标签中间的文本数据
			 */
			Element root = document.getRootElement();
			
			/*
			 * 创建一个集合用于保存所有从
			 * XML文档中解析的员工信息
			 */
			List<Emp> empList = new ArrayList<Emp>();
			
			/*
			 * 获取根标签<list>中的所有<emp>标签
			 */
			List<Element> list = root.elements();
			for(Element empEle : list){
//				System.out.println(empEle.getName());
				
				//获取员工姓名
				Element nameEle = empEle.element("name");
				String name = nameEle.getText();
				System.out.println(name);
				
				Element ageEle = empEle.element("age");
				int age = Integer.parseInt(ageEle.getText());
				
				String gender = empEle.elementText("gender");
				
				int salary = Integer.parseInt(
					empEle.elementText("salary")	
				);
				/*
				 * Attribute的每一个实例用于表示一个属性
				 * 常用方法:
				 * String getName()
				 * String getValue()
				 */
				Attribute attr = empEle.attribute("id");
				int id = Integer.parseInt(attr.getValue());
				
				Emp emp = new Emp(id, name, age, gender, salary);
				empList.add(emp);
			}
			
			for(Emp e : empList){
				System.out.println(e);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




