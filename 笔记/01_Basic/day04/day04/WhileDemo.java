package day04;
//while的演示
public class WhileDemo {
	public static void main(String[] args) {
		/*
		 * 练习:
		 * 1)输出10次"行动是成功的阶梯"
		 * 2)输出9的乘法表(正序1到9)
		 * 3)输出9的乘法表(倒序9到1)
		 * 4)输出9的乘法表(正序1/3/5/7/9)
		 *   
		 * 要求:
		 *   任选其二写执行过程
		 */
		
		
		
		
		/*
		int num=9;
		while(num>=1){
			System.out.println(num+"*9="+num*9);
			num--;
		}
		System.out.println("over");
		*/
		
		/*
		int num=1;     //1.循环变量的初始化
		while(num<=9){ //2.循环的条件
			System.out.println(num+"*9="+num*9);
			num++;     //3.循环变量的改变
		}
		System.out.println("over");
		*/
		
		/*
		int times=0;     //1.循环变量的初始化
		while(times<10){ //2.循环的条件
			System.out.println("行动是成功的阶梯");
			times++;     //3.循环变量的改变
		}
		System.out.println("over");
		*/
		/*
		 * 执行过程:
		 *          times=0
		 * true 输出 times=1
		 * true 输出 times=2
		 * true 输出 times=3
		 * true 输出 times=4
		 * true 输出 times=5
		 * true 输出 times=6
		 * true 输出 times=7
		 * true 输出 times=8
		 * true 输出 times=9
		 * true 输出 times=10
		 * false while循环结束
		 */
	}
}












