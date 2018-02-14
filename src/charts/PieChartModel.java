package charts;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class PieChartModel {

    public PieChart inputDataPieChart(String title){
        ObservableList<javafx.scene.chart.PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new javafx.scene.chart.PieChart.Data("recebido", 133.00),
                        new javafx.scene.chart.PieChart.Data("Pago", 30.23)
                );

        PieChart chart = new PieChart(pieChartData);

        chart.setTitle(title);

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty()
                        )
                )
        );

        return chart;
    }
}
