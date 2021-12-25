package controllers;

import classes.Ticket;
import dashboards.TicketsDashboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TicketsController {
    @FXML private VBox vb;

    @FXML
    private TextField TicketField, PassengerField, FlightField;
    @FXML
    private TableView<Ticket> View;
    @FXML
    private TableColumn<Ticket, String> ticketcol;
    @FXML
    private TableColumn<Ticket, String> passengercol;
    @FXML
    private TableColumn<Ticket, String> flightcol;
    @FXML
    private Button DeleteBtn, AddBtn ;
    // initialize data in tableview each row is a ticket object
    ObservableList<Ticket> data = FXCollections.observableArrayList();
    ObservableList<Ticket> SelectedItem ;
    private Stage stage;
    private Scene scene;
    public Parent root;
    @FXML
    private void SearchFlightMenuClbck(){

    }
    @FXML
    private void ViewFlightMenuClbck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(TicketsDashboard.class.getResource("/dashboards/flights.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void AddFlightMenuClbck(){

    }
    @FXML
    private void SearchTicketMenuClbck(){

    }
    @FXML
    private void ViewTicketMenuClbck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(TicketsDashboard.class.getResource("/dashboards/Ticket.fxml"));
        Stage stage = (Stage) (vb).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void backToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/dashboards/Main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void AddTicketMenuClbck(){

    }
    @FXML
    private void onCloseAddBtn(){

    }
    @FXML
    private void onCloseSearchBtn(){
    }
    @FXML
    private void onAddFlight() {
    }
    @FXML
    public void onAddButtonClick() {
        Ticket ticKet = new Ticket(TicketField.getText(), PassengerField.getText(), FlightField.getText());
        // think about condition type of input later
        if (TicketField.getText().isEmpty() || PassengerField.getText().isEmpty() || FlightField.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Tous les champs sont obligatoire");
            // show the dialog error
            a.show();
        } else {
            // add data to table and clear fields immediately
            AddtoTable(ticKet);
            clearFields();
        }
    }
    @FXML
    public void OnDeleteButton(){
        //Ticket test = View.getSelectionModel().getSelectedItem();
        //System.out.println(test.getTicketID());
        int row = View.getSelectionModel().getSelectedIndex();
        try {
            delete(row);
        }
        catch(Exception IndexOutOfBoundsException){
            System.out.println("unselected row to delete");
        }
    }

    public void AddtoTable(Ticket ticket){
        data = View.getItems();
        data.add(ticket);
        View.setItems(data);
    }

    private void clearFields() {
        TicketField.clear();
        PassengerField.clear();
        FlightField.clear();
        TicketField.requestFocus();
    }

    public void delete(int row){
        View.getItems().remove(row);
    }
}
