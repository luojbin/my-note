package day01;
/**
 * 截取子字符串
 *	substring(start, end)
 */
public class Demo09 {
	public static void main(String[] args) {
		String url="http://tedu.cn/index.html";
		//从7开始截取到14为止（不包含14）
		String str1 = url.substring(7,14);
		//从7开始连续截取8个字符
		String str2 = url.substring(7,7+8);
		System.out.println(str1);
		System.out.println(str2);
	}

}
