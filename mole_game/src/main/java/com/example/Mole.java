package com.example;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class Mole{
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Thread jumpChecker;
    private final int chanceConst;
    private final int increment;
    private Runnable jumping;
    private int chance;
    public boolean up;
    public Mole(int c, int i){
        chanceConst = c;
        increment = i;
        up = false;
        chance = c;
        jumping();
        jumpChecker = new Thread(jumping);
        scheduler.scheduleAtFixedRate(jumping, 0, 500, TimeUnit.MILLISECONDS);
    }
    public void startMole(){jumpChecker.start();}
    //checks for if the mole passed the check, and if it does then the mole will pop up
    public final void jumping(){
        jumping = () -> {
            Random rand = new Random();
            int randInt = rand.nextInt(chance) + 1;
            if(randInt == 1){
                chance = chanceConst;
                up = true;
            }else{
                up = false;
                if(!(chance <= 5))chance -= increment;
            }
        };
    }
}
