package asu.team_sixteen.silver_gym.controllers;

import asu.team_sixteen.silver_gym.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    TextField customer_ID_field;
    @FXML
    TextField password_field;
    @FXML
    Button login_button;
    @FXML
    Button back_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customer_ID_field.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(3));
        customer_ID_field.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(10));

        password_field.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(3));
        password_field.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(10));

        login_button.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(5));
        login_button.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(10));

        back_button.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(7));
        back_button.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(15));
    }

    @FXML
    protected void onLoginButtonClicked() throws IOException {
        //todo
    }

    @FXML
    protected void onBackButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/main.fxml"));
        Parent node = fxmlLoader.load();
        Main.primaryStage.getScene().setRoot(node);
    }
}