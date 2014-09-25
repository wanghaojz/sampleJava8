package test.java.com.project.devtest.wangh;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {
	
	//of,ofNullable,isPresent,get,ifPresent,orElse,orElseGet,orElseThrow,map,flatMap,filter
	
	@Test
	public void mytest(){
		
		System.out.println("---of Test:");
		Optional<String> name = Optional.of("wangh");
        System.out.println(name);
        
        System.out.println("---ofNullable Test:");
        Optional<Object> empty = Optional.ofNullable(null);
        System.out.println(empty);
        
        System.out.println("---isPresent && get Test:");
        if (name.isPresent()) {
        	  System.out.println(name.get());
        	}
        
        System.out.println("---ifPresent Test:");
        name.ifPresent((value) -> {
        	  System.out.println("The length of the value is: " + value.length());
        	});
        
        System.out.println("---orElse Test:");
        System.out.println(empty.orElse("There is no value present!"));
        System.out.println(name.orElse("There is some value!"));
        
        // it can use lambda which is different from orElse
        System.out.println("---orElseGet Test:");
        System.out.println(empty.orElseGet(() -> "Default Value"));
        System.out.println(name.orElseGet(() -> "Default Value"));
        
        System.out.println("---map Test:");
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));
        
        // it's return is Optional
        System.out.println("---flatMap Test:");
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));
        
        System.out.println("---filter Test:");
        Optional<String> longName = name.filter((value) -> value.length() > 3);
        System.out.println(longName.orElse("The name is less than 6 characters"));
        
	}

}
