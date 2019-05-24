package cn.parlife.training.nio.showtcp.disconn;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) {
		try {
			System.out.println("client连接准备="+System.currentTimeMillis());
			Socket socket = new Socket("localhost",8088);
			System.out.println("client连接结束="+System.currentTimeMillis());
			socket.close();
			Thread.sleep(2000);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
