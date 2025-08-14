package com.example;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.geometry.VPos;
import javafx.geometry.HPos;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class App extends Application{
    private EventHandler<ActionEvent> onClick;
    private GridPane grid;
    private Scene scene;
    private Runnable timeRefresher;
    private Thread timeRefresherThread;
    private TextField timeDisplay;
    private TextField scoreDisplay;
    private Label topBar1;
    private Label topBar2;
    private Label topBar3;
    private Label botBar1;
    private Label botBar2;
    private Label botBar3;
    private Label rightBar1;
    private Label rightBar2;
    private Label rightBar3;
    private Button mole1Button;
    private Button mole2Button;
    private Button mole3Button;
    private Button mole4Button;
    private Button mole5Button;
    private Button mole6Button;
    private Button mole7Button;
    private Button mole8Button;
    private Button mole9Button;
    private int score = 0;
    private boolean gameOver = false;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    @Override
    public void start(@SuppressWarnings("exports") Stage stage){
        //sets up my grid
        grid = new GridPane();
        //sets up the timer
        timeDisplay = new TextField();
        timeDisplay.setStyle("-fx-text-fill: white; -fx-background-color: #e0e0e0ff; -fx-font-size: 30px; -fx-background-color: transparent;");
        timeDisplay.setEditable(false);
        timeDisplay.setAlignment(Pos.CENTER);
        timeDisplay.setText("00:00");
        scoreDisplay = new TextField();
        scoreDisplay.setStyle("-fx-text-fill: white; -fx-background-color: #e0e0e0ff; -fx-font-size: 30px; -fx-background-color: transparent;");
        scoreDisplay.setEditable(false);
        scoreDisplay.setAlignment(Pos.CENTER);
        scoreDisplay.setText(score + "");
        //~creates the map~
        //creates the Bar for the timer and score to sit on
        grid.add(createSolidColorLabel("-fx-background-color: #2E2E2E;", 640, 100),0,0);
        grid.add(createSolidColorLabel("-fx-background-color: #2E2E2E;", 640, 100),1,0);
        grid.add(createSolidColorLabel("-fx-background-color: #2E2E2E;", 640, 100),2,0);
        grid.add(timeDisplay,1,0);
        grid.add(scoreDisplay,0,0);
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
        topBar1 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(topBar1,0,1);
        GridPane.setValignment(topBar1, VPos.TOP);
        topBar2 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(topBar2,1,1);
        GridPane.setValignment(topBar2, VPos.TOP);
        topBar3 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(topBar3,2,1);
        GridPane.setValignment(topBar3, VPos.TOP);
        //creates the bottom boarder
        botBar1 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(botBar1,0,3);
        GridPane.setValignment(botBar1, VPos.BOTTOM);
        botBar2 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(botBar2,1,3);
        GridPane.setValignment(botBar2, VPos.BOTTOM);
        botBar3 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 680, 20);
        grid.add(botBar3,2,3);
        GridPane.setValignment(botBar3, VPos.BOTTOM);
        grid.add(createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480),0,1);
        //creates the right boarder
        rightBar1 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480);
        grid.add(rightBar1,2,1);
        GridPane.setHalignment(rightBar1, HPos.RIGHT);
        rightBar2 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480);
        grid.add(rightBar2,2,2);
        GridPane.setHalignment(rightBar2, HPos.RIGHT);
        rightBar3 = createSolidColorLabel("-fx-background-color: #1c2b1cff", 20, 480);
        grid.add(rightBar3,2,3);
        GridPane.setHalignment(rightBar3, HPos.RIGHT);
        scene = new Scene(grid, 640, 480);
        stage.setScene(scene);
        stage.show();
        //makes all my moles
        Mole mole1 = new Mole(100, 5,1);
        Mole mole2 = new Mole(100, 5,2);
        Mole mole3 = new Mole(100, 5,3);
        Mole mole4 = new Mole(70, 1,4);
        Mole mole5 = new Mole(150, 5,5);
        Mole mole6 = new Mole(200, 12,6);
        Mole mole7 = new Mole(100, 5,7);
        Mole mole8 = new Mole(100, 5,8);
        Mole mole9 = new Mole(100, 5,9);
        Timer timer = new Timer(90);
        mole1Button = createMoleButton();
        mole2Button = createMoleButton();
        mole3Button = createMoleButton();
        mole4Button = createMoleButton();
        mole5Button = createMoleButton();
        mole6Button = createMoleButton();
        mole7Button = createMoleButton();
        mole8Button = createMoleButton();
        mole9Button = createMoleButton();
        grid.add(mole1Button, 0, 1);
        grid.add(mole2Button, 1, 1);
        grid.add(mole3Button, 2, 1);
        grid.add(mole4Button, 0, 2);
        grid.add(mole5Button, 1, 2);
        grid.add(mole6Button, 2, 2);
        grid.add(mole7Button, 0, 3);
        grid.add(mole8Button, 1, 3);
        grid.add(mole9Button, 2, 3);
        //starts all my threads
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
        //makes a thread that will update the UI timer to keep up with the Timer Classes thread, among other tasks that need to happen at that time intervel
        timeRefresher = () -> {
            //updates time
            Platform.runLater(() -> {
                timeDisplay.setText(timer.getTime());
                if(timeDisplay.getText().equals("Game Over")){
                    timeDisplay.setVisible(false);
                    gameEnd();
                }
            });
            //checks if the moles are up, and if they are calls the method
            if(mole1.up)sendMoleUp(mole1Button);
            else sendMoleDown(mole1Button);
            if(mole2.up)sendMoleUp(mole2Button);
            else sendMoleDown(mole2Button);
            if(mole3.up)sendMoleUp(mole3Button);
            else sendMoleDown(mole3Button);
            if(mole4.up)sendMoleUp(mole4Button);
            else sendMoleDown(mole4Button);
            if(mole5.up)sendMoleUp(mole5Button);
            else sendMoleDown(mole5Button);
            if(mole6.up)sendMoleUp(mole6Button);
            else sendMoleDown(mole6Button);
            if(mole7.up)sendMoleUp(mole7Button);
            else sendMoleDown(mole7Button);
            if(mole8.up)sendMoleUp(mole8Button);
            else sendMoleDown(mole8Button);
            if(mole9.up)sendMoleUp(mole9Button); 
            else sendMoleDown(mole9Button);
        };
        scheduler.scheduleAtFixedRate(timeRefresher, 0, 100, TimeUnit.MILLISECONDS);
        timeRefresherThread = new Thread(timeRefresher);
        timeRefresherThread.start();
    }
    public Button createMoleButton(){
        Button button = new Button();
        Platform.runLater(() -> {button.setGraphic(getAliveImage());});
        button.setStyle("-fx-background-color: transparent; -fx-padding: 20 20 20 50;");
        button.setVisible(false);
        button.setText("");
        onClick = (ActionEvent e) -> {
            button.setGraphic(getDeadImage());
            score++;
            scoreDisplay.setText(score + "");
        };
        button.setOnAction(onClick);
        return button;
    }
    public Label createSolidColorLabel(String styling, int width, int height){
        Label label = new Label();
        label.setStyle(styling);
        label.setPrefSize(width,height);
        return label;
    }
    public ImageView getAliveImage(){
        Image moleAlive = new Image(getClass().getResource("/mole.png").toExternalForm());
        ImageView moleAliveView = new ImageView(moleAlive);
        moleAliveView.setFitHeight(100);
        moleAliveView.setFitHeight(100);
        moleAliveView.setPreserveRatio(true);
        return moleAliveView;
    }
    public ImageView getDeadImage(){
        Image moleDead = new Image(getClass().getResource("/moleDead.png").toExternalForm());
        ImageView moleDeadView = new ImageView(moleDead);
        moleDeadView.setFitHeight(100);
        moleDeadView.setFitHeight(100);
        moleDeadView.setPreserveRatio(true);
        return moleDeadView;
    }

    //will make the mole pop out of the hole
    public void sendMoleUp(Button moleButton){
        if(!moleButton.isVisible()){
            Platform.runLater(() -> {moleButton.setGraphic(getAliveImage());});
            moleButton.setVisible(true);
        }
    }
    public void gameEnd(){
        if(!gameOver){
            gameOver = true;
            grid.add(createSolidColorLabel("-fx-background-color: #c6dfc6ff", 680, 480),0,1);
            grid.add(createSolidColorLabel("-fx-background-color: #c6dfc6ff", 680, 480),1,1);
            grid.add(createSolidColorLabel("-fx-background-color: #c6dfc6ff", 680, 480),2,1);
            grid.add(createSolidColorLabel("-fx-background-color: #c6dfc6ff", 680, 480),0,2);
            grid.add(createSolidColorLabel("-fx-background-color: #c6dfc6ff", 680, 480),0,2);
            grid.add(createSolidColorLabel("-fx-background-color: #c6dfc6ff", 680, 480),0,2);
            grid.add(createSolidColorLabel("-fx-background-color: #c6dfc6ff", 680, 480),0,3);
            \grid.add(createSolidColorLabel("-fx-background-color: #c6dfc6ff", 680, 480),0,3);
            grid.add(createSolidColorLabel("-fx-background-color: #c6dfc6ff", 680, 480),0,3);
        }
    }
    public void sendMoleDown(Button moleButton){if(moleButton.isVisible())moleButton.setVisible(false);}
    public static void main(String [] args){launch();}
}