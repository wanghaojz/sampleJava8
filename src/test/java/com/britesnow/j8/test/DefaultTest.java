package test.java.com.project.devtest.wangh;

import org.junit.Test;

public class DefaultTest implements InterfaceTest01,InterfaceTest02{
	
	@Test
	public void myTest(){
		DefaultTest DT = new DefaultTest();
		DT.test();
	}
	
	@Test
	public void test(){
	}

}