package dashboards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginDashboard extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(LoginDashboard.class.getResource("login.fxml"));
        Scene scene = new Scene(root, 600, 200);
        stage.setTitle("helo");
        stage.setScene(scene);  
        stage.show();
    }
}