package csc180.roeback.lia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue0(){
        person john = new person();
        assertTrue(john.setPhoneNumber("111-111-1111"));
    }
    @Test
    public void shouldAnswerWithTrue1(){
        person john = new person();
        assertTrue(john.setName("John Milks Booth"));
    }
    @Test
    public void shouldAnswerWithTrue2(){
        person john = new person();
        assertTrue(john.setName("John Booth"));
    }





    @Test
    public void shouldAnswerWithFalse0(){
        person john = new person();
        assertFalse(john.setPhoneNumber("(111) 111-1111"));
    }
    @Test
    public void shouldAnswerWithFalse1(){
        person john = new person();
        assertFalse(john.setPhoneNumber("111- 111-1111"));
    }
    @Test
    public void shouldAnswerWithFalse2(){
        person john = new person();
        assertFalse(john.setPhoneNumber("111 - 111 - 1111"));
        assertFalse(john.setPhoneNumber("111 111-1111"));
        assertFalse(john.setPhoneNumber(" 111-111-1111"));
    }
    @Test
    public void shouldAnswerWithFalse3(){
        person john = new person();
        assertFalse(john.setPhoneNumber("111 111-1111"));
    }
    @Test
    public void shouldAnswerWithFalse4(){
        person john = new person();
        assertFalse(john.setPhoneNumber(" 111-111-1111"));
    }
    @Test
    public void shouldAnswerWithFalse5(){
        person john = new person();
        assertFalse(john.setName("JohnMilksBooth"));
    }
    @Test
    public void shouldAnswerWithFalse6(){
        person john = new person();
        assertFalse(john.setName(" John Milks Booth"));
    }
    @Test
    public void shouldAnswerWithFalse7(){
        person john = new person();
        assertFalse(john.setName("John Milks Booth "));
    }
    @Test
    public void shouldAnswerWithFalse8(){
        person john = new person();
        assertFalse(john.setName(" John Milks Booth "));
    }
    @Test
    public void shouldAnswerWithFalse9(){
        person john = new person();
        assertFalse(john.setName("JohnBooth"));
    }
    @Test
    public void shouldAnswerWithFalseA(){
        person john = new person();
        assertFalse(john.setName(" John Booth"));
    }
    @Test
    public void shouldAnswerWithFalseA1(){
        person john = new person();
        assertFalse(john.setName("John Booth "));
    }
    @Test
    public void shouldAnswerWithFalseA2(){
        person john = new person();
        assertFalse(john.setName(" John Booth "));
    }
    @Test
    public void shouldAnswerWithFalseA3(){
        person john = new person();
        assertFalse(john.setName("  John Booth"));
    }
    @Test
    public void shouldAnswerWithFalseA4(){
        person john = new person();
        assertFalse(john.setName("  John Milks Booth"));
    }
}
