package charts;

import javafx.collections.FXCollections;
import javafx.scene.chart.*;

import java.util.Arrays;

public class BarChartModel {

    final String faturado   = "Faturdo";
    final String recebido   = "recebido";
    final String aVencer    = "A Vencer";
    final String emAtraso   = "Em Atraso";

    final CategoryAxis xAxis    = new CategoryAxis();
    final NumberAxis   yAxis    = new NumberAxis();
    final StackedBarChart<String, Number> stackedBarChar = new StackedBarChart<String, Number>(xAxis, yAxis);
    final XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
    final XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
    final XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();
    final XYChart.Series<String, Number> series4 = new XYChart.Series<String, Number>();


    public StackedBarChart<String, Number> inputDataBarChart(String title){
        stackedBarChar.setTitle(title);

        xAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(faturado, recebido, aVencer, emAtraso)));

        series1.setName(faturado +" "+25601.34);
        series1.getData().add(new XYChart.Data<String, Number>(faturado, 25601.34));

        series2.setName(recebido +" "+57401.85);
        series2.getData().add(new XYChart.Data<String, Number>(recebido, 57401.85));

        series3.setName(aVencer+" "+45000.65);
        series3.getData().add(new XYChart.Data<String, Number>(aVencer, 45000.65));

        series4.setName(emAtraso+" "+5000.65);
        series4.getData().add(new XYChart.Data<String, Number>(emAtraso, 5000.65));


        stackedBarChar.getData().addAll(series1, series2, series3, series4);


        return stackedBarChar;
    }
}
