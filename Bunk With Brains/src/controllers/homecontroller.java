package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class homecontroller {

    @FXML
    private AnchorPane root;

    @FXML
    private Button onlogin;

    @FXML
    private Button onregister;

    @FXML
    public void onRegister(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage registerStage = Main.stage;
        registerStage.setTitle("Register");
        root = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
        registerStage.setScene(new Scene(root));
        registerStage.setResizable(false);
        registerStage.show();
    }

    @FXML
    public void onLogin(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage LoginStage = Main.stage;
        LoginStage.setTitle("Login");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        LoginStage.setScene(new Scene(root));
        LoginStage.setResizable(false);
        LoginStage.show();
    }
}

