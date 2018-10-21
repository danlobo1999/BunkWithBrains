package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class welcomecontroller {

    @FXML
    private Label welcomename;

    @FXML
    private Label welcomerollno;

    @FXML
    private Label welcomepid;

    public void initialize(){
        welcomename.setText("Name : "+Functions.name);
        welcomerollno.setText("Roll no : "+Functions.rollno);
        welcomepid.setText("PID : "+Functions.pid);
    }
    @FXML
    void welAtt(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Functions");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/display.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }

    @FXML
    void welAvg(ActionEvent event) throws IOException {
        Stage LoginStage = Main.stage;
        LoginStage.setTitle("Average Attendance");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/avgattendance.fxml"));
        LoginStage.setScene(new Scene(root));
        LoginStage.setResizable(false);
        LoginStage.show();

    }

    @FXML
    void welTt(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Time Table");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/timetable.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }

    @FXML
    void welcomeLogout(ActionEvent event) throws IOException {
        Stage LoginStage = Main.stage;
        LoginStage.setTitle("Login");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        LoginStage.setScene(new Scene(root));
        LoginStage.setResizable(false);
        LoginStage.show();
    }
}
