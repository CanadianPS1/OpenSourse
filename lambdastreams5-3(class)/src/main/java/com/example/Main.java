package com.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
public class Main {
    @SuppressWarnings({"UnnecessaryReturnStatement", "CallToPrintStackTrace"})
    public static void main(String [] args){
        LambdasAndStreams lad = new LambdasAndStreams();
        //adjust if your file lives elsewhere
        Path jsonPath = Paths.get("OpenSourse\\lambdastreams5-3(class)\\lambda.people.json");
        List<LambdasAndStreams.Person> people;
        if(!Files.exists(jsonPath)){
            System.err.println("File not found: " + jsonPath.toAbsolutePath());
            return;
        }
        try{people = lad.readPeople(jsonPath);}
        catch(IOException e){
            System.err.println("Failed to read or parse JSON: " + jsonPath.toAbsolutePath());
            e.printStackTrace();
            return;
        }
        Set<LambdasAndStreams.Person> fl = lad.peopleInFlorida(people);
        var netOrRtoT = lad.emailEndsWithNetOrFirstNameBetweenRtoT(people);
        var utIaByPhone = lad.inUtahOrIowaSortedByPhone(people);
        System.out.println("FL count = " + fl.size());
        System.out.println(".net OR R–T = " + netOrRtoT.size());
        System.out.println("UT/IA first: " + (utIaByPhone.isEmpty() ? "(none)" : utIaByPhone.get(0))); 
    }
}