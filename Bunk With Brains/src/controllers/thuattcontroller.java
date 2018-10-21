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

public class thuattcontroller {

    @FXML
    private CheckBox thDLDA;

    @FXML
    private CheckBox thECCFP;

    @FXML
    private CheckBox thECCF;

    @FXML
    private CheckBox thDAS;

    @FXML
    private CheckBox thAM;

    @FXML
    private CheckBox thAMT;

    @FXML
    private Label thdate;

    @FXML
    private String date1;

    @FXML
    int am=0,das=0,eccf=0,dlda=0,amt=0,eccfp=0;

    public void initialize(){
        thdate.setText(Functions.dateprinter());
    }

    @FXML
    void thBack(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Functions");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/display.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }

    @FXML
    void thSubmit(ActionEvent event) {
        if(thDLDA.isSelected()){
            dlda= 1;
        }
        if(thECCFP.isSelected()){
            eccfp= 1;
        }
        if(thECCF.isSelected()){
            eccf= 1;
        }
        if(thDAS.isSelected()){
            das= 1;
        }
        if(thAM.isSelected()){
            am= 1;
        }
        if(thAMT.isSelected()){
            amt= 1;
        }

        date1 = Functions.dateConverter();
        String query = "INSERT INTO `dvs` (`userkey`,`date`, `am3`, `oopm`, `dim`, `das`, `dlda`, `eccf`, `dldap`, `dasp`, `oopmp`, `eccfp`, `amt`) VALUES ('%d', DATE('%s'), '%d', NULL, NULL, '%d', '%d', '%d', NULL, NULL, NULL, '%d', '%d');";
        query=String.format(query,Functions.userkey,date1,am,das,dlda,eccf,eccfp,amt);
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
