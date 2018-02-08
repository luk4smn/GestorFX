package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import datatables.DataTable;
import datatables.clientes.columns.ClientesDataTableColumns;
import datatables.clientes.criterias.ClientesDataTableCriteria;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClienteController implements Initializable {

    @FXML
    private JFXTextField buscaTextField;
    @FXML
    private TableView tableClientes;
    @FXML
    private JFXButton addClientRegisterButton;
    @FXML
    private JFXButton openClientRegisterButton;
    @FXML
    private AnchorPane formScreenPane;

    private static String status = "FilterClients";

    DataTable table = new DataTable();
    ClientesDataTableCriteria query = new ClientesDataTableCriteria();
    ClientesDataTableColumns columns = new ClientesDataTableColumns();

    public void initialize(URL location, ResourceBundle resources) {
        if(status.equals("FilterClients")){
            table.inputOnDataTable(tableClientes,query.getQuery("index",null), columns.columns());

            buscaTextField.requestFocus();

            buscaTextField.setOnKeyPressed((KeyEvent k) ->{
                final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
                if (ENTER.match(k)) try {
                    this.searchClient();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public void clearDataTable(){
        table.clear(tableClientes);
    }

    public void searchClient(){
        this.clearDataTable();
        table.inputOnDataTable(tableClientes,query.getQuery("filter",buscaTextField.getText()), columns.columns());
    }

    public void newClient() throws IOException {
        status = "NewClient";

        formScreenPane = FXMLLoader.load(getClass().getResource("/views/clientes/create.fxml"));
        Parent parent = formScreenPane;

        GaussianBlur blur = new GaussianBlur(30);
        final Parent consultaDeCliente = buscaTextField.getScene().getRoot();
        consultaDeCliente.setEffect(blur);

        Scene scene = new Scene(parent);
        scene.setFill(new Color(0, 0, 0, 0));
        Stage novoStage = new Stage();

        novoStage.setScene(scene);
        novoStage.initModality(Modality.APPLICATION_MODAL);
        novoStage.initStyle(StageStyle.TRANSPARENT);
        novoStage.getIcons().add(new Image("/icons/icone.png"));
        novoStage.show();

        novoStage.setOnCloseRequest(event ->
                consultaDeCliente.setEffect(null)
        );
    }

    public void openClient() throws IOException{
        status = "OpenClient";

        formScreenPane = FXMLLoader.load(getClass().getResource("/views/clientes/edit.fxml"));
        Parent parent = formScreenPane;

        GaussianBlur blur = new GaussianBlur(30);
        final Parent consultaDeCliente = buscaTextField.getScene().getRoot();
        consultaDeCliente.setEffect(blur);

        Scene scene = new Scene(parent);
        scene.setFill(new Color(0, 0, 0, 0));
        Stage novoStage = new Stage();

        novoStage.setScene(scene);
        novoStage.initModality(Modality.APPLICATION_MODAL);
        novoStage.initStyle(StageStyle.TRANSPARENT);
        novoStage.getIcons().add(new Image("/icons/icone.png"));
        novoStage.show();

        novoStage.setOnCloseRequest(event ->
                consultaDeCliente.setEffect(null)
        );
    }

}
