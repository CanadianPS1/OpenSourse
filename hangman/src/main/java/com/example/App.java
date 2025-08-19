package com.example;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class App extends Application{
    private EventHandler<ActionEvent> onClick;
    private GridPane grid;
    private Scene scene;
    private Label topBar1;
    private Label topBar2;
    private Label topBar3;
    private Label botBar1;
    private Label botBar2;
    private Label botBar3;
    private Label rightBar1;
    private Label rightBar2;
    private Label rightBar3;
    private final int height = 8;
    private final int width = 8;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    @Override
    public void start(Stage stage){
        //sets up my grid
        grid = new GridPane();
        //~creates the map~
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.println(j + " : " + i);
                grid.add(createSolidColorLabel("-fx-background-color: #d7d18fff;", 640, 480),width,height);
            }
        }
        //puts a boarder around the play area
        //creates the left border
        // grid.add(createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480),0,1);
        // grid.add(createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480),0,2);
        // grid.add(createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480),0,3);
        // //creates the top boarder
        // topBar1 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        // grid.add(topBar1,0,1);
        // GridPane.setValignment(topBar1, VPos.TOP);
        // topBar2 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        // grid.add(topBar2,1,1);
        // GridPane.setValignment(topBar2, VPos.TOP);
        // topBar3 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        // grid.add(topBar3,2,1);
        // GridPane.setValignment(topBar3, VPos.TOP);
        // //creates the bottom boarder
        // botBar1 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        // grid.add(botBar1,0,3);
        // GridPane.setValignment(botBar1, VPos.BOTTOM);
        // botBar2 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        // grid.add(botBar2,1,3);
        // GridPane.setValignment(botBar2, VPos.BOTTOM);
        // botBar3 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        // grid.add(botBar3,2,3);
        // GridPane.setValignment(botBar3, VPos.BOTTOM);
        // grid.add(createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480),0,1);
        // //creates the right boarder
        // rightBar1 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480);
        // grid.add(rightBar1,2,1);
        // GridPane.setHalignment(rightBar1, HPos.RIGHT);
        // rightBar2 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480);
        // grid.add(rightBar2,2,2);
        // GridPane.setHalignment(rightBar2, HPos.RIGHT);
        // rightBar3 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480);
        // grid.add(rightBar3,2,3);
        // GridPane.setHalignment(rightBar3, HPos.RIGHT);
        scene = new Scene(grid, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    public Label createSolidColorLabel(String styling, int width, int height){
        Label label = new Label();
        label.setStyle(styling);
        label.setPrefSize(width,height);
        return label;
    }
    public static void main(String [] args){launch();}
}