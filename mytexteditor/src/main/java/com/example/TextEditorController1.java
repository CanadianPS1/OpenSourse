package com.example; 
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
@SuppressWarnings("unused")
public class TextEditorController1 {
    @FXML
    private TextArea textArea;
    @FXML
    private Label statusLabel;
    @FXML
    private void handleOpen(){
        System.out.println("Open clicked");
    }
    @FXML
    private void handleSave(){  
        System.out.println("Save clicked");
    }
    @FXML
    private void handleAbout(){
        System.out.println("About clicked");
    }
}
