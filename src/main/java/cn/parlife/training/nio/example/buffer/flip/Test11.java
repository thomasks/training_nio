package cn.parlife.training.nio.example.buffer.flip;

import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

public class Test11 {
	
	public static void main(String[] args) {
		byte[] byteArray = new byte[] {1,2,3};
		ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
		
		byteBuffer.position(2);
		byteBuffer.mark();
		
		byteBuffer.flip();
		
		System.out.println("byteBuffer.position="+byteBuffer.position());
		System.out.println();
		
		System.out.println("byteBuffer.limit="+byteBuffer.limit());
		System.out.println();
		
		try {
			byteBuffer.reset();
		} catch(InvalidMarkException e) {
			System.out.println("byteBuffer mark丢失");
		}
	}

}
