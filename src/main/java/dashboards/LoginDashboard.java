package dashboards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginDashboard extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(LoginDashboard.class.getResource("login.fxml"));
            Scene scene = new Scene(root);
            Image image = new Image("file:src/main/resources/dashboards/logo.png");

            stage.setTitle("Login");
            stage.setMaximized(true);

            stage.getIcons().add(image);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}