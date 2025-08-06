package com.example;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class App extends Application{
    private int clickAmount = 0;
    public static void main(String [] args){
        launch();
    }
    @Override
    public void start(@SuppressWarnings("exports") Stage stage){
        var button = new Button("Click Me!!!");
        var scene = new Scene(new StackPane(button), 640, 480);
        EventHandler<ActionEvent> onClick = (ActionEvent e) -> {
            addToCount();
            button.setText("Clicks: " + clickAmount + " WOW");
            System.out.println(clickAmount);
        };
        button.setOnAction(onClick);
        stage.setScene(scene);
        stage.show();
    }
    public void addToCount(){
        clickAmount++;
    }
}