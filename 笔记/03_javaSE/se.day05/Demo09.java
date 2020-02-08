package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试 key对象的 equals 和 hashCode 
 * 对HashMap的影响 
 */
public class Demo09 {
	public static void main(String[] args) {
		//key对象类型如果不重写equals hashCode
		//将对象map集合产生严重影响，照成map
		//工作异常
		Map<Key,String> map =
			new HashMap<Key, String>();
		//没有重新hashCode和equals会出现重复添加
		map.put(new Key(1, "老师"), 
				"范传奇，王克晶，李洪鹤");
		map.put(new Key(1, "老师"), 
				"范老师，王老师，李老师");
		System.out.println(map); 
		//没有重新hashCode和equals会出现查询失败
		String val = 
				map.get(new Key(1, "老师"));
		System.out.println(val); 
		
	 
		
	}
}
class Key{
	int id;
	String name;
	public Key(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		return "Key [id=" + id + ", name=" + name + "]";
	}
}
