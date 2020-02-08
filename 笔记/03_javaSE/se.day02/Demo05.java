package day02;

/**
 * 检查一个文件是否为jpeg照片文件
 *  .jpg
 *  .jpeg 
 *  .png
 *  .gif
 */
public class Demo05 {
	public static void main(String[] args) {
		//String reg=".+\\.jpe?g";
		String reg=".+\\.(jpe?g|png|gif)";
		//正则表达式： .+\.(jpe?g|png|gif)
		//Java 字符串: .+\\.(jpe?g|png|gif)
		String file = "她.png";
		System.out.println(reg); 
		boolean b = file.matches(reg);
		System.out.println(b); 
		
	}
}





