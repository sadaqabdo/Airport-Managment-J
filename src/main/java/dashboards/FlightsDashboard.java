package dashboards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Modality;

public class FlightsDashboard extends Application {
    @Override
    public void start(Stage stage) throws Exception {
<<<<<<< HEAD
        FXMLLoader root = new FXMLLoader(getClass().getResource("flights.fxml"));
        Scene scene = new Scene(root.load(), 800, 600);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMaximized(true);
        /*JFXTimePicker timePicker = new JFXTimePicker();
        Button b = new Button("joidja");
        SplitPane splitpanee = (SplitPane) scene.lookup("#SplitPanee");
        GridPane addGrid = (GridPane) splitpanee.getItems().get(0);
        addGrid.add(timePicker,1,3);
System.out.println(addGrid);       */

=======
        Parent root = FXMLLoader.load(getClass().getResource("flights.fxml"));
        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("helo");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMaximized(true);
>>>>>>> dca59cd839ed9be5ff4b2a97f835698a9883f7af
        stage.show();
    }
}