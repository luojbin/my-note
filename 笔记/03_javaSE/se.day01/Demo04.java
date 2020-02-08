package day01;

/**
 * 字符串中的封装了一个字符数组，每个
 * 元素是char类型的数据  
 */
public class Demo04 {
	public static void main(String[] args) {
		String s = "Tom and Jerry";
		//charAt 方法用于获取字符串中指定
		//索引位置上的字符
		//每个字符都是unicode，占用2个字节
		char c=s.charAt(4);
		System.out.println(c);//a
		System.out.println((int)c);//97
	}

}

