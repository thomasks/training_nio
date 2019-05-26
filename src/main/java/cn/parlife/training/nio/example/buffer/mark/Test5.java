package cn.parlife.training.nio.example.buffer.mark;

import java.nio.ByteBuffer;

public class Test5 {
	
	public static void main(String[] args) {
		byte[] byteArray = new byte[] {1,2,3};
		ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
		
		System.out.println("byteBuffer.capacity="+byteBuffer.capacity());
		System.out.println();
		
		byteBuffer.position(1);
		byteBuffer.mark();
		System.out.println("bytebuffer.position="+byteBuffer.position());
		
		byteBuffer.position(2);
		byteBuffer.reset();//位置重置
		System.out.println();
		
		System.out.println("byteBuffer.position="+byteBuffer.position());
		
	}

}
