package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
	
	/*
	 * 该集合用来存放所有客户端的输出流
	 * 以便可以广播消息
	 */
	private List<PrintWriter> allOut;
	
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
		
		allOut = new ArrayList<PrintWriter>();
		
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
			while(true){
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				//启动一个线程用来与该客户端交互
				ClientHandler handler
					= new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
				
			}
			
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
	
	/**
	 * 该线程用来与指定的客户端进行交互
	 * @author adminitartor
	 *
	 */
	private class ClientHandler implements Runnable{
		//当前线程通过这个Socket与指定客户端交互
		private Socket socket;
		//当前客户端的地址信息
		private String host;
		
		public ClientHandler(Socket socket){
			this.socket = socket;
			/*
			 * 通过Socket获取远端计算机地址信息
			 */
			InetAddress address 
				= socket.getInetAddress();
			//获取远端计算机ip地址的字符串格式
			host = address.getHostAddress();
		}
		
		public void run(){
			PrintWriter pw = null;
			try {
				System.out.println(host+"上线了!");
				/*
				 * 这里处理与指定客户端的交互工作
				 */
				/*
				 * Socket的方法：
				 * InputStream getInputStream()
				 * 该方法可以获取一个输入流，通过该流
				 * 可以读取到远端计算机发送过来的数据
				 */
				InputStream in = socket.getInputStream();
				InputStreamReader isr
					= new InputStreamReader(in,"UTF-8");
				BufferedReader br
					= new BufferedReader(isr);
				
				
				
				/*
				 * 通过Socket获取输出流，以便可以将消息
				 * 发送给客户端
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw
					= new OutputStreamWriter(out,"UTF-8");
				pw = new PrintWriter(osw,true);
				
				//将该客户端的输出流存入共享集合
				synchronized (allOut) {
					allOut.add(pw);
				}	
				
				
				String message = null;
				/*
				 * 读取客户端发送过来消息的br.readLine()
				 * 方法在客户端断开连接时，这里运行的
				 * 结果也不相同:
				 * linux的客户端断开连接时,该方法会返回
				 * null值。
				 * 
				 * windows的客户端断开连接时，该方法会
				 * 直接抛出异常。
				 */
				while((message = br.readLine())!=null){
//					System.out.println(host+"说:"+message);
//					pw.println(host+"说:"+message);
					synchronized (allOut) {
						for(PrintWriter o : allOut){
							o.println(host+"说:"+message);
						}
					}
				}
						
			} catch (Exception e) {
		
			} finally{
				//处理客户端断开连接后的操作
				
				//将该客户端的输出流从共享集合中删除
				synchronized (allOut) {
					allOut.remove(pw);
				}
				try {
					//关闭Socket释放资源
					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(host+"下线了!");
			}
		}
	}
	
}











