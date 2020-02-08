package day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 利用key的集合变量map的内容 
 */
public class Demo10 {
	public static void main(String[] args) {
		Map<String, String> map = 
			new HashMap<String, String>();
		map.put("炸弹", "大王,小王");
		map.put("同花顺", "方块3, 方块4, 方块5, 方块6");
		map.put("拖拉机", "梅花5,红桃5,梅花6,红桃");
		//获取全部key的集合
		Set<String> keySet=map.keySet();
		System.out.println(keySet);
		//遍历集合中全部的Key
		for(String key:keySet){
			System.out.println(key);
			//在迭代期间可以利用get方法获取
			//value的值，性能没有问题
			System.out.println(map.get(key)); 
		}
		
		//利用Entry遍历Map集合
		//entrySet() 可以从map集合中获取全部
		// key:value 条目的集合，每个key:value
		// 对的对象类型是 Entry，而Entry类型上
		// 定义了getKey和getValue方法，可以获取
		// key:value对中的key和Value
		Set<Entry<String,String>> entries=
			map.entrySet();
		for(Entry<String, String> entry:entries){
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+":"+value);
		}
	}
}






