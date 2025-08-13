package com.example;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class App extends Application{
    private GridPane grid;
    private Scene scene;
    @Override
    public void start(@SuppressWarnings("exports") Stage stage){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25,25,25,25));
        scene = new Scene(grid, 640, 480);
        stage.setScene(scene);
        stage.show();
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
    public static void main(String [] args){
        launch();
    }
}