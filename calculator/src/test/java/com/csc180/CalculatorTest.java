package com.csc180;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
 
public class CalculatorTest {
 
    Calculator calc = new Calculator();
    @Test
    void testAdd(){
        assertEquals(5.0,calc.add(2.0,3.0));
    }
    @Test
    void testSub(){
        assertEquals(1.0,calc.sub(2.0,1.0));
    }
    @Test
    void testMalt(){
        assertEquals(10.0,calc.malt(5.0,2.0));
    }
    @Test
    void testDev(){
        assertEquals(5.0,calc.dev(10.0,2.0));
    }
   
}