package controllers;

import com.jfoenix.controls.JFXTextField;
import datatables.DataTable;
import datatables.clientes.columns.ClientesDataTableColumns;
import datatables.clientes.criterias.ClientesDataTableCriteria;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class ClienteController implements Initializable {

    @FXML
    private JFXTextField buscaTextField;
    @FXML
    private TableView tableClientes;

    DataTable table = new DataTable();
    ClientesDataTableCriteria query = new ClientesDataTableCriteria();
    ClientesDataTableColumns columns = new ClientesDataTableColumns();

    public void initialize(URL location, ResourceBundle resources) {

        table.inputOnDataTable(tableClientes,query.getQuery("index"), columns.columns());
    }



}
