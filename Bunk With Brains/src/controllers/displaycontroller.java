package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.DBConnect;
import sample.Main;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class displaycontroller {
    @FXML
    private Label displaylabel;

    @FXML
    private Label displaylab;

    @FXML
    DatePicker displaydate;

    @FXML
    private Button displaygo;

    @FXML
    private Button displayback;

    @FXML
    private Label displaystatus;

    @FXML
    private Button displayyes;

    @FXML
    private Button displayno;

    @FXML
    void displayBack(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Welcome");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/welcome.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }

    @FXML
    void disNo(ActionEvent event) throws IOException {
        displaydate.setDisable(false);
        displaylab.setVisible(false);
        displayyes.setVisible(false);
        displayno.setVisible(false);
        displaygo.setDisable(false);
        Stage homeStage = Main.stage;
        homeStage.setTitle("Functions");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/display.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }

    @FXML
    void disYes(ActionEvent event) throws IOException {
        displaydate.setDisable(false);
        displaylab.setVisible(false);
        displayyes.setVisible(false);
        displayno.setVisible(false);
        displaygo.setDisable(false);
        String query = "DELETE FROM `dvs` WHERE `userkey`='%d' && `date` = '%s'";
        query = String.format(query,Functions.userkey,displaydate.getValue().toString());
        try {
            DBConnect.getStatement().executeUpdate(query);
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
        dayPicker();
    }

    @FXML
    void displayGo(ActionEvent event) throws IOException {

        displaystatus.setText(" ");
        Functions.setSelectedDate(displaydate.getValue());
        if(displaydate.getValue().isBefore(LocalDate.of(2018,7,15))|| displaydate.getValue().isAfter(LocalDate.now())){
            displaystatus.setText("Invalid Functions!");
        }
        else if(doesDateExist(displaydate.getValue())){
            displaystatus.setText("Attendance already updated for this date.");
            displaydate.setDisable(true);
            displaylab.setVisible(true);
            displayyes.setVisible(true);
            displayno.setVisible(true);
            displaygo.setDisable(true);
        }
        else {
            dayPicker();
        }
    }
    int whatDay(){
        LocalDate d = displaydate.getValue();
        DayOfWeek day = d.getDayOfWeek();
        int da = day.getValue();
        System.out.println(day);
        return da;
    }
    void dayPicker() throws IOException {
        int d = whatDay();
        switch (d) {
            case 1:
                Stage monStage = Main.stage;
                monStage.setTitle("Monday");
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/monatt.fxml"));
                monStage.setScene(new Scene(root));
                monStage.setResizable(false);
                monStage.show();
                break;
            case 2:
                Stage tueStage = Main.stage;
                tueStage.setTitle("Tuesday");
                Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/tueatt.fxml"));
                tueStage.setScene(new Scene(root1));
                tueStage.setResizable(false);
                tueStage.show();
                break;
            case 3:
                Stage wedStage = Main.stage;
                wedStage.setTitle("Wednesday");
                Parent root2 = FXMLLoader.load(getClass().getResource("/fxml/wedatt.fxml"));
                wedStage.setScene(new Scene(root2));
                wedStage.setResizable(false);
                wedStage.show();
                break;
            case 4:
                Stage thuStage = Main.stage;
                thuStage.setTitle("Thursday");
                Parent root3 = FXMLLoader.load(getClass().getResource("/fxml/thuatt.fxml"));
                thuStage.setScene(new Scene(root3));
                thuStage.setResizable(false);
                thuStage.show();
                break;
            case 5:
                Stage friStage = Main.stage;
                friStage.setTitle("Friday");
                Parent root4 = FXMLLoader.load(getClass().getResource("/fxml/friatt.fxml"));
                friStage.setScene(new Scene(root4));
                friStage.setResizable(false);
                friStage.show();
                break;
            case 6:
                displaylabel.setText("Relax! It's a Saturday.");
                break;
            case 7:
                displaylabel.setText("Relax! It's a Sunday.");
                break;
            default:
                break;
        }
    }
    boolean doesDateExist(LocalDate d){
        boolean exist = false;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `date`='%s'";
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(String.format(query,Functions.userkey,d));
            exist = set.next();
            set.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return exist;
    }
}
