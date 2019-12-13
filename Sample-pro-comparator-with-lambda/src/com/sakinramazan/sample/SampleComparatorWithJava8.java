package com.sakinramazan.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SampleComparatorWithJava8 {

    public static void main(String[] args) {

        // getting sample local datas to test
        List<Person> listDevs = getPersons();

        System.out.println("Persons at first: ");
        for (Person Person : listDevs) {
            System.out.println(Person);
        }

        // first version
        Collections.sort(listDevs, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        // second version - classic lambda method
        Collections.sort(listDevs, (o1, o2) -> o1.getAge() - o2.getAge());

        // third version -  Method reference on Lambda
        Collections.sort(listDevs, Comparator.comparingInt(Person::getAge));

        // its getting shorter when we use java8+ :)
        System.out.println("Persons after sorting: ");
        for (Person Person : listDevs) {
            System.out.println(Person);
        }

        // Other comparators for the other fields of Person class
        Collections.sort(listDevs, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        //sort by name
        Collections.sort(listDevs, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //sort by salary
        Collections.sort(listDevs, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
    }

    private static List<Person> getPersons() {

        List<Person> result = new ArrayList<>();

        result.add(new Person("ali", 100, 33));
        result.add(new Person("veli", 50, 20));
        result.add(new Person("ahmet", 200000, 10));
        result.add(new Person("mehmet", 400, 55));
        result.add(new Person("selim", 4400, 33));
        result.add(new Person("can", 150, 20));
        result.add(new Person("cem", 200000, 10));
        result.add(new Person("kaan", 40054, 55));

        return result;
    }
}
