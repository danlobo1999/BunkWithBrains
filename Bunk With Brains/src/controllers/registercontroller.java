package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DBConnect;
import sample.Main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class registercontroller {

    @FXML
    private TextField reusername;

    @FXML
    private TextField rename;

    @FXML
    private TextField rerollno;

    @FXML
    private TextField repid;

    @FXML
    private Button reregister;

    @FXML
    private Button relogin;

    @FXML
    private PasswordField repassword;

    @FXML
    private PasswordField reconpassword;

    @FXML
    private Label restatus;

    @FXML
    private Button rehome;
    private String query;

    @FXML
    void reLogin(ActionEvent event) throws IOException {
        Stage LoginStage = Main.stage;
        LoginStage.setTitle("Login");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        LoginStage.setScene(new Scene(root));
        LoginStage.show();
    }

    @FXML
    void reRegister(ActionEvent event) {
        if(reusername.getText().isEmpty() || repassword.getText().isEmpty() || reconpassword.getText().isEmpty() || rename.getText().isEmpty() || rerollno.getText().isEmpty() || repid.getText().isEmpty()){
            restatus.setText("Please enter all fields!");
        }
        else if(!reconpassword.getText().equals(repassword.getText())){
            restatus.setText("Passwords don't match!");
        }
        else if(doesUserExist(reusername.getText())){
            restatus.setText("User exists!");
        }
        else if(doesPidExist(repid.getText())){
            restatus.setText("You have already Registered!");
        }
        else {
            String query = "INSERT INTO `users`(`username`, `password`, `name`, `rollno`, `pid`) VALUES ('%s', '%s', '%s', '%s', '%s')";
            query=String.format(query,reusername.getText(),repassword.getText(),rename.getText(),rerollno.getText(),repid.getText());
            try {
                DBConnect.getStatement().executeUpdate(query);
                restatus.setText("User Registered.");
                relogin.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    boolean doesUserExist(String username){
        boolean exist = false;
        String query = "SELECT * FROM `users` WHERE `username`='%s'";
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(String.format(query,username));
            exist = set.next();
            set.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return exist;
    }
    boolean doesPidExist(String pid){
        boolean exist = false;
        String query = "SELECT * FROM `users` WHERE `pid`='%s'";
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(String.format(query,pid));
            exist = set.next();
            set.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return exist;
    }

    @FXML
    public void reHome(ActionEvent actionEvent) throws IOException {
        Stage LoginStage = Main.stage;
        LoginStage.setTitle("Bunk With Brains");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        LoginStage.setScene(new Scene(root));
        LoginStage.setResizable(false);
        LoginStage.show();
    }
}
