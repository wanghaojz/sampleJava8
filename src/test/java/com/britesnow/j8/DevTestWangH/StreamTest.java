package test.java.com.project.devtest.wangh;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamTest {
	
	//distinct,filter,map,flatMap,limit,skip...
	
	@Test
	public void mytest(){
		
		List<String> names = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
        names.add("wangX");
        names.add("wangG");
        names.add("wangh");
        names.add("Bao");
        
        list.add(1);
        list.add(1);
        list.add(null);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        
        List<String> lowercaseNames = names.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());
        
        System.out.println(lowercaseNames);
        System.out.println("sum is:"+list.stream().filter(num -> num != null).
                    distinct().mapToInt(num -> num * 2).
                    peek(System.out::println).skip(2).limit(4).sum());

	}

}
