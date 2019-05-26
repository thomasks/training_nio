package cn.parlife.training.nio.example.buffer.direct;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class Test1_1 {
	
	public static void main(String[] args) throws InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("A");
		ByteBuffer buffer = ByteBuffer.allocateDirect(Integer.MAX_VALUE/2);
		System.out.println("B");
		
		byte[] byteArray = new byte[] {1};
		System.out.println(Integer.MAX_VALUE/2);
		
		for(int i=0;i<Integer.MAX_VALUE/2;i++) {
			buffer.put(byteArray);
		}
		System.out.println("put end");
		Thread.sleep(1000);
		
		Method cleanerMethod = buffer.getClass().getMethod("cleaner");
		cleanerMethod.setAccessible(true);
		
		Object returnValue = cleanerMethod.invoke(buffer);
		Method cleanMethod = returnValue.getClass().getMethod("clean");
		cleanMethod.setAccessible(true);
		cleanMethod.invoke(returnValue);
	}

}
