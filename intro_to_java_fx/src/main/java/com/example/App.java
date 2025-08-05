package com.example;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class App extends Application{
    public static void main(String [] args){
        launch();
    }
    @Override
    public void start(@SuppressWarnings("exports") Stage stage){
        int clickAmount = 0;
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        var label = new Label("You have Clicked the Button " + clickAmount + " times WOW");
        var scene = new Scene(new StackPane(label), 640, 480);
        var button = new Button("Click Me!!!");
        EventHandler<ActionEvent> onClick = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                clickAmount += 1;
                label.setText("You have Clicked the Button " + clickAmount + " times WOW");
            }
        };
        button.setOnAction(onClick);
        stage.setScene(scene);
        stage.show();
    }
}