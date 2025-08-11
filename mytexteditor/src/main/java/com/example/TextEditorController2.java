package com.example;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
@SuppressWarnings("CallToPrintStackTrace")
public class TextEditorController2{
    @FXML
    private TextArea textArea;
    @FXML
    private Label statusLabel;
    @FXML
    @SuppressWarnings("unused")
    private void handleOpen(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.log", "*.md"));
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            try{
                String content = Files.readString(file.toPath());
                textArea.setText(content);
                statusLabel.setText("File loaded: " + file.getName());
            }catch(IOException e){
                statusLabel.setText("Failed to open file: " + file.getName());
                e.printStackTrace();
            }
        }
    }
    @FXML
    @SuppressWarnings("unused")
    private void handleSave(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Text File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        fileChooser.setInitialFileName("untitled.txt");
        File file = fileChooser.showSaveDialog(null);
        if(file != null){
            try{
                Files.writeString(file.toPath(), textArea.getText());
                statusLabel.setText("Saved to: " + file.getName());
            }catch(IOException e){
                statusLabel.setText("Failed to save file.");
                e.printStackTrace();
            }
        }
    }
    @FXML
    @SuppressWarnings("unused")
    private void handleAbout(){
        System.out.println("About clicked (not implemented yet)");
    }
}
   