package day04;
//作业讲解
public class Homework {
	public static void main(String[] args) {
		
		/*
		//5.根据年份和月份计算天数
		int year = 2001; //年
		int month = 9;   //月
		int days = 0;    //天数
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if((year%4==0 && year%100!=0) || year%400==0){
				days = 29;
			}else{
				days = 28;
			}
		}
		System.out.println(year+"年的"+month+"月，共"+days+"天");
		*/
		
		/*
		//4.个人所得税
		double salary = 10000.0; //工资
		double taxSalary = salary-3500; //计税工资
		double tax = 0.0; //税
		if(taxSalary<=0){
			tax = 0.0; //不纳税
		}else if(taxSalary<=1500){
			tax = taxSalary*0.03-0;
		}else if(taxSalary<=4500){
			tax = taxSalary*0.1-105;
		}else if(taxSalary<=9000){
			tax = taxSalary*0.2-555;
		}else if(taxSalary<=35000){
			tax = taxSalary*0.25-1005;
		}
		System.out.println("tax="+tax);
		*/
		
		/*
		//3.闰年的判断
		int year = 2004;
		if((year%4==0 && year%100!=0) || year%400==0){
			System.out.println(year+"是闰年");
		}else{
			System.out.println(year+"不是闰年");
		}
		*/
		
		
		/*
		 * 补充:
		 * 1.变量的作用域/作用范围:
		 *     从变量的声明开始到包含它最近的大括号结束
		 * 2.变量的同名问题:
		 *     作用域重叠时，变量不能同名
		 */
		/*
		int a=5;
		if(a>2){
			int b=6;
			//int a=55;
		}else{
			int b=8;
		}
		*/
		
		/*
		int a=5;
		if(a>2){
			int b=8;
			System.out.println(a);
			System.out.println(b);
		}
		System.out.println(a);
		//System.out.println(b); //编译错误，超出作用范围了
		*/
		
		/*
		//3.三个数的排序:
		int a=8,b=5,c=2;
		if(a>b){
			int t=a;
			a=b;
			b=t;
		}
		if(a>c){
			int t=a;
			a=c;
			c=t;
		}
		if(b>c){
			int t=b;
			b=c;
			c=t;
		}
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		*/
		
		
		
		
		
		
		
		
		
		
		/*
		//2.两个数的排序
		int a=8,b=55;
		if(a>b){
			int t=a;
			a=b;
			b=t;
		}
		System.out.println("a="+a);
		System.out.println("b="+b);
		*/
		
		
		
		
		
		
		
		
		/*
		//1.求两个数中的最大值
		int a=55,b=8;
		int max = a>b?a:b;
		System.out.println("max="+max);
		*/
	}
}










