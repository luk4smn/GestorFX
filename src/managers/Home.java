package managers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/dashboard/FXMLDocument.fxml"));

        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/icons/icone.png"));

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}