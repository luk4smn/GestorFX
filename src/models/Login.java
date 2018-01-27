package models;
import database.Database;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Login {
    private String authenticadedUser;

    /**
     * @return the authenticadedUser
     */
    public String getAuthUser() {

        return authenticadedUser;
    }

    /**
     * @param user the authenticadedUser to set
     */
    public void setAuthUser(String user) {

        this.authenticadedUser = user;
    }

    public void login(String user, String password, Database database) throws SQLException {

        database.conectar();

        database.executarSQL("select * from users where users.user ='" + user + "' and users.password ='" + password + "'");

            if(database.rs.first()){

                setAuthUser(database.rs.getString("user"));
            }
            else{
                setAuthUser(null);

                Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Atenção !");

                alert.setHeaderText("Dados Incorretos");

                alert.setContentText("Revise as informações e tente novamente");

                alert.showAndWait();
            }

        database.desconectar();
    }

}
