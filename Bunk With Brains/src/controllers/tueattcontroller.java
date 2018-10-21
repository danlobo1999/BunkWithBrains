package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.DBConnect;
import sample.Main;
import java.io.IOException;
import java.sql.SQLException;

public class tueattcontroller {

    @FXML
    private CheckBox tuDIM;

    @FXML
    private CheckBox tuDLDA;

    @FXML
    private CheckBox tuDAS;

    @FXML
    private CheckBox tuDASP;

    @FXML
    private CheckBox tuECCF;

    @FXML
    private Label tudate;

    @FXML
    private String date1;

    @FXML
    int dim=0,das=0,dlda=0,dasp=0,eccf=0;

    public void initialize(){
        tudate.setText(Functions.dateprinter());
    }

    @FXML
    void tuBack(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Functions");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/display.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }

    @FXML
    void tuSubmit(ActionEvent event) {
        if(tuDIM.isSelected()){
            dim = 1;
        }
        if(tuDLDA.isSelected()){
            dlda = 1;
        }
       if(tuDAS.isSelected()){
            das = 1;
        }
        if(tuDASP.isSelected()){
            dasp = 1;
        }
        if(tuECCF.isSelected()){
            eccf = 1;
        }
        date1 = Functions.dateConverter();
        String query = "INSERT INTO `dvs` (`userkey`, `date`, `am3`, `oopm`, `dim`, `das`, `dlda`, `eccf`, `dldap`, `dasp`, `oopmp`, `eccfp`, `amt`) VALUES ('%d', DATE('%s'), NULL, NULL, '%d' , '%d', '%d', '%d', NULL, '%d', NULL, NULL, NULL);";
        query=String.format(query,Functions.userkey,date1,dim,das,dlda,eccf,dasp);
        try {
            DBConnect.getStatement().executeUpdate(query);
            System.out.println("update successful");
            Stage homeStage = Main.stage;
            homeStage.setTitle("Success");
            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/display2.fxml"));
            homeStage.setScene(new Scene(root1));
            homeStage.setResizable(false);
            homeStage.show();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
