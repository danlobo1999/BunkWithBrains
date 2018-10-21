package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.DBConnect;
import sample.Main;
import java.io.IOException;
import java.sql.SQLException;

public class monattcontroller {

    @FXML
    private CheckBox moAM;

    @FXML
    private CheckBox moDAS;

    @FXML
    private CheckBox moECCF;

    @FXML
    private CheckBox moDLDA;

    @FXML
    private CheckBox moDIM;

    @FXML
    private CheckBox moDLDAP;

    @FXML
    private Button mosubmit;

    @FXML
    private Button moback;

    @FXML
    private Label mondate;

    @FXML
    int am=0,das=0,eccf=0,dlda=0,dim=0,dldap=0;

    @FXML
    private String date1;

    public void initialize(){
        mondate.setText(Functions.dateprinter());
    }

    @FXML
    void moSubmit(ActionEvent event) {
        if(moAM.isSelected()){
            am= 1;
        }
        if(moDAS.isSelected()){
            das= 1;
        }
        if(moECCF.isSelected()){
            eccf= 1;
        }
        if(moDLDA.isSelected()){
            dlda= 1;
        }
        if(moDIM.isSelected()){
            dim= 1;
        }
        if(moDLDAP.isSelected()){
            dldap= 1;
        }
        date1 = Functions.dateConverter();
        String query = "INSERT INTO `dvs` (`userkey`,`date`, `am3`, `oopm`, `dim`, `das`, `dlda`, `eccf`, `dldap`, `dasp`, `oopmp`, `eccfp`, `amt`) VALUES ('%d', DATE('%s'), '%d', NULL, '%d', '%d', '%d', '%d', '%d' , NULL, NULL, NULL, NULL);";
        query=String.format(query,Functions.userkey,date1,am,dim,das,dlda,eccf,dldap);
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

    @FXML
    void moBack(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Functions");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/display.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }
}
