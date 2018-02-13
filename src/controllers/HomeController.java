package controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
import javafx.scene.control.Label;
import models.Login;


public class HomeController implements Initializable {
    Login user = new Login();

    @FXML
    private Label userLabel;
    @FXML
    private AnchorPane reciveScreenPane;
    @FXML
    private JFXButton homeButton, clientButton, providerButton, teamButton, productButton,
            paymentButton, reciveButton, reportButton;

    AnchorPane clientes, home;

    public void initialize(URL url, ResourceBundle rb) {
        userLabel.setText(user.getAuthUser());

        try {
            home     = FXMLLoader.load(getClass().getResource("/views/home/index.fxml"));
            clientes = FXMLLoader.load(getClass().getResource("/views/clientes/index.fxml"));

            setNode(home);
            homeButton.setStyle("-fx-text-fill: #A42C43;");

        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setNode(Node node) {
        reciveScreenPane.getChildren().clear();
        reciveScreenPane.getChildren().add(node);

        AnchorPane.setBottomAnchor(node,0.0);
        AnchorPane.setTopAnchor(node,0.0);
        AnchorPane.setLeftAnchor(node,0.0);
        AnchorPane.setRightAnchor(node,0.0);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }


    private void changeButtonColor(JFXButton button, ArrayList outrosBotoes){
        button.setStyle("-fx-text-fill: #A42C43;");

        outrosBotoes.forEach(item->{
            JFXButton button1 = (JFXButton) item;
            button1.setStyle("-fx-text-fill: #737691;");
        });
    }

    @FXML
    private void showHome(ActionEvent event) {
        setNode(home);

        ArrayList outrosBotoes = new ArrayList();
        outrosBotoes.addAll(Arrays.asList(clientButton, providerButton, teamButton,
                productButton, paymentButton, reciveButton, reportButton)
        );

        this.changeButtonColor(homeButton,outrosBotoes);
    }

    @FXML
    private void showClientes(ActionEvent event) {
        setNode(clientes);

        ArrayList outrosBotoes = new ArrayList();
        outrosBotoes.addAll(Arrays.asList(homeButton, providerButton, teamButton,
                productButton, paymentButton, reciveButton, reportButton)
        );

        this.changeButtonColor(clientButton,outrosBotoes);
    }


}
