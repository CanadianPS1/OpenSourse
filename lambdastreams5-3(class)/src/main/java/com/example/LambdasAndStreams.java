package com.example;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public final class LambdasAndStreams{
    private final ObjectMapper mapper = new ObjectMapper();
    public LambdasAndStreams(){}
    /** Load people from a JSON file (array of person objects). */
    public List<Person> readPeople(Path jsonPath) throws IOException{
        return mapper.readValue(jsonPath.toFile(), new TypeReference<List<Person>>() {});
    }
    /** TASK 1: Set of all people with addresses in Florida ("FL"). */
    public Set<Person> peopleInFlorida(List<Person> people){
        return people.stream()
            .filter(p -> "FL".equalsIgnoreCase(p.getState()))
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    /**
     * TASK 2: Set of all people who (email ends with ".net") OR
     * whose first name starts with a letter between R and T (inclusive).
     */
    public Set<Person> emailEndsWithNetOrFirstNameBetweenRtoT(List<Person> people){
        Predicate<Person> emailEndsWithNet = p -> p.getEmail() != null && p.getEmail().toLowerCase(Locale.ROOT).endsWith(".net");
        Predicate<Person> firstNameBetweenRAndT = p -> {
            String fn = p.getFirstName();
            if (fn == null || fn.isBlank()) return false;
            char c = Character.toUpperCase(fn.charAt(0));
            return c >= 'R' && c <= 'T';
        };
        return people.stream()
            .filter(emailEndsWithNet.or(firstNameBetweenRAndT))
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    /**
     * TASK 3: List of all people who live in Utah (UT) or Iowa (IA),
     * sorted by phone number (numeric/lexicographic by digits).
     */
    public List<Person> inUtahOrIowaSortedByPhone(List<Person> people){
        Comparator<Person> byPhoneDigits = Comparator.comparing(p -> normalizeDigits(p.getPhone()));
        return people.stream()
            .filter(p -> {
                String st = safe(p.getState()).toUpperCase(Locale.ROOT);
                return "UT".equals(st) || "IA".equals(st);
            })
            .sorted(byPhoneDigits)
            .collect(Collectors.toList());
    }
    /**
     * TASK 4: List of all people with "wordpress" in email, sorted by name (case-insensitive).
     */
    public List<Person> emailContainsWordpressSortedByName(List<Person> people){
        return people.stream()
            .filter(p -> safe(p.getEmail()).toLowerCase(Locale.ROOT).contains("wordpress"))
            .sorted(Comparator.comparing(p -> safe(p.getName()), String.CASE_INSENSITIVE_ORDER))
            .collect(Collectors.toList());
    }
    /**
     * TASK 5: Filter a list of strings using a custom predicate.
     * Example: filterStrings(words, startsWithG()).
     */
    

    /** Ready-made predicate for “starts with G” (case-insensitive). */
    //helper
    private String safe(String s){return s == null ? "" : s;}
    private String normalizeDigits(String s){
        if (s == null) return "";
        return s.replaceAll("\\D", "");
    }
    public static final class Person{
        private String name;
        private String ssn;
        private String email;
        private String phone;
        private String street;
        private String city;
        private String state;
        private String zip;
        public Person(){}
        public String getName(){return name;}
        public String getSsn(){return ssn;}
        public String getEmail(){return email;}
        public String getPhone(){return phone;}
        public String getStreet(){return street;}
        public String getCity(){return city;}
        public String getState(){return state;}
        public String getZip(){return zip;}
        public String getFirstName(){
            String n = name == null ? "" : name;
            int idx = n.indexOf(' ');
            return idx > 0 ? n.substring(0, idx) : n;
        }
        @Override public String toString(){return "%s [%s] | %s | %s".formatted(name, state, email, phone);}
    }
}
