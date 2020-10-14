package me.uwu.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import me.uwu.utils.ComboUtils;
import me.uwu.utils.FileUtils;
import me.uwu.utils.WebUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

public class Controller {

    public static Controller instance;

    public JFXButton openImportFile;
    public JFXButton openExportFile;

    public JFXTextField fieldInputCombo;
    public JFXTextField fieldOutputCombo;
    public JFXTextField fieldInputSplitter;
    public JFXTextArea comboArea;


    public Controller(){instance = this;}


    @FXML
    public void openFileImport(ActionEvent actionEvent) {
        selectFile(openImportFile, fieldInputCombo);
    }

    public void openExportFile(ActionEvent actionEvent) {
        selectFile(openExportFile, fieldOutputCombo);
    }

    private void selectFile(JFXButton openExportFile, JFXTextField fieldCombo) {
        Stage stage = (Stage) openExportFile.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open input file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        String[] out= selectedFile.getPath().split("\\.");
        fieldCombo.setText(selectedFile.getAbsolutePath());

        if(fieldOutputCombo.getText().length() < 2)

            fieldOutputCombo.setText(out[0] + "-out.txt");
    }

    public void importF(ActionEvent actionEvent) throws IOException {
        if (fieldInputCombo.getLength() < 2) return;
        comboArea.setText(FileUtils.fileToString(fieldInputCombo.getText()));
    }

    public void exportF(ActionEvent actionEvent) throws IOException {
        if (fieldOutputCombo.getLength() < 2) return;
        FileUtils.stringToFile(fieldOutputCombo.getText(), comboArea.getText());
    }

    public void credits(MouseEvent mouseEvent) throws URISyntaxException {
        WebUtils.openWebpage(new URI("https://discord.gg/fjzQ9AD"));
    }

    public void removeDuplicates(ActionEvent actionEvent) {
        comboArea.setText(ComboUtils.removeDuplicates(comboArea.getText()));
    }

    public void setUserPass(ActionEvent actionEvent) {
        comboArea.setText(ComboUtils.toUserPass(comboArea.getText()));
    }

    public void setLimit(KeyEvent inputMethodEvent) {
        if (fieldInputSplitter.getText().length() > 4) {
            String s = fieldInputSplitter.getText().substring(0, 4);
            fieldInputSplitter.setText(s);
        }
    }

    public void setSplitter(ActionEvent actionEvent) {
        ComboUtils.splitter = fieldInputSplitter.getText();
    }
}
