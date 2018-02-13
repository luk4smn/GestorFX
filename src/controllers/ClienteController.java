package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
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
import javafx.scene.input.*;
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
    private AnchorPane formScreenPane;
    @FXML
    private JFXButton addClientRegisterButton, openClientRegisterButton;
    @FXML
    private JFXToggleButton pessoaFisicaToggleButton, pessoaJuridicaToggleButton;

    private static String status = "FilterClients";

    static Parent consultaDeCliente;
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
        consultaDeCliente = buscaTextField.getScene().getRoot();
        consultaDeCliente.setEffect(blur);

        Scene scene = new Scene(parent);
        scene.setFill(new Color(0, 0, 0, 0));
        Stage crudClientStage = new Stage();

        crudClientStage.setScene(scene);
        crudClientStage.initModality(Modality.APPLICATION_MODAL);
        crudClientStage.initStyle(StageStyle.TRANSPARENT);
        crudClientStage.getIcons().add(new Image("/icons/icone.png"));
        crudClientStage.show();

        crudClientStage.setOnCloseRequest(event ->
                consultaDeCliente.setEffect(null)
        );

    }

    public void openClient() throws IOException{
        status = "OpenClient";

        formScreenPane = FXMLLoader.load(getClass().getResource("/views/clientes/edit.fxml"));
        Parent parent = formScreenPane;

        GaussianBlur blur = new GaussianBlur(30);
        Parent consultaDeCliente = buscaTextField.getScene().getRoot();
        consultaDeCliente.setEffect(blur);

        Scene scene = new Scene(parent);
        scene.setFill(new Color(0, 0, 0, 0));
        Stage crudClientsStage = new Stage();

        crudClientsStage.setScene(scene);
        crudClientsStage.initModality(Modality.APPLICATION_MODAL);
        crudClientsStage.initStyle(StageStyle.TRANSPARENT);
        crudClientsStage.getIcons().add(new Image("/icons/icone.png"));
        crudClientsStage.show();

        crudClientsStage.setOnCloseRequest(event ->
                consultaDeCliente.setEffect(null)
        );
    }

    public void closeWindow(){
        Stage crudClientes = (Stage) pessoaFisicaToggleButton.getScene().getWindow();
        crudClientes.close();

        consultaDeCliente.setEffect(null);
    }

    public void changePersonType(){
        if (pessoaFisicaToggleButton.isSelected()) {
            pessoaJuridicaToggleButton.setSelected(false);
        }
        else{
            pessoaJuridicaToggleButton.setSelected(true);
        }
    }

}
