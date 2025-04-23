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

public class RegisterController implements Initializable {
    @FXML
    private TextField first_name_field;
    @FXML
    private TextField last_name_field;
    @FXML
    private TextField password_field;
    @FXML
    private TextField confirm_password_field;
    @FXML
    private TextField phone_number_field;
    @FXML
    private Button register_button;
    @FXML
    private Button back_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        first_name_field.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(6));
        first_name_field.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(15));

        last_name_field.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(6));
        last_name_field.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(15));

        password_field.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(3));
        password_field.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(15));

        confirm_password_field.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(3));
        confirm_password_field.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(15));

        phone_number_field.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(3));
        phone_number_field.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(15));

        register_button.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(6));
        register_button.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(15));

        back_button.prefWidthProperty().bind(Main.primaryStage.widthProperty().divide(7));
        back_button.prefHeightProperty().bind(Main.primaryStage.heightProperty().divide(20));

        phone_number_field.textProperty().addListener((_, _, newValue) -> {
            // Checks if the input is not a number
            if(!newValue.matches("\\d*")){
                // Removes all non-number characters
                phone_number_field.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    protected void onRegisterButtonClicked() throws IOException {
        //todo
    }

    @FXML
    protected void onBackButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/main.fxml"));
        Parent node = fxmlLoader.load();
        Main.primaryStage.getScene().setRoot(node);
    }
}
