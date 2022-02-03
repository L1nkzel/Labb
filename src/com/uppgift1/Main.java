package com.uppgift1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("Ali","male", 23000);
        Person p2 = new Person("Arn","male", 25000);
        Person p3 = new Person("Jennifer","female", 30000);
        Person p4 = new Person("Ann","female", 28000);
        Person p5 = new Person("Maggie","female", 25000);
        Person p6 = new Person("Ahmed","male", 41000);
        Person p7 = new Person("Mark","male", 30000);
        Person p8 = new Person("Henry","male", 32000);
        Person p9 = new Person("Helena","female", 35000);
        Person p10 = new Person("Christina","female", 30000);

        List<Person> person = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
        System.out.println("=================First Variant========================");

        DoubleSummaryStatistics stats = person.stream()
                .mapToDouble((x) -> x.getSalary())
                .summaryStatistics();
        System.out.println("Highest income: "+stats.getMax()+" \nLowest income: "+stats.getMin());

        System.out.println("=================Second Variant========================");

        Map<String, Double> avgSalaryFemaleMale =
                person.stream().collect(Collectors.groupingBy(Person::getGender,Collectors.averagingDouble(Person::getSalary)));

        Person highestSalary =
                person.stream().max(Comparator.comparing(Person::getSalary)).get();
        Person lowestSalary =
                person.stream().min(Comparator.comparing(Person::getSalary)).orElseGet(null);


        System.out.println("Average female: " +avgSalaryFemaleMale.get("female")
                + "\nAverage male: " +avgSalaryFemaleMale.get("male"));
        System.out.println("Highest income: "+highestSalary.getName() +" "+ highestSalary.getSalary() +
                "\nLowest income: "+lowestSalary.getName() +" "+ lowestSalary.getSalary());

        System.out.println("=================Second Variant========================");

        OptionalDouble avgFemale = person.stream()
                .filter(person1 -> person1.getGender().contains("female"))
                .mapToDouble(Person::getSalary).average();
        OptionalDouble avgMale = person.stream()
                .filter(person1 -> "male".contains(person1.getGender())) //Var tvungen att ändra ordningen, jämfört med ovan, för att jag fick fel uträknnig.
                .mapToDouble(Person::getSalary).average();

        OptionalDouble max = person.stream()
                .mapToDouble(Person::getSalary).max();
        OptionalDouble min = person.stream()
                .mapToDouble(Person::getSalary).min();

        System.out.printf("Average female: %s%nAverage male:  %s%n", avgFemale.getAsDouble(), avgMale.getAsDouble());
        System.out.printf("Highest income: %s%nLowest income: %s%n", max.getAsDouble(), min.getAsDouble());


    }


}