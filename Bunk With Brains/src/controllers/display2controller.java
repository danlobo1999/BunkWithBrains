package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class display2controller {

    @FXML
    private Button dis2back;

    @FXML
    private Button dis2go;

    @FXML
    void dis2Back(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Functions");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/display.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }

    @FXML
    void dis2Go(ActionEvent event) throws IOException {
        Stage LoginStage = Main.stage;
        LoginStage.setTitle("Average Attendance");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/avgattendance.fxml"));
        LoginStage.setScene(new Scene(root));
        LoginStage.setResizable(false);
        LoginStage.show();
    }
}
