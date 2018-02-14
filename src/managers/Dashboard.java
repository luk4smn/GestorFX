package managers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Login;

public class Dashboard extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/dashboard/dashboard.fxml"));

        stage.setScene(new Scene(root));

        stage.getIcons().add(new Image("/icons/icone.png"));

        stage.setTitle("Sentinel - Sistema de Gestão Empresarial");

        stage.setMaximized(true);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}