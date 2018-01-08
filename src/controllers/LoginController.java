package controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    private ProgressBar loginProgressBar;
    @FXML
    private JFXTextField textFiledUser;
    @FXML
    private JFXPasswordField passwordFieldUser;

    Database data = new Database();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data.conectar();
    }

    @FXML
    public void handleLoginButton(){
        String user = textFiledUser.getText();
        String passoword = passwordFieldUser.getText();
        System.out.println(user);
    }

    public void close() {
        System.exit(0);
    }
}
