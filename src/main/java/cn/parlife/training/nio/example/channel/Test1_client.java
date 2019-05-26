package cn.parlife.training.nio.example.channel;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Test1_client {
	
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 8088);
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("我是发送数据的client".getBytes());
		outputStream.close();
		socket.close();
	}

}
