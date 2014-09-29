package test.java.com.project.devtest.wangh;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import test.java.com.project.devtest.model.Person;

public class MapTest {
	
	@Test
	public void mytest(){
		String[][] persons = {{"1", "xiaoming","Man", "IT","happy!"}, {"2", "xiaohong","Woman", "teacher","yoyo!"}, {"3", "xiaobaitu","Man", "Programmer","Show time!"}};
		
		List<Person> test = Stream.of(persons).map(data -> new Person(data[0], data[1], data[2],data[3], data[4])).collect(Collectors.toList());
        Map<String, List<Person>> people = test.stream().filter(p -> p.getWork().equals("teacher")).collect(Collectors.groupingBy(Person::getmark));
		
		System.out.println(people);
	}

}
