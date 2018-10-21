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

public class wedattcontroller {

    @FXML
    private Label weddate;

    @FXML
    private CheckBox wedAM;

    @FXML
    private CheckBox wedECCF;

    @FXML
    private CheckBox wedDAS;

    @FXML
    private CheckBox wedDIM;

    @FXML
    private CheckBox wedOOPM;

    @FXML
    private String date1;

    @FXML
    int am=0,eccf=0,dim=0,das=0,oopm=0;

    public void initialize(){
        weddate.setText(Functions.dateprinter());
    }

    @FXML
    void wedBack(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Functions");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/display.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }

    @FXML
    void wedSubmit(ActionEvent event) {
        if(wedAM.isSelected()){
            am= 1;
        }
        if(wedECCF.isSelected()){
            eccf= 1;
        }
        if(wedDIM.isSelected()){
            dim= 1;
        }
        if(wedDAS.isSelected()){
            das= 1;
        }
        if(wedOOPM.isSelected()){
            oopm= 1;
        }
        date1 = Functions.dateConverter();
        String query = "INSERT INTO `dvs` (`userkey`, `date`, `am3`, `oopm`, `dim`, `das`, `dlda`, `eccf`, `dldap`, `dasp`, `oopmp`, `eccfp`, `amt`) VALUES ('%d', DATE('%s'), '%d', '%d', '%d', '%d', NULL, '%d', NULL, NULL, NULL, NULL, NULL);";
        query=String.format(query,Functions.userkey,date1,am,oopm,dim,das,eccf);
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
