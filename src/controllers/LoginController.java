package controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import managers.Home;
import models.Login;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    Database database = new Database();
    Login model_login = new Login();
    Home model_home = new Home();
    Stage newStage = new Stage();

    @FXML
    private ProgressBar loginProgressBar;
    @FXML
    private JFXTextField textFiledUser;
    @FXML
    private JFXPasswordField passwordFieldUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleLoginButton() throws Exception {
        String user = textFiledUser.getText();
        String passoword = passwordFieldUser.getText();
        model_login.login(user,passoword,database);
        if (model_login.getAuthUser() != null) {
            new Thread(this::run).start();
            newWindow(model_home,newStage);

        }
    }

    private void run() {
        for (int i = 0; i < 101; i++) {
            try {
                Thread.sleep(600);
                loginProgressBar.setProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        database.killDatabaseTasks();
    }

    public void newWindow(Home model_home, Stage newStage) throws Exception {
        try {
            model_home.start(newStage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
