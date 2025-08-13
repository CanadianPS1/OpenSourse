package com.example;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class App extends Application{
    private GridPane grid;
    private Scene scene;
    private Runnable timeRefresher;
    private Thread timeRefresherThread;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    @Override
    public void start(@SuppressWarnings("exports") Stage stage){
        //sets up my grid
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25,25,25,25));
        scene = new Scene(grid, 640, 480);
        stage.setScene(scene);
        stage.show();
        //makes all my moles
        Mole mole1 = new Mole(100, 5);
        Mole mole2 = new Mole(100, 5);
        Mole mole3 = new Mole(100, 5);
        Mole mole4 = new Mole(70, 1);
        Mole mole5 = new Mole(150, 5);
        Mole mole6 = new Mole(200, 12);
        Mole mole7 = new Mole(100, 5);
        Mole mole8 = new Mole(100, 5);
        Mole mole9 = new Mole(100, 5);
        Timer timer = new Timer(100);
        //makes a thread that will update the UI timer to keep up with the Timer Classes thread, among other tasks that need to happen at that time intervel
        timeRefresher = () -> {
            //updates time
            timer.getTime();
            System.out.println(timer.getTime());
            //checks if the moles are up, and if they are calls the method
            if(mole1.up)sendMoleUp(mole1);
            if(mole2.up)sendMoleUp(mole2);
            if(mole3.up)sendMoleUp(mole3);
            if(mole4.up)sendMoleUp(mole4);
            if(mole5.up)sendMoleUp(mole5);
            if(mole6.up)sendMoleUp(mole6);
            if(mole7.up)sendMoleUp(mole7);
            if(mole8.up)sendMoleUp(mole8);
            if(mole9.up)sendMoleUp(mole9); 
        };
        scheduler.scheduleAtFixedRate(timeRefresher, 0, 100, TimeUnit.MILLISECONDS);
        timeRefresherThread = new Thread(timeRefresher);
        //starts all my threads
        timeRefresherThread.start();
        timer.startTimer();
        mole1.startMole();
        mole2.startMole();
        mole3.startMole();
        mole4.startMole();
        mole5.startMole();
        mole6.startMole();
        mole7.startMole();
        mole8.startMole();
        mole9.startMole();
        
    }
    //will make the mole pop out of the hole
    public static void sendMoleUp(Mole mole){
        System.out.println("Mole Up");
    }
    public static void main(String [] args){launch();}
}