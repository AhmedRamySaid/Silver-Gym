package asu.team_sixteen.silver_gym.controllers;

import asu.team_sixteen.silver_gym.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    Button loginButton;
    @FXML
    Button signupButton;

    @FXML
    protected void onLoginButtonClick() {

    }
    @FXML
    protected void onSignupButtonClick() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(5));
        loginButton.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(10));

        signupButton.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(5));
        signupButton.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(10));
    }
}