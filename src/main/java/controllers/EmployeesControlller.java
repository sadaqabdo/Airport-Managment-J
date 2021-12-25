package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeesControlller {
    @FXML private GridPane addGrid,searchGrid;
    @FXML private MenuItem ViewEmpMenu,AddEmpMenu,SearchEmpMenu;
    @FXML private ChoiceBox addSource,addDestination,addTerminal,addAirplane,add_Pilot;



    private Stage stage;
    private Scene scene;

    @FXML
    private void SearchEmpMenuClbck(){
        searchGrid.setMinWidth(350);
        searchGrid.setMaxWidth(350);
    }
    @FXML
    private void ViewEmpMenuClbck(){
    }
    @FXML
    private void AddEmpMenuClbck(){
        addGrid.setMinWidth(350);
        addGrid.setMaxWidth(350);
    }

    @FXML
    private void onCloseAddBtn(){
        addGrid.setMinWidth(0);
        addGrid.setMaxWidth(0);
    }
    @FXML
    private void onCloseSearchBtn(){
        searchGrid.setMinWidth(0);
        searchGrid.setMaxWidth(0);
    }
    @FXML
    private void onAddFlight(){
        addDestination.setValue(addSource.getValue());
    }

    public void backToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/dashboards/Main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
