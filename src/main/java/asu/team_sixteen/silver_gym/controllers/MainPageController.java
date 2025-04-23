package asu.team_sixteen.silver_gym.controllers;

import asu.team_sixteen.silver_gym.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    @FXML
    Button login_button;
    @FXML
    Button signup_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_button.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(5));
        login_button.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(10));

        signup_button.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(5));
        signup_button.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(10));
    }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/login.fxml"));
        Parent node = fxmlLoader.load();
        Main.primaryStage.getScene().setRoot(node);
    }
    @FXML
    protected void onSignupButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/register.fxml"));
        Parent node = fxmlLoader.load();
        Main.primaryStage.getScene().setRoot(node);
    }
}