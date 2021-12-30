package dashboards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FlightsDashboard extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("flights.fxml"));
        Scene scene = new Scene(root, 800, 600);
        Image image = new Image("file:src/main/resources/dashboards/logo.png");

        stage.setTitle("helo");

        stage.setScene(scene);
        stage.getIcons().add(image);
        stage.setResizable(true);
        stage.setMaximized(true);
        /*JFXTimePicker timePicker = new JFXTimePicker();
        Button b = new Button("joidja");
        SplitPane splitpanee = (SplitPane) scene.lookup("#SplitPanee");
        GridPane addGrid = (GridPane) splitpanee.getItems().get(0);
        addGrid.add(timePicker,1,3);
        System.out.println(addGrid);       */

        stage.show();
    }
}