package day05;
/**
 * Java 中如何比较两个对象的大小 
 */
public class Demo01 {
	public static void main(String[] args) {
		String s1 = "田";//30000
		String s2 = "中";//20013
		String s3 = "abcd";
		int n1 = s1.compareTo(s2);
		int n2 = s2.compareTo(s1);
		int n3 = s1.compareTo(s3); 
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		
	}

}
