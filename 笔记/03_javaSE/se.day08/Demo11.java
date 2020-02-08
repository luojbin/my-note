package day08;

/**
 * try catch finally 的规则 
 *
 */
public class Demo11 {
	public static void main(String[] args) {
		// y = println(test(x))
		System.out.println(test("5A")); 
		System.out.println(test(null)); 
		System.out.println(test("")); 
	}
	public static int test(String s){
		try{
			int n = s.charAt(0)-'0';
			return n;
		}catch(NullPointerException e){
			return -1;
		}catch (RuntimeException e) {
			return -2;
		}finally{//最终的，最终执行代码块
			//无论是否出现异常永远执行
			//用于执行回收资源：关闭文件等
			System.out.println("finally"); 
		}
	}
}





