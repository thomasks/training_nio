package cn.parlife.training.nio.showtcp.conn;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	
	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket(8088);
			System.out.println("server阻塞开始="+System.currentTimeMillis());
			socket.accept();
			System.out.println("server阻塞结束="+System.currentTimeMillis());
			Thread.sleep(Integer.MAX_VALUE);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
