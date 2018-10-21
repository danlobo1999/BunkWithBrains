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

public class friattcontroller {

    @FXML
    private CheckBox frioopm;

    @FXML
    private CheckBox fridlda;

    @FXML
    private CheckBox fridim;

    @FXML
    private CheckBox frioopmp;

    @FXML
    private CheckBox friam;

    @FXML
    private Label fridate;

    @FXML
    int oopm=0, dlda=0,dim=0,oopmp=0, am=0;

    @FXML
    private String date1;

    public void initialize(){
        fridate.setText(Functions.dateprinter());
    }

    @FXML
    void friSubmit(ActionEvent event) {
        if(frioopm.isSelected()){
            oopm= 1;
        }
        if(fridlda.isSelected()){
            dlda= 1;
        }
        if(fridim.isSelected()){
            dim= 1;
        }
        if(frioopmp.isSelected()){
            oopmp= 1;
        }
        if(friam.isSelected()){
            am= 1;
        }
        date1 = Functions.dateConverter();
        String query = "INSERT INTO `dvs` (`userkey`,`date`, `am3`, `oopm`, `dim`, `das`, `dlda`, `eccf`, `dldap`, `dasp`, `oopmp`, `eccfp`, `amt`) VALUES ('%d', DATE('%s'), '%d', '%d', '%d', NULL, '%d', NULL, NULL, NULL, '%d', NULL, NULL);";
        query=String.format(query,Functions.userkey,date1,am,oopm,dim,dlda,oopmp);
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
    void friBack(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Functions");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/display.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }
}


