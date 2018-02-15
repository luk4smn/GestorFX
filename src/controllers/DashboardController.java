package controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.Database;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;
import models.Login;


public class DashboardController implements Initializable {

    Login    user     = new Login();
    Database database = new Database();

    @FXML
    private Label userLabel;
    @FXML
    private AnchorPane reciveScreenPane, dashboardPane;
    @FXML
    private JFXButton homeButton, clientButton, providerButton, teamButton,
            productButton, paymentButton, reciveButton, reportButton;

    AnchorPane clientes, home;


    public void initialize(URL url, ResourceBundle rb) {
        userLabel.setText(user.getAuthUser());

        try {
            home     = FXMLLoader.load(getClass().getResource("/views/home/index.fxml"));
            clientes = FXMLLoader.load(getClass().getResource("/views/clientes/index.fxml"));

        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        setNode(home);
        homeButton.setStyle("-fx-text-fill: #A42C43;");

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

    public void closeDialog(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Deseja Sair do Sistema?");
        alert.setContentText("Selecione uma das opções");

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/icons/icone.png"));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            database.killDatabaseTasks();
        } else try {
            wait();
        } catch (InterruptedException e) {
            System.out.println("wait");
        }
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
