package test.java.com.project.devtest.wangh;

import java.util.function.Function;

import org.junit.Test;

public class FunctionTest {

	@Test
	public void myTest(){
		
        String s = "hello";
        
        Function<String,String> function = x -> x+" world";  
        
        System.out.println(function.apply(s)); 
	}
}