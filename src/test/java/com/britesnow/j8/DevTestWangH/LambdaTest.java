package test.java.com.project.devtest.wangh;

import java.util.Arrays;

import org.junit.Test;

public class LambdaTest {
	
	@Test
	public void mytest(){
		
		String separator = ",";
		Arrays.asList( "a", "b", "d" ).forEach(
		    ( String e ) -> System.out.print( e + separator ) );

	}

}
