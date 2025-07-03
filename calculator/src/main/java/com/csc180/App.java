package com.csc180;

public class App 
{
    public static void main(String [] args){
        Calculator c = new Calculator();
        System.out.println("Addition: " + c.add(2,4));
        System.out.println("Subtraction: " + c.sub(2,4));
        System.out.println("Maltiplication: " + c.malt(2,4));
        System.out.println("Devition: " + c.dev(2,4));
    }
}
