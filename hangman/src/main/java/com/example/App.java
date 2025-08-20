package com.example;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class App extends Application{
    private EventHandler<ActionEvent> onClick;
    private GridPane grid;
    private Scene scene;
    private final int height = 8;
    private final int width = 8;
    private final int barWidth = 15;
    private final String barColor = "#0e0d0cff";
    @Override
    public void start(@SuppressWarnings("exports") Stage stage){
        //sets up my grid
        grid = new GridPane();
        //~creates the map~
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                grid.add(createSolidColorLabel("-fx-background-color: #f5e6b5ff;", 640,480),j,i);
            }
        }
        //top
        for(int i = 0; i < width; i++){
            Label bar;
            bar = createSolidColorLabel("-fx-background-color: " + barColor, 680,barWidth);
            grid.add(bar,i,height-(height));
            GridPane.setValignment(bar, VPos.TOP);
        }
        //right
        for(int i = 0; i < width; i++){
            //if(i > (height - (height))){
                Label bar;
                bar = createSolidColorLabel("-fx-background-color: " + barColor, barWidth,480);
                grid.add(bar,width-1,i);
                GridPane.setHalignment(bar, HPos.RIGHT);
            //}
        }
        //left
        for(int i = 0; i < height; i++){
            //if(i > (height - (height))){
                Label bar;
                bar = createSolidColorLabel("-fx-background-color: " + barColor, barWidth,480);
                grid.add(bar,0,i);
                GridPane.setHalignment(bar, HPos.LEFT);
            //}
        }
        //bottom
        for(int i = 0; i < width; i++){
            Label bar;
            bar = createSolidColorLabel("-fx-background-color: " + barColor, 680,barWidth);
            grid.add(bar,i,height-1);
            GridPane.setValignment(bar, VPos.BOTTOM);
        }
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