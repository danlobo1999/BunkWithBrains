package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DBConnect;
import sample.Main;
import java.util.Calendar;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logincontroller {

    public Button home;
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button login;

    @FXML
    private Label status;

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
        String query = "SELECT * FROM `users` WHERE `username`='%s' && `password`='%s'";
        query=String.format(query,username.getText(),password.getText());

        if(username.getText().isEmpty() || password.getText().isEmpty()){
            status.setText("Please enter all Fields!");
        }
        else{
            try{
                ResultSet set = DBConnect.getStatement().executeQuery(query);
                if(set.next()) {
                    status.setText("Logged in successfully!");
                    Functions.getUser(username.getText());
                    Stage homeStage = Main.stage;
                    homeStage.setTitle("Welcome");
                    Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/welcome.fxml"));
                    homeStage.setScene(new Scene(root1));
                    homeStage.setResizable(false);
                    homeStage.show();

                }
                else{
                    status.setText("Login Failed!");
                }
            }
            catch (SQLException  e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void home(ActionEvent actionEvent) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Bunk With Brains");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        homeStage.setScene(new Scene(root));
        homeStage.setResizable(false);
        homeStage.show();
    }
}
