package com.example;
import java.lang.reflect.Array;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
public class App extends Application{
    private EventHandler<ActionEvent> onClick;
    private final Random rand = new Random();
    private GridPane grid;
    private Scene scene;
    private final int height = 8;
    private final int width = 7;
    private final int barWidth = 15;
    private final String barColor = "#0e0d0cff";
    private final String words[] = {"lunch","gunch","jhost","bikle","gorba","yoooo","spill","faker","metal","major","snake","solid","eeeep","hideo","beach","thing","birdo"
                                    ,"based","gandr","gamba","risky","among","green","video","games","flood","brock","water","milky","mamma","apple","david","sandy","ranch"
                                    ,"beans","montr","huntr" ,"sussy","sigma"};
    private String word = words[rand.nextInt(words.length - 1)];
    private Text wordSpot1;
    private Text wordSpot2;
    private Text wordSpot3;
    private Text wordSpot4;
    private Text wordSpot5;
    private int score = 0;
    private int life = 7;
    private Label head = new Label();
    private Label body = new Label();
    private Label leftArm = new Label();
    private Label rightArm = new Label();
    private Label leftLeg = new Label();
    private Label rightLeg = new Label();
    private String regex = "[ a b c d e f g h i j k l m n o p q r s t u v w x y z A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ]";
    @Override
    public void start(@SuppressWarnings("exports") Stage stage){
        //sets up my grid
        grid = new GridPane();
        //~creates the map~
        for(int i = 0; i < height; i++){for(int j = 0; j < width; j++){grid.add(createSolidColorLabel("-fx-background-color: #f5e6b5ff;", 640,480),j,i);}}
        //top
        for(int i = 0; i < width; i++){
            Label bar;
            bar = createSolidColorLabel("-fx-background-color: " + barColor, 680,barWidth);
            grid.add(bar,i,height-(height));
            GridPane.setValignment(bar, VPos.TOP);
        }
        //right
        for(int i = 0; i < height; i++){
            Label bar;
            bar = createSolidColorLabel("-fx-background-color: " + barColor, barWidth,480);
            grid.add(bar,width-1,i);
            GridPane.setHalignment(bar, HPos.RIGHT);
        }
        //left
        for(int i = 0; i < height; i++){
            Label bar;
            bar = createSolidColorLabel("-fx-background-color: " + barColor, barWidth,480);
            grid.add(bar,0,i);
            GridPane.setHalignment(bar, HPos.LEFT);
        }
        //bottom
        for(int i = 0; i < width; i++){
            Label bar;
            bar = createSolidColorLabel("-fx-background-color: " + barColor, 680,barWidth);
            grid.add(bar,i,height-1);
            GridPane.setValignment(bar, VPos.BOTTOM);
        }
        wordSpot1 = createText();
        wordSpot2 = createText();
        wordSpot3 = createText();
        wordSpot4 = createText();
        wordSpot5 = createText();
        grid.add(wordSpot1,1,1);
        grid.add(wordSpot2,2,1);
        grid.add(wordSpot3,3,1);
        grid.add(wordSpot4,4,1);
        grid.add(wordSpot5,5,1);
        Button guessButton = new Button("GUESS");
        guessButton.setStyle("-fx-background-color: #99458eff");
        guessButton.setPrefSize(680, 400);
        grid.add(guessButton,3,6);
        TextArea guessBox = new TextArea();
        guessBox.setWrapText(true);
        guessBox.setStyle("-fx-text-alignment: center; -fx-font-size: 30px;");
        guessBox.setPrefSize(10,50);
        grid.add(guessBox,3,4);


        Image headImage = new Image(getClass().getResource("/head.png").toExternalForm());
        ImageView headImageView = new ImageView(headImage);
        headImageView.setFitHeight(100);
        headImageView.setFitHeight(100);
        headImageView.setPreserveRatio(true);
        head.setGraphic(headImageView);

        Image bodyImage = new Image(getClass().getResource("/body.png").toExternalForm());
        ImageView bodyImageView = new ImageView(bodyImage);
        bodyImageView.setFitHeight(100);
        bodyImageView.setFitHeight(100);
        bodyImageView.setPreserveRatio(true);
        body.setGraphic(bodyImageView);

        Image leftArmImage = new Image(getClass().getResource("/LeftArm.png").toExternalForm());
        ImageView leftArmImageView = new ImageView(leftArmImage);
        leftArmImageView.setFitHeight(100);
        leftArmImageView.setFitHeight(100);
        leftArmImageView.setPreserveRatio(true);
        leftArm.setGraphic(leftArmImageView);

        Image rightArmImage = new Image(getClass().getResource("/RightArm.png").toExternalForm());
        ImageView rightArmImageView = new ImageView(rightArmImage);
        rightArmImageView.setFitHeight(100);
        rightArmImageView.setFitHeight(100);
        rightArmImageView.setPreserveRatio(true);
        rightArm.setGraphic(rightArmImageView);

        Image leftLegImage = new Image(getClass().getResource("/LeftLeg.png").toExternalForm());
        ImageView leftLegImageView = new ImageView(leftLegImage);
        leftLegImageView.setFitHeight(100);
        leftLegImageView.setFitHeight(100);
        leftLegImageView.setPreserveRatio(true);
        leftLeg.setGraphic(leftLegImageView);

        Image rightLegImage = new Image(getClass().getResource("/RightLeg.png").toExternalForm());
        ImageView rightLegImageView = new ImageView(rightLegImage);
        rightLegImageView.setFitHeight(100);
        rightLegImageView.setFitHeight(100);
        rightLegImageView.setPreserveRatio(true);
        rightLeg.setGraphic(rightLegImageView);

        head.setVisible(false);
        body.setVisible(false);
        leftArm.setVisible(false);
        rightArm.setVisible(false);
        leftLeg.setVisible(false);
        rightLeg.setVisible(false);

        grid.add(head,5,3);
        grid.add(body,5,4);
        grid.add(leftArm,5,4);
        grid.add(rightArm,5,4);
        grid.add(leftLeg,5,5);
        grid.add(rightLeg,5,5);

        onClick = (ActionEvent e) -> {
            if(life != 0 && score < 5){
                String guess = guessBox.getText();
                guessBox.setText("");
                if(guess.matches(regex)){
                    if(regex.contains(guess.toLowerCase())){
                        StringBuilder regexBuilder = new StringBuilder(regex);
                        regexBuilder.setCharAt(regex.indexOf(guess.toLowerCase()),'ü');
                        regexBuilder.setCharAt(regex.indexOf(guess.toUpperCase()),'ü');
                        regex = regexBuilder.toString();
                    }
                    if(word.contains(guess)){
                        if(word.charAt(0) == guess.charAt(0)){
                            wordSpot1.setText(guess.toUpperCase());
                            score++;
                        }
                        if(word.charAt(1) == guess.charAt(0)){
                            wordSpot2.setText(guess.toUpperCase());
                            score++;
                        }
                        if(word.charAt(2) == guess.charAt(0)){
                            wordSpot3.setText(guess.toUpperCase());
                            score++;
                        }
                        if(word.charAt(3) == guess.charAt(0)){
                            wordSpot4.setText(guess.toUpperCase());
                            score++;
                        }
                        if(word.charAt(4) == guess.charAt(0)){
                            wordSpot5.setText(guess.toUpperCase());
                            score++;
                        }
                        if(score == 5){
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),3,1);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),3,2);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),3,3);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),2,1);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),2,2);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),2,3);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),4,1);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),4,2);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),4,3);
                            Text winMessage = new Text("YOU WON!!!");
                            winMessage.setStyle("-fx-text-alignment: center; -fx-font-size: 30px;");
                            grid.add(winMessage,3,2);
                        }
                    }else{
                        life--;
                        if(life == 6)head.setVisible(true);
                        else if(life == 5)body.setVisible(true);
                        else if (life == 4)leftArm.setVisible(true);
                        else if(life == 3)rightArm.setVisible(true);
                        else if(life == 2)leftLeg.setVisible(true);
                        else if(life == 1){
                            rightLeg.setVisible(true);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),3,1);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),3,2);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),3,3);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),2,1);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),2,2);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),2,3);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),4,1);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),4,2);
                            grid.add(createSolidColorLabel("-fx-background-color: #d3b349ff;", 640,480),4,3);
                            Text loseMessage = new Text("YOU SUCK!!!");
                            loseMessage.setStyle("-fx-text-alignment: center; -fx-font-size: 30px;");
                            grid.add(loseMessage,3,2);
                        }
                    }
                }
            }
        };
        guessButton.setOnAction(onClick);
        scene = new Scene(grid, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    @SuppressWarnings("exports")
    public Text createText(){
        Text area = new Text("_");
        area.setStyle("-fx-text-alignment: center; -fx-font-size: 30px;");
        area.setTextAlignment(TextAlignment.CENTER);
        return area;
    }
    @SuppressWarnings("exports")
    public Label createSolidColorLabel(String styling, int width, int height){
        Label label = new Label();
        label.setStyle(styling);
        label.setPrefSize(width,height);
        return label;
    }
    public static void main(String [] args){launch();}
}