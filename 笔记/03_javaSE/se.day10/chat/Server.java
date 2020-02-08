package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天室服务端
 * @author adminitartor
 *
 */
public class Server {
	/*
	 * 运行在服务端的ServerSocket有两个主要
	 * 作用:
	 * 1:申请服务端口，客户端就是通过该端口 
	 *   与服务端建立连接的
	 * 2:监听申请的服务端口，一旦一个客户端
	 *   通过该端口与服务端连接，ServerSocket
	 *   就会主动创建一个Socket与该客户端通讯  
	 */
	private ServerSocket server;
	/**
	 * 构造方法，用来初始化服务端
	 * @throws IOException 
	 */
	public Server() throws IOException{
		/*
		 * 初始化ServerSocket的同时，指定
		 * 要申请的服务端口，若该端口已经
		 * 被其他程序占用，会抛出异常。
		 */
		server = new ServerSocket(8088);
	}
	
	public void start(){
		try {
			/*
			 * 监听端口，等待客户端连接
			 * 
			 * ServerSocket的accept方法
			 * 是一个阻塞方法，作用是监听
			 * 服务端口，直到一个客户端通过
			 * 该端口连接，才会返回一个Socket
			 * 实例，通过这个Socket可以与刚
			 * 连接的客户端通讯。
			 */
			System.out.println("等待客户端连接...");
			Socket socket = server.accept();
			System.out.println("一个客户端连接了!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			System.out.println("服务端启动失败!");
			e.printStackTrace();
		}
	}
}











