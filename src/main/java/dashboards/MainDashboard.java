package dashboards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainDashboard extends Application{

    @Override
    public void start(Stage stage) throws IOException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainDashboard.class.getResource("Ticket.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 700);
            stage.setTitle("Airport Nameless");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
