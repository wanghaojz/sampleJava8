package test.java.com.project.devtest.wangh;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {
	
	//of,ofNullable,isPresent,get,ifPresent,orElse,orElseGet,orElseThrow,map,flatMap,filter
	
	@SuppressWarnings("unused")
	@Test
	public void mytest(){
		Optional<String> optional = null;
		String string = Optional.of("briteSnow").get();
		System.out.println(string);
	}

}
