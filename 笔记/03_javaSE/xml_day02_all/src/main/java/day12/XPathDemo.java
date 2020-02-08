package day12;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用XPATH获取XML文档数据
 * @author adminitartor
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document document 
				= reader.read(new File("myemp.xml"));
			
			String path = "/list/emp[salary>4000 and gender='女']/name";
			/*
			 * 使用xpath获取选取的内容
			 */
			List<Element> list = document.selectNodes(path);
			for(Element e : list){
				System.out.println(e.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




