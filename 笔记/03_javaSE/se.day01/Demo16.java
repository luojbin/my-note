package day01;

/**
 * 测试StringBuilder 和 String 的连接性能
 */
public class Demo16 {
	public static void main(String[] args) {
		StringBuilder ss = new StringBuilder("A");
		long t1 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			ss.append("1");
		}
		long t2 = System.nanoTime();
		System.out.println(ss.length());
		System.out.println(t2 - t1);

		String s = "A";
		t1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			s = s + "1";
		}
		t2 = System.currentTimeMillis();
		System.out.println(s.length());
		System.out.println(t2 - t1);

	}
}
