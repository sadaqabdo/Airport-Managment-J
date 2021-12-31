package dashboards;

import controllers.TicketController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;

import java.io.IOException;
public class TicketsDashboard extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TicketsDashboard.class.getResource("Tickets.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Image image = new Image("file:src/main/resources/dashboards/logo.png");

            stage.setTitle("Airport Nameless");
            //stage.setMaximized(true);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);

            stage.getIcons().add(image);
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getCause());
        }
    }

}