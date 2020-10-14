package me.uwu.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class Controller {

    public static Controller instance;

    public JFXButton openImportFile;
    public JFXButton openExportFile;

    public JFXTextField fieldInputCombo;
    public JFXTextField fieldOutputCombo;

    public Controller(){instance = this;}


    @FXML
    public void openFileImport(ActionEvent actionEvent) {
        selectFile(openImportFile, fieldInputCombo);
    }

    public void openExportFile(ActionEvent actionEvent) {
        selectFile(openExportFile, fieldOutputCombo);
    }

    private void selectFile(JFXButton openExportFile, JFXTextField fieldOutputCombo) {
        Stage stage = (Stage) openExportFile.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open input file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        fieldOutputCombo.setText(selectedFile.getAbsolutePath());
    }
}
