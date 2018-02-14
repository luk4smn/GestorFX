package controllers;

import charts.BarChartModel;
import charts.PieChartModel;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane homeScreenPane,recebidoPagoScreenPane, contasAReceberScreenPane;

    static PieChart recebidoPagoGrafico;
    static StackedBarChart<String, Number> contasAeceberGrafico;

    public void initialize(URL location, ResourceBundle resources) {
        recebidoPago();
        contasAReceber();
    }

    public void setNode(Node node, AnchorPane recivePane){
        recivePane.getChildren().clear();
        recivePane.getChildren().add(node);

        AnchorPane.setBottomAnchor(node,0.0);
        AnchorPane.setTopAnchor(node,0.0);
        AnchorPane.setLeftAnchor(node,0.0);
        AnchorPane.setRightAnchor(node,0.0);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    public void recebidoPago(){
        PieChartModel chart = new PieChartModel();

        recebidoPagoGrafico = chart.inputDataPieChart("Recebido/Pago (Este Mês)");

        setNode(recebidoPagoGrafico, recebidoPagoScreenPane);

    }

    public void contasAReceber(){
        BarChartModel chart = new BarChartModel();

        contasAeceberGrafico = chart.inputDataBarChart("Contas A Receber (Este Mês)");

        setNode(contasAeceberGrafico,contasAReceberScreenPane);
    }



}
