package chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

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
}






