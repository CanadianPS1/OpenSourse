package com.example;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class Timer extends App{
    private Runnable timer;
    private int timeLeft;
    private final Thread time;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public Timer(int tl){
        timeLeft = tl;
        timer = () -> {
            timeLeft--;
        };
        scheduler.scheduleAtFixedRate(timer, 0, 1000, TimeUnit.MILLISECONDS);
        time = new Thread(timer);
    }
    public void startTimer(){time.start();}
    private String getTime(){
        return (timeLeft / 60) + ":" + (timeLeft % 60);
    }
}
