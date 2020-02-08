package day02;

public class Demo01 {

	public static void main(String[] args) {
		String code="";
		StringBuilder buf = new StringBuilder();
		char[] chs = {'A','B','C','E'};
		for(int i=0;i<10; i++){
			int n=(int)(Math.random()*chs.length);
			char c = chs[n];
			//code += c;
			buf.append(c);
		}
		code = buf.toString();
		System.out.println(code); 
	}

}
