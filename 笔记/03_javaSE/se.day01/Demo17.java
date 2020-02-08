package day01;
/**
 * StringBuilder API 演示 
 */
public class Demo17 {
	public static void main(String[] args) {
		StringBuilder buf=
				new StringBuilder();
		buf.append("李洪鹤老师...");
		buf.insert(0, "那一年");
		buf.replace(4, 4+2, "某人");
		buf.delete(6, 6+2);
		String s = buf.toString();
		System.out.println(s); 
	}
}





