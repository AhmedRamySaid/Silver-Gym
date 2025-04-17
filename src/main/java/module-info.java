module asu.team_sixteen.silver_gym {
    requires javafx.controls;
    requires javafx.fxml;


    opens asu.team_sixteen.silver_gym to javafx.fxml;
    exports asu.team_sixteen.silver_gym;
    exports asu.team_sixteen.silver_gym.controllers;
    opens asu.team_sixteen.silver_gym.controllers to javafx.fxml;
}