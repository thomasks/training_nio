package cn.parlife.training.nio.showtcp.disconn;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8088);
			System.out.println("server阻塞开始="+System.currentTimeMillis());
			Socket socket = serverSocket.accept();
			System.out.println("server阻塞结束="+System.currentTimeMillis());
			socket.close();
			serverSocket.close();
			Thread.sleep(2000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
