package controllers;

import com.jfoenix.controls.JFXButton;
import database.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import models.Login;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    Login user = new Login();
    Database database = new Database();

    @FXML
    private AnchorPane reciveScreenPane;
    @FXML
    private JFXButton reportButton;
    @FXML
    private JFXButton reciveButton;
    @FXML
    private JFXButton paymentButton;
    @FXML
    private JFXButton productButton;
    @FXML
    private JFXButton teamButton;
    @FXML
    private JFXButton providerButton;
    @FXML
    private JFXButton clientButton;
    @FXML
    private JFXButton homeButton;
    @FXML
    private Label userLabel;


    public void initialize(URL url, ResourceBundle rb) {
        userLabel.setText(user.getAuthUser());
    }

    public void minimize(){
        Window dashboard = userLabel.getScene().getWindow();
        dashboard.hide();
    }
    
    public void close(){
        database.killDatabaseTasks();
    }
}
