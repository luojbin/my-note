package controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping("/ary.do")
	@ResponseBody
	//ResponseBody会自动的将返回结果中JavaBean转换
	//为JSON字符串发送到浏览器客户端, 底层用了
	// Jackson API
	public Object test(){
		String[] ary = {"李洪鹤","熊二","熊大"};
		return ary;
	}
	
	@RequestMapping("/bean.do")
	@ResponseBody
	//将JavaBean作为返回值,ResponseBody注解将Bean
	//转换为 Json 字符串发送到浏览器端
	public Object bean(){
		return new Foo(8,"Tom", 34.6);
	}
	
	@RequestMapping("/list.do")
	@ResponseBody
	public Object list(){
		List<Foo> list = new ArrayList<Foo>();
		list.add(new Foo(1, "Tom", 3.4));
		list.add(new Foo(2, "Jerry", 3.4));
		list.add(new Foo(3, "Andy", 3.5));
		list.add(new Foo(4, "Wang", 3.2));
		return list;
	}
	
	@RequestMapping("/map.do")
	@ResponseBody
	public Object map(){
		Map<String, Object> map = 
				new LinkedHashMap<String, Object>();
		map.put("age", 20);
		map.put("name", "Andy");
		map.put("price", 123.6);
		return map;
	}
}










