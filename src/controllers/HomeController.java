package controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import database.Database;
import javafx.scene.control.Label;
import models.Login;


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

    AnchorPane clientes, home;


    public void initialize(URL url, ResourceBundle rb) {
        userLabel.setText(user.getAuthUser());

        try {
            home     = FXMLLoader.load(getClass().getResource("/views/home/index.fxml"));
            clientes = FXMLLoader.load(getClass().getResource("/views/clientes/index.fxml"));

            setNode(home);

        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setNode(Node node) {
        reciveScreenPane.getChildren().clear();
        reciveScreenPane.getChildren().add((Node) node);

        reciveScreenPane.setBottomAnchor(node,0.0);
        reciveScreenPane.setTopAnchor(node,0.0);
        reciveScreenPane.setLeftAnchor(node,0.0);
        reciveScreenPane.setRightAnchor(node,0.0);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void showHome(ActionEvent event) {
        setNode(home);
    }

    @FXML
    private void showClientes(ActionEvent event) {
        setNode(clientes);
    }

}
