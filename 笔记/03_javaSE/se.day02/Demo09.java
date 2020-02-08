package day02;
/**
 * 拆分字符串数据 
 */
public class Demo09 {
	public static void main(String[] args) {
		String str = 
			"1, 李洪鹤, 110, lihh@tedu.cn, 北京";
		String[] data=str.split(",\\s*");
		System.out.println(data[1]); 
	}
}
