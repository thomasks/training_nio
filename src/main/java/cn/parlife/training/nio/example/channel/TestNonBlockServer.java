package cn.parlife.training.nio.example.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TestNonBlockServer {
	
	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		System.out.println(serverSocketChannel.isBlocking());
		serverSocketChannel.configureBlocking(false);
		System.out.println(serverSocketChannel.isBlocking());
		serverSocketChannel.bind(new InetSocketAddress("localhost", 8088));
		System.out.println("begin "+System.currentTimeMillis());
		SocketChannel socketChannel = serverSocketChannel.accept();
		System.out.println("end "+System.currentTimeMillis()+" socketChannel="+socketChannel);
		socketChannel.close();
		serverSocketChannel.close();
	}
}
