package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import models.Login;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    Login user = new Login();

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
}
