package com.sakinramazan.java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // before Jdk-7
        List<String> lines = Arrays.asList("sample", "code", "java", "7");
        String filter = "code";

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Sample usage with Java7");
        // result list with filter - without "code" string
        List<String> result1 = getFilterOutput(lines, filter);
        // classic foreach to trace the list
        for (String temp : result1) {
            System.out.println(temp);
        }


        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("With Java8");
        // After Jdk-8
        List<String> result2 = getFilterOutputWithJava8(lines, filter);    // we dont have to write method indeed :)
        // just be able to compare them
        result2.forEach(System.out::println);   // method reference sample usage


        // -------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Sample usage with Java8 - 2");
        List<Person> people = Arrays.asList(
                new Person("Jack", "X", 30),
                new Person("John", "Y", 20),
                new Person("Sun", "Z", 45),
                new Person("Ken", "Q", 60),
                new Person("Ryu", "T", 35)
        );
        filter = "Sun";

        // Java7-
        Person res = getPersonByName(people, filter);
        System.out.println(res);

        // Java8+
        res = getPersonByNameWithJava8(people, filter);


        // -------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Sample usage with Java8 - 3");
        // we can filter by any of the fields we want on person
        String tempFilter = "John";
        Person person1 = people.stream()
                .filter((p) -> tempFilter.equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("Filtered Person 1 :" + person1);

        Person person2 = people.stream().filter(p -> {
            if (tempFilter.equals(p.getName()) && 20 == p.getAge()) {
                return true;
            }
            return false;
        }).findAny()
                .orElse(null);

        System.out.println("Filtered Person 2 :" + person2);


        // -------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Sample usage with Java8 - 4");
        List<String> chars = Arrays.asList("x", "y", "z", "t", "q");

        // Java7-
        List<String> uppers = new ArrayList<>();
        for (String s : chars) {
            uppers.add(s.toUpperCase());
        }

        System.out.println(chars);
        System.out.println(uppers);

        // Java8+
        List<String> resultList = chars.stream().map(String::toUpperCase/* Method reference usage again*/)
                .collect(Collectors.toList());
        System.out.println(resultList); //[A, B, C, D]

        // -------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Sample usage with Java8 - 5");
        // Another basic map usage
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> collect1 = numbers.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1);


        // -------------------------------------------------------------------------------------------------------------
        // Another map example
        List<Person> people2 = Arrays.asList(
                new Person("Joe", "X", 30),
                new Person("Jimmy", "Y", 20),
                new Person("Kane", "Z", 45)
        );

        // Java7-
        List<String> result = new ArrayList<>();
        for (Person x : people2) {
            result.add(x.getName());
        }
        System.out.println(result);

        // Java8+
        List<String> collect = people2.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(collect);

        List<String> items =
                Arrays.asList("group1", "group2", "group1",
                        "group2", "group2", "group1", "group3", "group1", "group3");

        // -------------------------------------------------------------------------------------------------------------
        // -------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Sample usage with Java8 - 6");
        // Another stream usage - group by, sort and count
        Map<String, Long> resultMap =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        // grouping by result
        System.out.println(resultMap);

        Map<String, Long> finalMap = new LinkedHashMap<>();
        // map sorting
        resultMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);


        // -------------------------------------------------------------------------------------------------------------
        // -------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Sample usage with Java8 - 7");
        // static local datas to test grouping with map
        List<Fruit> fruitList = Arrays.asList(
                new Fruit("banana", 20, new BigDecimal("19.99")),
                new Fruit("watermelon", 10, new BigDecimal("29.99")),
                new Fruit("papaya", 20, new BigDecimal("9.99")),
                new Fruit("banana", 10, new BigDecimal("19.99")),
                new Fruit("orang", 10, new BigDecimal("29.99")),
                new Fruit("watermelon", 10, new BigDecimal("29.99")),
                new Fruit("papaya", 20, new BigDecimal("9.99")),
                new Fruit("banana", 10, new BigDecimal("19.99")),
                new Fruit("apple", 10, new BigDecimal("9.99")),
                new Fruit("apple", 10, new BigDecimal("9.99")),
                new Fruit("apple", 20, new BigDecimal("9.99"))
        );


        Map<String, Long> counting = fruitList.stream().collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));
        System.out.println(counting);

        Map<String, Integer> sum = fruitList.stream().collect(Collectors.groupingBy(Fruit::getName, Collectors.summingInt(Fruit::getQty)));
        System.out.println(sum);

    }

    // java7-
    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> resultList = new ArrayList<>();
        for (String line : lines) {
            if (!filter.equals(line)) {
                resultList.add(line);
            }
        }
        return resultList;
    }

    // java8+
    private static List<String> getFilterOutputWithJava8(List<String> lines, String filter) {
        return lines.stream().filter(line -> !filter.equals(line)).collect(Collectors.toList());
    }


    // java7-
    private static Person getPersonByName(List<Person> persons, String name) {
        Person result = null;
        for (Person temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }

    // java8+
    private static Person getPersonByNameWithJava8(List<Person> persons, String name) {
        // first you need to convert ur collection to stream, then any filters you want, and get the result
        return persons.stream().filter(x -> name.equals(x.getName())).findAny().orElse(null);
    }

}