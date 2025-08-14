package com.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LambdasAndStreams lad = new LambdasAndStreams();

        Path jsonPath = Paths.get("lambda.people.json"); // adjust if your file lives elsewhere
        List<LambdasAndStreams.Person> people;

        
        if (!Files.exists(jsonPath)) {
            System.err.println("File not found: " + jsonPath.toAbsolutePath());
            return;
        }

        try {
            people = lad.readPeople(jsonPath);
        } catch (IOException e) {
            System.err.println("Failed to read or parse JSON: " + jsonPath.toAbsolutePath());
            e.printStackTrace();
            return;
        }        
    }
}



