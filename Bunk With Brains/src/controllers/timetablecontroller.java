package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;
import java.io.IOException;

public class timetablecontroller {

    @FXML
    private Button ttback;

    @FXML
    void ttBack(ActionEvent event) throws IOException {
        Stage homeStage = Main.stage;
        homeStage.setTitle("Welcome");
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/welcome.fxml"));
        homeStage.setScene(new Scene(root1));
        homeStage.setResizable(false);
        homeStage.show();
    }
}
