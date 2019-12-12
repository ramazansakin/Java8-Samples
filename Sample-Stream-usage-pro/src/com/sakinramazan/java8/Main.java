package com.sakinramazan.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // before Jdk-7
        List<String> lines = Arrays.asList("sample", "code", "java", "7");
        String filter = "code";


        // result list with filter - without "code" string
        List<String> result1 = getFilterOutput(lines, filter);
        // classic foreach to trace the list
        for (String temp : result1) {
            System.out.println(temp);
        }

        // After Jdk-8
        List<String> result2 = getFilterOutputWithJava8(lines, filter);    // we dont have to write method indeed :)
        // just be able to compare them
        result2.forEach(System.out::println);   // method reference sample usage


        // -------------------------------------------------------------------------------------------------------------
        // Sample 2
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


        // another sample usages
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