package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试使用查找表
 */
public class Demo06 {
	public static void main(String[] args) {
		//创建 map 类型的实例，声明key的类型
		//是String，被查找的Value的类型是Emp
		// 员工信息
		Map<String, Emp> employees =
			new HashMap<String, Emp>();
		//向map添加被查找的数据
		Emp val=employees.put("传奇", 
				new Emp(1, "范传奇"));
		System.out.println(val);
		val=employees.put("范传奇", 
				new Emp(1, "范冰冰"));
		System.out.println(val);
		//当Key相同时候，就发生了替换, 
		//返回值是被替换的原有数据
		val=employees.put("范传奇", 
				new Emp(1, "范传奇"));
		System.out.println(val);
		System.out.println(employees); 
		
		employees.put("克晶", 
				new Emp(2, "王克晶"));
		employees.put("王克晶", 
				new Emp(2, "王克晶"));
		System.out.println(employees);
		
		//调用get方法，利用关键字查找员工信息:
		Emp emp = employees.get("传奇");
		System.out.println(emp);
		//当关键字key对应的Value不存在时候
		//返回null，表示查找没有结果
		emp = employees.get("李洪鹤");
		System.out.println(emp);//null
		
		//containsKey检查 map 中是否包含指定的key
		boolean b = 
			employees.containsKey("克晶");
		System.out.println(b);
		b = employees.containsKey("洪鹤");
		System.out.println(b);
	}
}
class Emp{//员工类型
	int id;
	String name;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
}







