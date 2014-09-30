package test.java.com.project.devtest.wangh;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import test.java.com.project.devtest.model.Person;

public class CollectorTest {

	@Test
	public void myTest(){
		
		String[][] persons = {{"1", "xiaoming","Man", "IT","happy!"}, {"2", "xiaohong","Woman", "teacher","yoyo!"}, {"3", "xiaobaitu","Man", "Programmer","Show time!"}};
		
		List<Person> test = Stream.of(persons).map(data -> new Person(data[0], data[1], data[2],data[3], data[4])).collect(Collectors.toList());
		
		//list
		List<String> list = test.stream().map(Person :: getWork).collect(Collectors.toList());
		System.out.println("---tolist Test:"+list);
		
		//map
		System.out.println("---Map Test:");
        Map<String, String> map1 = test.stream().filter(p -> p.getWork().equals("teacher")).collect(Collectors.toMap(Person :: getId , Person :: getName));
        System.out.println(map1);
        Map<String, String> map2 = test.stream().collect(Collectors.toMap(Person :: getWork,Person :: getName));
        System.out.println(map2);
        Map<String, List<Person>> map3 = test.stream().filter(p -> p.getWork().equals("teacher")).collect(Collectors.groupingBy(Person::getmark));
        System.out.println(map3);
        
        //Set
        Set<Person> customTest = test.stream().collect(Collectors.toCollection(HashSet::new));
        System.out.println("---SetTest:"+customTest);
        
        //joining
        String joining = test.stream().map(Object::toString).collect(Collectors.joining(" || "));
        System.out.println("---joiningTest:"+joining);
        
        //sum
        int sum = test.stream().collect(Collectors.summingInt(Person :: getSum));
        System.out.println("---sumTest:"+sum);
        
        //groupingBy
        Map<String, List<Person>> groupingBy = test.stream().collect(Collectors.groupingBy(Person :: getWork));
        System.out.println("---groupingByTest:"+groupingBy);
        
        //groupingByConcurrent
        ConcurrentMap<String, List<Person>> groupingByConcurrent = test.stream().collect(Collectors.groupingByConcurrent(Person :: getDescription));
        System.out.println("---groupingByConcurrent:"+groupingByConcurrent);
        
        //partitioningBy
        Map<Boolean, List<Person>> partitioningBy = test.stream().collect(Collectors.partitioningBy(data -> data.getSum() > 2));
        System.out.println("---partitioningByTet:"+partitioningBy);
        
        //newMap
        HashMap<Object, Object> newMap = test.stream().collect(()->new HashMap<>(), (hashMap,item) -> {hashMap.put(item.getName(), item.getWork());}, (hashMapOld, hashMapNew) -> hashMapOld.putAll(hashMapNew));
        System.out.println("---newMapTest:"+newMap);
        
        //custom Collector
        customTest = test.parallelStream().collect(new Collector<Person,Set,Set<Person>>(){

			@Override
			public Supplier<Set> supplier() {
				return HashSet::new;
			}

			@Override
			public BiConsumer<Set, Person> accumulator() {
				return Set::add;
			}

			@Override
			public BinaryOperator<Set> combiner() {
				return (left, right) -> {
					right.addAll(left);
					return right;
				};
			}

			@Override
			public Function<Set, Set<Person>> finisher() {
				return a -> a;
			}

			@Override
			public Set<java.util.stream.Collector.Characteristics> characteristics() {
				return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
			}
			
        });
        
        System.out.println("---customTest:");
        System.out.println(customTest);
	}
}
