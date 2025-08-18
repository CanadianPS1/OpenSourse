package com.example;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
public class Main{
    record Person(String name, int age, String city){}
    record Book(String title, String author, int year, double price){}
    record LineItem(String product, int qty, double unitPrice){}
    enum OrderStatus{NEW, FULFILLED, CANCELED}
    record Order(int id, String customer, List<LineItem> items, OrderStatus status){}
    static List<Person> people = List.of(
        new Person("Ana", 17, "Austin"),
        new Person("Ben", 21, "Dallas"),
        new Person("Cara", 21, "Austin"),
        new Person("Dev", 35, "Houston"),
        new Person("Eve", 29, "Dallas"),
        new Person("Finn", 40, "Austin"));
    @SuppressWarnings("unused")
    static List<Book> books = List.of(
        new Book("Effective Java", "Bloch", 2018, 45.0),
        new Book("Clean Code", "Martin", 2008, 42.5),
        new Book("Clean Architecture", "Martin", 2017, 39.0),
        new Book("Java Concurrency in Practice", "Goetz", 2006, 50.0),
        new Book("Refactoring", "Fowler", 2018, 55.0));
    @SuppressWarnings("unused")
    static List<Order> orders = List.of(
        new Order(1001, "Ana", List.of(new LineItem("Pen", 5, 1.50), new LineItem("Notebook", 2, 4.00)),
            OrderStatus.NEW),
        new Order(1002, "Ben", List.of(new LineItem("Pencil", 10, 0.50)), OrderStatus.FULFILLED),
        new Order(1003, "Ana",
            List.of(new LineItem("Marker", 3, 2.00), new LineItem("Notebook", 1, 4.00)),
            OrderStatus.FULFILLED),
        new Order(1004, "Cara", List.of(new LineItem("Eraser", 4, 0.75), new LineItem("Pen", 2, 1.50)),
            OrderStatus.CANCELED),
        new Order(1005, "Dev", List.of(new LineItem("Notebook", 4, 4.00)), OrderStatus.NEW));
    public static void main(String [] args){
        System.out.println("neumont");
        //people who are over the age of 18
        List<String> adults = people.stream()
            .filter(p -> p.age() >= 18)
            .map(Person::name)
            .toList();
        System.out.println("(1) Adults : " + adults);
        //uppercase all people names
        List<String> upper = people.stream()
            .map(p -> p.name().toUpperCase())
            .toList();
        System.out.println("(2) Capital Names : " + upper);
        //give me DISTINCT cities
        Set<String> cities = people.stream()
            .map(Person::city)
            .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("(3) Cities : " + cities);
        //sort people by age and then name
        List<Person> sorted = people.stream()
            .sorted(Comparator.comparing(Person::age).thenComparing(Person::name))
            .toList();
        System.out.println("(4) Sorted (age,name) : " + sorted);
        //average age by city
        Map<String, Double> avgAgeByCity = people.stream()
            .collect(Collectors.groupingBy(Person::city, Collectors.averagingInt(Person::age)));
        System.out.println("(5) Average Age by City : " + avgAgeByCity);
        //all minors in people
        long minors = people.stream()
            .filter(p -> p.age() < 18)
            .count();
        System.out.println("(6) Minors : " + minors);
    }
}