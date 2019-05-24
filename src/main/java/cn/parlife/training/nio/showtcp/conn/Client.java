package cn.parlife.training.nio.showtcp.conn;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) {
		try {
			System.out.println("client 连接准备="+System.currentTimeMillis());
			Socket socket = new Socket("localhost",8088);
			System.out.println("client 连接结束="+System.currentTimeMillis());
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("111".getBytes());
			outputStream.write("11111".getBytes());
			outputStream.write("1111111111".getBytes());
			Thread.sleep(500000000);
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
