package day05;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 后进先出的栈结构 
 */
public class Demo05 {
	public static void main(String[] args) {
		// Deque 接口中定义了 栈操作方法
		// LinkedList 实现了栈操作方法
		Deque<String> stack = 
			new LinkedList<String>();
		//栈提供了 push方法可以将数据“压”入栈中。
		stack.push("Tom");
		stack.push("Jerry");
		stack.push("Andy");
		//先压入的数据在栈的最底部
		System.out.println(stack);
		//出栈的顺序相反：后进先出
		while(! stack.isEmpty()){
			//利用pop可以从栈中弹出数据
			//弹出顺序与进入顺序相反
			String s = stack.pop();
			System.out.println(s); 
		}
	}
}



