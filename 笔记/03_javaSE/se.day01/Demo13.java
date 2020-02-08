package day01;

/**
 * 检查一字符串是否以特定的字符串为开头或者结尾 
 */
public class Demo13 {
	public static void main(String[] args) {
		//检查一个文件名是否与 .jpg 为结尾
		//就是检查一个文件是否为 JPEG 图片
		String name = "demo.JPG";
		if(name.toLowerCase()
				.endsWith(".jpg")){
			System.out.println("图片文件");
		}
	}

}
