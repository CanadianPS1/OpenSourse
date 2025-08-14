package com.example;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class Timer{
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Runnable timer;
    private final Thread time;
    private int timeLeft;
    public Timer(int tl){
        timeLeft = tl;
        //makes a thread that will start a count down from the user inputed time
        timer = () -> { timeLeft--;};
        scheduler.scheduleAtFixedRate(timer, 0, 1000, TimeUnit.MILLISECONDS);
        time = new Thread(timer);
    }
    public void startTimer(){time.start();}
    public String getTime(){
        //parses the ints into a string in a time format
        int min = timeLeft / 60;
        String sec = timeLeft % 60 + "";
        if(Integer.parseInt(sec) < 10)sec = "0" + sec;
        if((min + ":" + sec).equals("0:00")){
            return "Game Over";
        }else{
            return min + ":" + sec;
        }
            
    }
}
