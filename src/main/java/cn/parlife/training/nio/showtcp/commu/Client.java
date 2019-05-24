package cn.parlife.training.nio.showtcp.commu;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",8088);
		OutputStream outputStream = socket.getOutputStream();
		for (int i = 0; i < 3; i++) {
			outputStream.write("1234567890".getBytes());
			System.out.println(i+1);
		}
		outputStream.close();
		socket.close();
	}

}
