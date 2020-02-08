package day01;
/**
 * 
 * indexOf用于检索字符串中的字符位置
 */
public class Demo05 {
	public static void main(String[] args) {
		String s = "Tom and Jerry";
		//检索字符a的位置
		int i = s.indexOf('a'); 
		System.out.println(i);//4
		//检索字符串r的位置，找到第一个r的位置
		i = s.indexOf("r");
		System.out.println(i);//10
		//检索字符X的位置，没有找到返回-1
		i = s.indexOf('X');
		System.out.println(i);//-1
		//检索字符串and的开始位置
		i = s.indexOf("and");
		System.out.println(i);//?
	}

}
