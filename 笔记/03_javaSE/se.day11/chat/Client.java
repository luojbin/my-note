package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 聊天室客户端
 * @author adminitartor
 *
 */
public class Client {
	/*
	 * Socket封装了TCP通讯协议
	 */
	private Socket socket;
	/**
	 * 构造方法，用来初始化客户端
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public Client() throws UnknownHostException, IOException{
		/*
		 * 实例化Socket的过程就是连接远端计算机的
		 * 过程，这里需要传入两个参数
		 * 参数1:服务端的IP地址信息
		 * 参数2:服务端的端口
		 * 通过IP可以找到服务端的计算机，通过
		 * 端口可以连接到运行在服务端计算机上的
		 * 服务端应用程序。
		 */
		System.out.println("正在连接服务端...");
		socket = new Socket("localhost", 8088);
		System.out.println("已连接服务端!");
	}
	/**
	 * 客户端开始工作的方法
	 */
	public void start(){
		try {
			//启动用来读取服务端消息的线程
			ServerHandler handler
				= new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			
			Scanner scanner = new Scanner(System.in);
			/*
			 * Socket提供方法:
			 * OutputStream getOutputStream()
			 * 该方法可以获取一个输出流，通过
			 * 该输出流写出的数据会发送到远端
			 * 计算机。
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw
				= new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw
				= new PrintWriter(osw,true);
			
			
			String nickName = scanner.nextLine();
			pw.println(nickName);
			
			
			//最后一次发送的时间
			long last = System.currentTimeMillis();
			while(true){
				String message = scanner.nextLine();
				if(System.currentTimeMillis()-last>=1000){
					pw.println(message);
					last = System.currentTimeMillis();
				}else{
					System.out.println("说话速度过快");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			System.out.println("客户端启动失败");
			e.printStackTrace();
		}
	}
	/**
	 * 该线程用来循环读取服务端发送过来的
	 * 每一条消息并输出到控制台。
	 * @author adminitartor
	 *
	 */
	private class ServerHandler implements Runnable{
		public void run(){
			try {
				
				InputStream in = socket.getInputStream();
				InputStreamReader isr
					= new InputStreamReader(in,"UTF-8");
				BufferedReader br
					= new BufferedReader(isr);
				
				String message = null;
				//读取服务端发送过来的消息并输出到控制台
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
				
				
			} catch (Exception e) {
				
			}
		}
	}
}






