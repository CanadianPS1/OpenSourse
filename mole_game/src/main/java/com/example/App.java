package com.example;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.geometry.VPos;
import javafx.geometry.HPos;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

        //sets up the timer
        TextField timeDisplay = new TextField();
        timeDisplay.setStyle("-fx-text-fill: white; -fx-background-color: #e0e0e0ff; -fx-font-size: 30px; -fx-background-color: transparent;");
        timeDisplay.setEditable(false);
        timeDisplay.setAlignment(Pos.CENTER);
        timeDisplay.setText("00:00");


        //~creates the map~
        //creates the Bar for the timer and score to sit on
        grid.add(createSolidColorLabel("-fx-background-color: #2E2E2E;", 640, 100),0,0);
        grid.add(createSolidColorLabel("-fx-background-color: #2E2E2E;", 640, 100),1,0);
        grid.add(createSolidColorLabel("-fx-background-color: #2E2E2E;", 640, 100),2,0);
        grid.add(timeDisplay,1,0);


        //creates the play area
        //creates the first row of map
        grid.add(createSolidColorLabel("-fx-background-color: #468f46ff;", 640, 380),0,1);
        grid.add(createSolidColorLabel("-fx-background-color: #468f46ff;", 640, 380),1,1);
        grid.add(createSolidColorLabel("-fx-background-color: #468f46ff;", 640, 380),2,1);

        //creates the second row of map
        grid.add(createSolidColorLabel("-fx-background-color: #468f46ff;", 640, 380),0,2);
        grid.add(createSolidColorLabel("-fx-background-color: #468f46ff;", 640, 380),1,2);
        grid.add(createSolidColorLabel("-fx-background-color: #468f46ff;", 640, 380),2,2);

        //creates the third row of map
        grid.add(createSolidColorLabel("-fx-background-color: #468f46ff;", 640, 380),0,3);
        grid.add(createSolidColorLabel("-fx-background-color: #468f46ff;", 640, 380),1,3);
        grid.add(createSolidColorLabel("-fx-background-color: #468f46ff;", 640, 380),2,3);


        //puts a boarder around the play area
        //creates the left border
        grid.add(createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480),0,1);
        grid.add(createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480),0,2);
        grid.add(createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480),0,3);

        //creates the top boarder
        Label topBar1 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(topBar1,0,1);
        GridPane.setValignment(topBar1, VPos.TOP);
        Label topBar2 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(topBar2,1,1);
        GridPane.setValignment(topBar2, VPos.TOP);
        Label topBar3 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(topBar3,2,1);
        GridPane.setValignment(topBar3, VPos.TOP);


        //creates the bottom boarder
        Label botBar1 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(botBar1,0,3);
        GridPane.setValignment(botBar1, VPos.BOTTOM);
        Label botBar2 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(botBar2,1,3);
        GridPane.setValignment(botBar2, VPos.BOTTOM);
        Label botBar3 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(botBar3,2,3);
        GridPane.setValignment(botBar3, VPos.BOTTOM);
        grid.add(createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480),0,1);


        //creates the right boarder
        Label rightBar1 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480);
        grid.add(rightBar1,2,1);
        GridPane.setHalignment(rightBar1, HPos.RIGHT);
        Label rightBar2 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480);
        grid.add(rightBar2,2,2);
        GridPane.setHalignment(rightBar2, HPos.RIGHT);
        Label rightBar3 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480);
        grid.add(rightBar3,2,3);
        GridPane.setHalignment(rightBar3, HPos.RIGHT);
        
        
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
            timeDisplay.setText(timer.getTime());
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
    @SuppressWarnings("exports")
    public Label createSolidColorLabel(String styling, int width, int height){
        Label label = new Label();
        label.setStyle(styling);
        label.setPrefSize(width,height);
        return label;
    }
    //will make the mole pop out of the hole
    public static void sendMoleUp(Mole mole){
        System.out.println("Mole Up");
    }
    public static void main(String [] args){launch();}
}