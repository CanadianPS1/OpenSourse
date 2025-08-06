package com.example;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class App extends Application{
    private EventHandler<ActionEvent> onClick;
    private int clickAmount = 0;
    private Button button;
    private Scene scene;
    @Override
    public void start(@SuppressWarnings("exports") Stage stage){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        button = new Button("Click Me!!!");
        scene = new Scene(new StackPane(button), 640, 480);
        onClick = (ActionEvent e) -> {
            addToCount();
            button.setText("Clicks: " + clickAmount + " WOW");
            System.out.println(clickAmount);
        };
        button.setOnAction(onClick);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String [] args){
        launch();
    }
    public void addToCount(){
        clickAmount++;
    }
    
}