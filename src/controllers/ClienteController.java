package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import datatables.DataTable;
import datatables.clientes.columns.ClientesDataTableColumns;
import datatables.clientes.criterias.ClientesDataTableCriteria;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

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

    DataTable table = new DataTable();
    ClientesDataTableCriteria query = new ClientesDataTableCriteria();
    ClientesDataTableColumns columns = new ClientesDataTableColumns();

    public void initialize(URL location, ResourceBundle resources) {
        table.inputOnDataTable(tableClientes,query.getQuery("index",null), columns.columns());

        buscaTextField.setOnKeyPressed((KeyEvent k) ->{
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) try {
                this.searchClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void searchClient(){
        this.clearDataTable();
        table.inputOnDataTable(tableClientes,query.getQuery("filter",buscaTextField.getText()), columns.columns());
    }

    public void clearDataTable(){
        table.clear(tableClientes);
    }

}
