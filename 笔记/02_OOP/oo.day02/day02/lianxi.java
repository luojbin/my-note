package week;
/**
 * ������ͱ��ʽ
 * @author Administrator
 *
 */
public class lianxi {
	
	public static void main(String[] args) {
		/*
		 * + - * / %
		 * 1.����������Ϊ����
		 *   ���������Ϊ������
		 *   ��������Ϊ������
		 * 2.%����õ��Ľ��ֻ������
		 * 
		 * ++ --
		 *   ++ -- ������֮ǰ���ȸ�ֵ��������
		 *   ++ -- ������֮�������㣬�ٸ�ֵ
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
		 * ��ϵ�����
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
