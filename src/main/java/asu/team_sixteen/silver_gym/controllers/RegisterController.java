package asu.team_sixteen.silver_gym.controllers;

import asu.team_sixteen.silver_gym.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField phone_number;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        phone_number.textProperty().addListener((_, _, newValue) -> {
            // Checks if the input is not a number
            if(!newValue.matches("\\d*")){
                // Removes all non-number characters
                phone_number.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    protected void onBackButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/main.fxml"));
        Parent node = fxmlLoader.load();
        Main.primaryStage.getScene().setRoot(node);
    }
}
