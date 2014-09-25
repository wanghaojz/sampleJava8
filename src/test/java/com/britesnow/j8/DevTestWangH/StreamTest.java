package test.java.com.project.devtest.wangh;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import test.java.com.project.devtest.model.Person;

public class StreamTest {
	
	//distinct,filter,map,flatMap,limit,skip...
	
	@Test
	public void mytest(){
		
        
		String[][] persons = {{"1", "xiaoming","Man", "IT","happy!"}, {"2", "xiaohong","Woman", "teacher","yoyo!"}, {"3", "xiaobaitu","Man", "Programmer","Show time!"}};
		
		List<Person> test = Stream.of(persons).map(data -> new Person(data[0], data[1], data[2],data[3], data[4])).collect(Collectors.toList());
		
		System.out.println("---filterTest:");
        filterTest(test);
        
        System.out.println("---mapTest:");
        mapTest(test);
        
        System.out.println("---peekTest:");
        peekTest(test);
        
        System.out.println("---distinctTest:");
        distinctTest(test);
        
        System.out.println("---limitTest:");
        limitTest(test);
        
        System.out.println("---skipTest:");
        skipTest(test);
        
        otherTest();

	}
	
   //	a non-interfering, stateless predicate to apply to each element to determine if it should be included
	
	public void filterTest(List<Person> filter){
		
		Map<String, List<Person>> people = filter.stream().filter(p -> p.getWork().equals("teacher")).collect(Collectors.groupingBy(Person::getmark));
		
		System.out.println(people);
		
	}
	
   //	a non-interfering, stateless function to apply to each element
	
	public void mapTest(List<Person> map){
		
		System.out.println(map.stream().map(p -> p.getId()+"+10086").collect(Collectors.toList()));
		
	}
	
   //	 a non-interfering, stateless function to apply to each element which produces a stream of new values
	
	public void flatMapTest(List<Person> flatMap){
		
		System.out.println(flatMap.stream().flatMap(null).collect(Collectors.toList()));
		
	}
	
   //	a non-interfering action to perform on the elements as they are consumed from the stream
	
	public void peekTest(List<Person> peek){
		
		peek.stream().peek(p -> {System.out.println(p.getName()+"'s Work is: " + p.getWork()); }).collect(Collectors.toList());
		
	}
	
	public void distinctTest(List<Person> distinct){
		
		System.out.println(distinct.stream().distinct().collect(Collectors.toList()));
		
	}
	
   //	a non-interfering, stateless Comparator to be used to compare stream elements
	
	public void sortedTest(List<Person> sorted){
		
		System.out.println(sorted.stream().sorted().collect(Collectors.toList()));
		
	}
	
   //	the number of elements the stream should be limited to
	
	public void limitTest(List<Person> limit){
		
		System.out.println(limit.stream().limit(2).collect(Collectors.toList()));
		
	}
	
   //	the number of elements the stream should be skiped
	
	public void skipTest(List<Person> skip){
		
		System.out.println(skip.stream().skip(2).collect(Collectors.toList()));
		
	}
	
	public void otherTest(){

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
        
        System.out.println("---forEachTest:");
        names.stream().forEach(System.out::println);
        
        System.out.println("---toArrayTest:");
        System.out.println(names.stream().toArray(String[] :: new)[0]);
        
        System.out.println("---reduceTest:");
        System.out.println(list.stream().filter(num -> num != null).reduce((sum, item) -> sum+item).get());
        
        System.out.println("---collectTest:");
        System.out.println(names.stream().map(name -> name.toLowerCase()).collect(Collectors.toList()));
        
        System.out.println("---minTest:");
        System.out.println(names.stream().min((o1, o2) -> o1.compareTo(o2)).get());
        
        System.out.println("---countTest:");
        System.out.println(names.stream().count());
        
        System.out.println("---allMatchTest:");
        System.out.println(list.stream().allMatch(num -> num > 2));
        
        System.out.println("---findFirstTest:");
        System.out.println(list.stream().findFirst());
        
        System.out.println("---TogetherTest:");
        System.out.println("sum is:"+list.stream().filter(num -> num != null).
                distinct().mapToInt(num -> num * 2).
                peek(System.out::println).skip(2).limit(4).sum());
	}

}
