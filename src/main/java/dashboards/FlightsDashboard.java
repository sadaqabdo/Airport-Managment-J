package dashboards;

import com.jfoenix.controls.JFXTimePicker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FlightsDashboard extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("flights.fxml"));
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMaximized(true);
        JFXTimePicker timePicker = new JFXTimePicker();
        GridPane addGrid = (GridPane) scene.lookup("#addGrid");
        addGrid.add(timePicker,1,3);
        stage.show();
    }
}