package cn.parlife.training.nio.example.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {
	
	private final static int BUFFER_SIZE = 1024;
	
	private ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
	
	private Selector selector = null;
	
	public void init(int port) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.bind(new InetSocketAddress("localhost", port));
		selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
	
	public void listen() throws IOException {
		while(true) {
			int n = selector.select();
			if (n ==0 ) {
				continue;
			}
			Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
			while(iter.hasNext()) {
				SelectionKey selectionKey = iter.next();
				handleKey(selectionKey);
				iter.remove();
			}
		}
	}
	
	private void handleKey(SelectionKey selectionKey) throws IOException {
		//是否有连接进来
		if(selectionKey.isAcceptable()) {
			SocketChannel socketChannel = ((ServerSocketChannel)selectionKey.channel()).accept();
			registerChannel(selector, socketChannel, SelectionKey.OP_READ);
			//say hello
			if(socketChannel.isConnected()) {
				buffer.clear();
				buffer.put("i'm server...".getBytes());
				buffer.flip();
				socketChannel.write(buffer);
			}
		}
		//通道可读时间就绪
		if(selectionKey.isReadable()) {
			SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
			buffer.clear();
			int len =0;
			while((len = socketChannel.read(buffer)) > 0) {
				buffer.flip();
				while(buffer.hasRemaining()) {
					System.out.println("server读取的数据:"+new String(buffer.array(),0,len));
				}
			}
			if(len < 0) {
				socketChannel.close();
			}
			//SocketChannel通道的可写事件注册到selector中
			registerChannel(selector, socketChannel, SelectionKey.OP_WRITE);
			
		}
		//通道可写事件
		if(selectionKey.isWritable()) {
			SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
			buffer.clear();
			String message_from_server = "Hello,Client... " + socketChannel.getLocalAddress();
			buffer.put(message_from_server.getBytes());
			buffer.flip();
			socketChannel.write(buffer);
			System.out.println("Server发送的数据:" + message_from_server);
			// SocketChannel通道的可写事件注册到Selector中
			registerChannel(selector, socketChannel, SelectionKey.OP_READ);
		}
	}
	
	// 注册通道到指定Selector上
	private void registerChannel(Selector selector, SelectableChannel channel, int ops) throws IOException {
		if (channel == null) {
			return;
		}
		channel.configureBlocking(false);
		// 注册通道
		channel.register(selector, ops);
	}


	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.init(8088);
		server.listen();
	}
}
