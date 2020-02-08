package week;
/**
 * 运算符和表达式
 * @author Administrator
 *
 */
public class lianxi {
	
	public static void main(String[] args) {
		/*
		 * + - * / %
		 * 1.整数相除结果为整数
		 *   浮点数相除为浮点数
		 *   两个交错为浮点数
		 * 2.%运算得到的结果只是余数
		 * 
		 * ++ --
		 *   ++ -- 在数字之前，先赋值，再运算
		 *   ++ -- 在数字之后，先运算，再赋值
		 *   		
		 */
		
		//System.out.println(1/0);/// by zero
		//System.out.println(1.0/0);//Infinity
		/*int a=1,b=1,c=1,d=1;
		int result=0;
		//       1     1      3     1
		result = a++ + b++ + ++b +--a;
		System.out.println(result);//6
		//       1     3     1    1
		//       1     2     2   1
		result = a + --b + ++c + a--;
		System.out.println(result);//6
		//       0     1       2     0
		//       0     1       3     2
		result = a++ + d++ + ++c + ++a;
		System.out.println(result);//6 5 4
*/		
		/*
		 * 关系运算符
		 * 	> < >= <= == != 
		 *  || && !
		 */
		boolean res ;
		int a=1,b=1,c=1,d=1;
		
		res = a++>b-- && c--<d++;
		System.out.println(res);//false 2 0 1 1
		System.out.println(" a="+a+" b="+b+" c="+c+" d="+d);
		
		res = a++>b++ && ++c<d++;
		System.out.println(res);//false 3 1 2 2
		System.out.println(" a="+a+" b="+b+" c="+c+" d="+d);
		
		res = a++>b-- || c--<d++;
		System.out.println(res);//true 4 0 2 2
		System.out.println(" a="+a+" b="+b+" c="+c+" d="+d);
		
		res = a++>b-- || c--<d++;
		System.out.println(res);//true 5 -1 2 2 
		System.out.println(" a="+a+" b="+b+" c="+c+" d="+d);
		
	}
}
