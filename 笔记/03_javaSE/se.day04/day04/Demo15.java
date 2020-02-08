package day04;

import java.util.Arrays;
import java.util.List;
/**
 * 将数组转换为长度不可变的List集合 
 */
public class Demo15 {
	public static void main(String[] args) {
		Integer[] ary = {2,3,4,8};
		//asList返回长度固定的List，与
		//数组共享存储空间
		List<Integer> list=
				Arrays.asList(ary);
		System.out.println(list);
		ary[0]=9;
		System.out.println(list);
		//不能改变此List的长度
		list.remove(0);
	}

}
