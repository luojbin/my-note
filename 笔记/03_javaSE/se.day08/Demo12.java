package day08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 一个完整的异常处理案例 
 */
public class Demo12 {
	public static void main(String[] args) {
		String from = "abc";
		String to = "abc/ok.new";
		try{
			//Java编译器会检查：如果方法有异常声明就必须进行处理
			copy(from, to);
			System.out.println("完成");
		}catch(RuntimeException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	//方法中如果抛出了异常，就需要使用throws声明
	//方法有意外情况发生，否则会有编译错误
	public static void copy(String from,
			String to) throws IOException,
		RuntimeException {
		File file = new File(from);
		if(! file.exists()){
			throw new RuntimeException(
			"源文件不存在！"+from);
		}
		if(! file.isFile()){
			throw new RuntimeException(
			"源不是文件！"+from);	
		}
		//...可以增加其他异常处理逻辑
		
		//必须在try
		FileInputStream in = null;
		FileOutputStream out = null;
		try{
			in=new FileInputStream(from);
			out=new FileOutputStream(to);
			byte[] buf = new byte[1024*8];
			int n;
			while((n=in.read(buf))!=-1){
				out.write(buf, 0, n);
			}

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			//复制期间的读写失败！
			e.printStackTrace();
			//复制期间出现的意外情况，必须
			//再次抛给调用者，告诉调用者复制失败了
			throw e;
		}finally{
			//回收系统资源
			//close()方法本身也会抛出异常，必须进行捕获处理
			try{
				//由于in可能为null，为了避免空指针异常，必须检查是否为空
				if(in!=null) in.close();
				if(out!=null) out.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}







