package com.csc180;

public class Calculator {
    
    public void saySomething(String s) {
        System.out.println(s);
    }
    public double add(double num1, double num2){
        return num1 + num2;
    }
    public double sub(double num1, double num2){
        return num1 - num2;
    }
    public double dev(double num1, double num2){
        if(num2 == 0){
            System.out.println("Can not devide by zero");
        }else{
            return num1 / num2;
        }
        return 0;
    }
    public double malt(double num1, double num2){
        return num1 * num2;
    }
}