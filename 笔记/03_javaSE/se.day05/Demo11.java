package day05;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo11 {

	public static void main(String[] args) {
//"海淀:180,顾家庄:100,香山:78,驻马店:120,石家庄:125,海淀:156,香山:298,海淀:356"
		
		//1. 解析字符串得到每个地点和其PM2.5值
		//2. 创建散列表 map
		//3. 遍历输入数据
		//4. 如果有地点，取出比较在存入
		//5. 如果没有地点，直接存入
		
		String pm25="海淀:180,顾家庄:100,香山:78,驻马店:120,石家庄:125,"
				+ "海淀:156,香山:298,海淀:356";
		String[] data = pm25.split("[,:]");
		System.out.println(Arrays.toString(data));
		Map<String, Integer> map=
				new LinkedHashMap<String, Integer>();
		for(int i=0; i<data.length; i+=2){
			String loc=data[i];
			String str=data[i+1];
			//System.out.println(loc);
			int val = Integer.parseInt(str);
			if(map.containsKey(loc)){
				int v = map.get(loc);
				if(val>v){
					map.put(loc, val);
				}
 			}else{
 				map.put(loc, val);
 			}
		}
		
		//查询
		int val = map.get("海淀");
		System.out.println(val);
		//输出全部结果？
	}
}







