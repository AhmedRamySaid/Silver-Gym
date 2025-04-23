package asu.team_sixteen.silver_gym.controllers;

import asu.team_sixteen.silver_gym.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
    private PasswordField password_field;
    @FXML
    private PasswordField confirm_password_field;
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
                phone_number_field.setText(newValue.replaceAll("\\D", ""));
            }
        });
    }

    @FXML
    protected void onRegisterButtonClicked() throws IOException {
        if (first_name_field.getText().isEmpty() || last_name_field.getText().isEmpty() ||
                password_field.getText().isEmpty() || confirm_password_field.getText().isEmpty() ||
                phone_number_field.getText().isEmpty()) {
            Alert emptyFieldAlert = new Alert(Alert.AlertType.WARNING, "Please do not leave any of the fields empty");
            emptyFieldAlert.showAndWait();
            return;
        }

        if (first_name_field.getText().indexOf(' ') != -1 || last_name_field.getText().indexOf(' ') != -1) {
            Alert emptyFieldAlert = new Alert(Alert.AlertType.WARNING, "Names cannot contain spaces");
            emptyFieldAlert.showAndWait();
            return;
        }

        if (password_field.getText().length() < 8){
            Alert emptyFieldAlert = new Alert(Alert.AlertType.WARNING, "Password must be at least 8 characters long");
            emptyFieldAlert.showAndWait();
            return;
        }

        if (!password_field.getText().equals(confirm_password_field.getText())){
            Alert emptyFieldAlert = new Alert(Alert.AlertType.WARNING, "The passwords must match");
            emptyFieldAlert.showAndWait();
            return;
        }

        if (!isValidPhoneNumber(phone_number_field.getText())) {
            Alert emptyFieldAlert = new Alert(Alert.AlertType.WARNING, "Invalid phone number");
            emptyFieldAlert.showAndWait();
            return;
        }

        //todo
    }

    @FXML
    protected void onBackButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/main.fxml"));
        Parent node = fxmlLoader.load();
        Main.primaryStage.getScene().setRoot(node);
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        /*
        returns true if:
            1) Phone numbers starts with 01 (as all regular egyptian phone numbers do)
            2) The next digit is 0/1/2/5 (for the 4 mobile phone carriers in egypt)
            3) has exactly 8 more digits
         */
        return phoneNumber.matches("^01[0125][0-9]{8}$");
    }
}
