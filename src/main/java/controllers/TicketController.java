package controllers;

import classes.Passenger;
import classes.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class TicketController implements Initializable {
    // bring elements from FXML
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
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // initialize each column values
        TableView.TableViewSelectionModel<Ticket> defaultSelectionModel = View.getSelectionModel();
        View.setSelectionModel(defaultSelectionModel);

        ticketcol.setCellValueFactory(
                new PropertyValueFactory<Ticket, String>("ticketID")
        );
        passengercol.setCellValueFactory(
                new PropertyValueFactory<Ticket, String>("passenger")
        );
        flightcol.setCellValueFactory(
                new PropertyValueFactory<Ticket, String>("flight")
        );
        TicketField.setTooltip(new Tooltip("enter ticket ID"));
        PassengerField.setTooltip(new Tooltip("enter passenger"));
        FlightField.setTooltip(new Tooltip("enter Flight"));
        View.setPlaceholder(new Label("No Ticket to display"));

        View.setItems(data);

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
        //System.out.println(View.getFocusModel());
    }
    @FXML
    public void OnDeleteButton(){
    /*
        Ticket test = View.getSelectionModel().getSelectedItem();
        System.out.println(test.getTicketID());
        */
    }

    private void clearFields() {
        TicketField.clear();
        PassengerField.clear();
        FlightField.clear();
    }
    public void AddtoTable(Ticket ticket){
        data = View.getItems();
        data.add(ticket);
        View.setItems(data);
    }
    /*
    public void onDeleteButtonClick(ActionEvent actionEvent) {
        ObservableList<Ticket> RowToremove = FXCollections.observableArrayList();
    }

    private void SelectEvent() {
        for(Ticket data : View.getSelectionModel().getSelectedItems());
    }*/
}

