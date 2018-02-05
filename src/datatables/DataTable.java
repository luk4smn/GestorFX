package datatables;

import database.Database;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class DataTable {

    Database database = new Database();

    public void inputOnDataTable(TableView tableView,String SQL, String[] colunasArray) {
        AtomicReference<ObservableList<ObservableList>> data = new AtomicReference<>(FXCollections.observableArrayList());
        try{
            database.connect();
            database.executeSQL(SQL);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/

            IntStream.range(0, database.rs.getMetaData().getColumnCount()).forEach((int value) -> {
                TableColumn column = new TableColumn(colunasArray[value]);
                column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(value).toString());
                    }
                });
                tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                tableView.setPrefWidth(100.0);
                tableView.getColumns().add(column);
                System.out.println("Column ["+value+"] ");
            });

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(database.rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=database.rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(database.rs.getString(i));
                }
                data.get().add(row);
                System.out.println("Row [1] added "+row );
            }

            //FINALLY ADDED TO TableView
            tableView.setItems(data.get());

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
}
