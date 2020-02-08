package day02;

public class Demo10 {

	public static void main(String[] args) {
		String str = "那一年，我去你家，你说我草！";
		String reg = "我[去草]";
		String s = str.replaceAll(reg, "XXX");
		System.out.println(s);
	}

}
