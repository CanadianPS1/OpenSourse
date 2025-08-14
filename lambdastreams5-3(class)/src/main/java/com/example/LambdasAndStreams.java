package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class LambdasAndStreams {

    private final ObjectMapper mapper = new ObjectMapper();

    
    public LambdasAndStreams() {}

    

    /** Load people from a JSON file (array of person objects). */
    public List<Person> readPeople(Path jsonPath) throws IOException {
        return mapper.readValue(jsonPath.toFile(), new TypeReference<List<Person>>() {});
    }
    

    /** TASK 1: Set of all people with addresses in Florida ("FL"). */
    

    /**
     * TASK 2: Set of all people who (email ends with ".net") OR
     * whose first name starts with a letter between R and T (inclusive).
     */
    
    /**
     * TASK 3: List of all people who live in Utah (UT) or Iowa (IA),
     * sorted by phone number (numeric/lexicographic by digits).
     */
    

    /**
     * TASK 4: List of all people with "wordpress" in email, sorted by name (case-insensitive).
     */
    

    /**
     * TASK 5: Filter a list of strings using a custom predicate.
     * Example: filterStrings(words, startsWithG()).
     */
    

    /** Ready-made predicate for “starts with G” (case-insensitive). */
    

    
    //helper
    private String safe(String s) {
        return s == null ? "" : s;
    }

    private String normalizeDigits(String s) {
        if (s == null) return "";
        return s.replaceAll("\\D", "");
    }


    public static final class Person {
        private String name;
        private String ssn;
        private String email;
        private String phone;
        private String street;
        private String city;
        private String state;
        private String zip;

        public Person() {}

        public String getName() { return name; }
        public String getSsn() { return ssn; }
        public String getEmail() { return email; }
        public String getPhone() { return phone; }
        public String getStreet() { return street; }
        public String getCity() { return city; }
        public String getState() { return state; }
        public String getZip() { return zip; }

        
        public String getFirstName() {
            String n = name == null ? "" : name;
            int idx = n.indexOf(' ');
            return idx > 0 ? n.substring(0, idx) : n;
        }

        @Override public String toString() {
            return "%s [%s] | %s | %s".formatted(name, state, email, phone);
        }      
        
    }
}
