package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java提供了Queue API，由LinkedList实现
 */
public class Demo04 {
	public static void main(String[] args) {
		Queue<String> queue = 
			new LinkedList<String>();
		System.out.println(queue);
		//offer将数据追加到队列中
		queue.offer("Tom");
		queue.offer("Jerry");
		queue.offer("Andy");
		System.out.println(queue); 
		//peek检查队首，元素并不出列
		String first = queue.peek();
		System.out.println(first);//Tom
		System.out.println(queue);//不变
		//poll 是拉出一个元素，元素出列
		String element=queue.poll();
		System.out.println(element);//Tom
		System.out.println(queue);
		//拉取队列中全部的数据
		while(! queue.isEmpty()){
			System.out.println(queue.poll());
		}
	}
}





