package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class avgattendancecontroller {

    @FXML
    private Label avg;

    @FXML
    private Label aml;

    @FXML
    private Label amt;

    @FXML
    private Label dldal;

    @FXML
    private Label dldap;

    @FXML
    private Label eccfl;

    @FXML
    private Label eccfp;

    @FXML
    private Label diml;

    @FXML
    private Label oopml;

    @FXML
    private Label oopmp;

    @FXML
    private Label dasl;

    @FXML
    private Label dasp;

    @FXML
    private RadioButton amtb;

    @FXML
    private RadioButton amb;

    @FXML
    private RadioButton daspb;

    @FXML
    private RadioButton dimb;

    @FXML
    private RadioButton dasb;

    @FXML
    private RadioButton oopmpb;

    @FXML
    private RadioButton oopmb;

    @FXML
    private RadioButton eccfpb;

    @FXML
    private RadioButton eccfb;

    @FXML
    private RadioButton dldapb;

    @FXML
    private RadioButton dldab;

    @FXML
    public void initialize(){
        float amavg=0, amtavg=0, dldaavg=0, dldapavg=0, dasavg=0, daspavg=0, eccfavg=0, eccfpavg=0, oopmavg=0, oopmpavg=0, dimavg=0;
        int am1 = Functions.attendedam();
        int am2 = Functions.totalam();
        if(am2==0){
            aml.setText("-");
        }
        else {
            amavg = Functions.average(am1, am2);
            aml.setText((int) amavg + "%");
            if(amavg<75){
                aml.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        int amt1 = Functions.attendedamt();
        int amt2 = Functions.totalamt();
        if(amt2==0){
            amt.setText("-");
        }
        else {
            amtavg = Functions.average(amt1, amt2);
            amt.setText((int) amtavg + "%");
            if(amtavg<75){
                amt.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        int dlda1 = Functions.attendeddlda();
        int dlda2 = Functions.totaldlda();
        if(dlda2==0){
            dldal.setText("-");
        }
        else {
            dldaavg = Functions.average(dlda1, dlda2);
            dldal.setText((int) dldaavg + "%");
            if(dldaavg<75){
                dldal.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        int dldap1 = Functions.attendeddldap();
        int dldap2 = Functions.totaldldap();
        if(dldap2==0){
            dldap.setText("-");
        }
        else {
            dldapavg = Functions.average(dldap1, dldap2);
            dldap.setText((int) dldapavg + "%");
            if(dldapavg<75){
                dldap.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        int das1 = Functions.attendeddas();
        int das2 = Functions.totaldas();
        if(das2==0){
            dasl.setText("-");
        }
        else {
            dasavg = Functions.average(das1, das2);
            dasl.setText((int) dasavg + "%");
            if(dasavg<75){
                dasl.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        int dasp1 = Functions.attendeddasp();
        int dasp2 = Functions.totaldasp();
        if(dasp2==0){
            dasp.setText("-");
        }
        else {
            daspavg = Functions.average(dasp1, dasp2);
            dasp.setText((int) daspavg + "%");
            if(daspavg<75){
                dasp.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        int oopm1 = Functions.attendedoopm();
        int oopm2 = Functions.totaloopm();
        if(oopm2==0){
            oopml.setText("-");
        }
        else {
            oopmavg = Functions.average(oopm1, oopm2);
            oopml.setText((int) oopmavg + "%");
            if(oopmavg<75){
                oopml.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        int oopmp1 = Functions.attendedoopmp();
        int oopmp2 = Functions.totaloopmp();
        if(oopmp2==0){
            oopmp.setText("-");
        }
        else {
            oopmpavg = Functions.average(oopmp1, oopmp2);
            oopmp.setText((int) oopmpavg + "%");
            if(oopmpavg<75){
                oopmp.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        int eccf1 = Functions.attendedeccf();
        int eccf2 = Functions.totaleccf();
        if(eccf2==0){
            eccfl.setText("-");
        }
        else {
            eccfavg = Functions.average(eccf1, eccf2);
            eccfl.setText((int) eccfavg + "%");
            if(eccfavg<75){
                eccfl.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        int eccfp1 = Functions.attendedeccfp();
        int eccfp2 = Functions.totaleccfp();
        if(eccfp2==0){
            eccfp.setText("-");
        }
        else {
            eccfpavg = Functions.average(eccfp1, eccfp2);
            eccfp.setText((int) eccfpavg + "%");
            if(eccfpavg<75){
                eccfp.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        int dim1 = Functions.attendeddim();
        int dim2 = Functions.totaldim();
        if(dim2==0){
            diml.setText("-");
        }
        else {
            dimavg = Functions.average(dim1, dim2);
            diml.setText((int) dimavg + "%");
            if(dimavg<75){
                diml.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
            }
        }

        float average=0;
        int count =0;
        if(am2!=0) {
            average+=amavg;
            count++;
        }
        if(amt2!=0) {
            average+=amtavg;
            count++;
        }
        if(dlda2!=0) {
            average+=dldaavg;
            count++;
        }
        if(dldap2!=0){
            average+=dldapavg;
            count++;
        }
        if(das2!=0) {
            average+=dasavg;
            count++;
        }
        if(dasp2!=0) {
            average+=daspavg;
            count++;
        }
        if(eccf2!=0) {
            average+=eccfavg;
            count++;
        }
        if(eccfp2!=0) {
            average+=eccfpavg;
            count++;
        }
        if(oopm2!=0) {
            average+=oopmavg;
            count++;
        }
        if(oopmp2!=0) {
            average+=oopmpavg;
            count++;
        }
        if(dim2!=0) {
            average+=dimavg;
            count++;
        }
        average=average/count;
        if(count==0){
            avg.setText("-");
        }
        else{
            avg.setText((int)average+"%");
        }
        if(average<75){
            avg.setStyle("-fx-border-color:black;-fx-background-color: crimson;");
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Success");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/display2.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        Stage LoginStage = Main.stage;
        LoginStage.setTitle("Login");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        LoginStage.setScene(new Scene(root));
        LoginStage.setResizable(false);
        LoginStage.show();
    }

    @FXML
    void proceed(ActionEvent event) throws IOException {
        int am=0, amt=0, dlda=0, dldap=0, das=0, dasp=0, eccf=0, eccfp=0, oopm=0, oopmp=0, dim=0;
        if(amb.isSelected())
            am=1;
        if(amtb.isSelected())
            amt=1;
        if(dasb.isSelected())
            das=1;
        if(daspb.isSelected())
            dasp=1;
        if(dldab.isSelected())
            dlda=1;
        if(dldapb.isSelected())
            dldap=1;
        if(eccfb.isSelected())
            eccf=1;
        if(eccfpb.isSelected())
            eccfp=1;
        if(oopmb.isSelected())
            oopm=1;
        if(oopmpb.isSelected())
            oopmp=1;
        if(dimb.isSelected())
            dim=1;
        Functions.bunkAssign(am, amt, dlda, dldap, das, dasp, eccf, eccfp, oopm, oopmp, dim);
        Stage LoginStage = Main.stage;
        LoginStage.setTitle("Bunk Attendance");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/bunkattendance.fxml"));
        LoginStage.setScene(new Scene(root));
        LoginStage.setResizable(false);
        LoginStage.show();
    }
}
