package cn.parlife.training.nio.showtcp.commu;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(8088);
		Thread.sleep(Integer.MAX_VALUE);
	}
	
}
