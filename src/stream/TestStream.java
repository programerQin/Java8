package stream;

import baseclass.Employee;
import baseclass.EmployeeData;
import jdk.nashorn.internal.ir.CallNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class TestStream {
    @Test
    public void test1(){
        //创建Stream方式一：通过集合
        List<Employee> employeeList = EmployeeData.getEmployees();
        Stream<Employee> stream = employeeList.stream();

        Stream<Employee> parallelStream = employeeList.parallelStream();
        //数组创建流
        int[] ints = {1, 5, 3, 77, 8};
        IntStream intStream = Arrays.stream(ints);
        Object[] objects = employeeList.toArray();


        Stream<Object> employeeStream = Arrays.stream(objects);
        //Stream类静态方法of(...values)
        Stream<Integer> integerStream = Stream.of(1,2,5,6,7,88,3,42,47,8,4,2,4,4,5);

        Stream<Integer> iterate = Stream.iterate(1, t -> t + 1);
        Stream<Double> generate = Stream.generate(Math::random);

        //intStream.filter(i->i>7).distinct().limit(5).skip(1).forEach(System.out::println);

        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        Stream<Character> stringStream = list.stream().flatMap(TestStream::fromStringToStream);
        stringStream.forEach(System.out::println);
        list.stream().sorted().forEach(System.out::println);
        //stream.sorted((Employee o1,Employee o2)->o1.getAge()-o2.getAge()).forEach(System.out::println);
        Stream<Employee> sorted = stream.sorted((Employee o1, Employee o2) -> o1.getAge() - o2.getAge());
        boolean b = sorted.allMatch((o) -> o.getAge() > 20);
        System.out.println(b);
        OptionalInt reduce = intStream.reduce((o1, o2) -> o1 + o2);
        Integer reduce1 = Stream.of(2, 3, 4, 56, 6).reduce(1, (a,c) -> a * c);
        System.out.println(reduce1);
        List<Integer> collect = Stream.of(3, 34, 5, 5, 66).filter((a) -> a > 5).collect(Collectors.toList());
        Stream<Integer> integerStream1 = Stream.of(1, 2);
        integerStream1.forEach(System.out::println);
        //integerStream1.sorted();

    }
    public  static Stream<Character>  fromStringToStream(String s){
        Character[] characters = new Character[s.length()];
        for (int i = 0; i < s.length() ; i++) {
            characters[i]=s.charAt(i);
        }
        return Stream.of(characters);
    }

}
