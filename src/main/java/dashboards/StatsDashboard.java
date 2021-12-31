package dashboards;

import airportmanagment.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatsDashboard extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        Scene scene = new Scene(root);

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Airpots");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number of flights");
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        Statement st1 = con.createStatement();
        Statement st3 = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT destination, count(*) as n from Flight group by destination order by n desc limit(5);");
        ResultSet rs1 = st1.executeQuery("SELECT source, count(*) as n from Flight group by source order by n desc limit(5);");
        ResultSet rs3 = st3.executeQuery("SELECT duration, count(*) as n from Flight group by duration;");

        BarChart<String, Integer> barChart = new BarChart(xAxis, yAxis);

        XYChart.Series<String, Integer> dataSeries1 = new XYChart.Series<String, Integer>();
        XYChart.Series<String, Integer> dataSeries2 = new XYChart.Series<String, Integer>();
        XYChart.Series<String, Integer> dataSeries3 = new XYChart.Series<String, Integer>();

        while(rs.next()){
            dataSeries1.getData().add(new XYChart.Data<String, Integer>(rs.getString(1),rs.getInt(2)));
        }
        while(rs1.next()){
            dataSeries2.getData().add(new XYChart.Data<String, Integer>(rs1.getString(1),rs1.getInt(2)));
        }
        while(rs3.next()){
            dataSeries3.getData().add(new XYChart.Data<String, Integer>(rs3.getString(1),rs3.getInt(2)));
        }

        // Add Series to BarChart.
        barChart.getData().add(dataSeries1);
        barChart.getData().add(dataSeries2);
        dataSeries1.setName("Destinations");
        dataSeries2.setName("Sources");

        barChart.setTitle("Most trafficed");

        VBox vbox = new VBox(barChart);
        StackPane stackPane = (StackPane) root.getChildrenUnmodifiable().get(1);
        Pane pane = (Pane) stackPane.getChildrenUnmodifiable().get(0);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        pane.getChildren().add(vbox);
        primaryStage.setScene(scene);

        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}

