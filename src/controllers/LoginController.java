package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import managers.Home;
import models.Login;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    Database database = new Database();
    Login model_login = new Login();
    Home manager_home = new Home();
    Stage newStage    = new Stage();

    @FXML
    private JFXTextField textFiledUser;
    @FXML
    private JFXPasswordField passwordFieldUser;
    @FXML
    private JFXSpinner loggingProgress;
    @FXML
    private JFXButton loginButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggingProgress.setVisible(false);

        textFiledUser.setOnKeyPressed(k ->{
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                passwordFieldUser.requestFocus();
            }
        });

        passwordFieldUser.setOnKeyPressed((KeyEvent k) ->{
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) try {
                this.handleLoginButton();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    public void handleLoginButton() throws Exception {
        String user = textFiledUser.getText();

        String passoword = passwordFieldUser.getText();

        model_login.login(user,passoword,database);

        if (model_login.getAuthUser() != null) {

            loginButton.setDisable(true);

            loggingProgress.setVisible(true);

            PauseTransition pauseTransition = new PauseTransition();

            pauseTransition.setDuration(Duration.seconds(4));

            pauseTransition.setOnFinished(ev -> {
                try {
                    newWindow(manager_home,newStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            pauseTransition.play();

        }
    }

    public void newWindow(Home manager_home, Stage newStage) throws Exception {
        try {
            Window telaDeLogin = textFiledUser.getScene().getWindow();
            telaDeLogin.hide();

            manager_home.start(newStage);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void close() {
        database.killDatabaseTasks();
    }
}
