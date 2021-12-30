package controllers;

import airportmanagment.DBConnection;
import classes.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.util.ResourceBundle;

public class TicketController implements Initializable {
    @FXML
    public MenuItem SearchMenu;
    @FXML
    public TextField searchField;
    @FXML
    public Button searchbtn;
    public Button Addbtn;
    public Menu Ticket;
    // bring elements from FXML
    @FXML
    private TextField TicketField, PassengerField, FlightField;
    @FXML
    private TableView<Ticket> Tck;
    @FXML
    private TableColumn<Ticket, String> ticketcol;
    @FXML
    private TableColumn<Ticket, String> passengercol;
    @FXML
    private TableColumn<Ticket, String> flightcol;
    @FXML
    private Button DeleteBtn, AddBtn ;
    // initialize data in tableview each row is a ticket object
    private ObservableList<Ticket> data = FXCollections.observableArrayList();
    private ObservableList<Ticket> searcheddata = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableView.TableViewSelectionModel<Ticket> defaultSelectionModel = Tck.getSelectionModel();
        Tck.setSelectionModel(defaultSelectionModel);

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
        Tck.setPlaceholder(new Label("No Ticket to display"));
        Tck.setItems(data);
        try {
            getTicketsDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void onAddButtonClick() throws ParseException {
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
            insertData(ticKet);
        }
    }

    @FXML
    public void OnDeleteButton() {
        Ticket ticKet = new Ticket(TicketField.getText(), PassengerField.getText(), FlightField.getText());
        int row = Tck.getSelectionModel().getSelectedIndex();
        try {
            delete(row);
            deleteData(ticKet);
        } catch (Exception IndexOutOfBoundsException) {
            System.out.println("unselected row to delete");
        }
    }

    public void AddtoTable(Ticket ticket) {
        data = Tck.getItems();
        data.add(0,ticket);
        Tck.setItems(data);
    }

    private void clearFields() {
        TicketField.clear();
        PassengerField.clear();
        FlightField.clear();
        TicketField.requestFocus();
    }

    public void delete(int row) {
        Alert confirm = new Alert(Alert.AlertType.NONE);
        confirm.setAlertType(Alert.AlertType.CONFIRMATION);
        confirm.setContentText("Are you sure you want to delete the selected line permenetly?");
        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        confirm.getButtonTypes().setAll(okButton, cancelButton);
        confirm.showAndWait().ifPresent(type -> {
            if (type == okButton) {
                Tck.getItems().remove(row);
            }
        });
    }
    PreparedStatement preparedStatement;
    ResultSet rst = null;

    public void getTicketsDB() throws SQLException {
        data = FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getConnection();
            System.out.println("connection established");
            preparedStatement = connection.prepareStatement("select * from tickets");
            rst = preparedStatement.executeQuery();
            while (rst.next()) {
                Ticket T = new Ticket();
                T.setTicketID(rst.getString(1));
                T.setPassenger(rst.getString(2));
                T.setFlight(rst.getString(3));
                AddtoTable(T);
            }
            connection.close();
        }catch (SQLException se){
            System.out.println("Connexion failed:" + se);
        }
    }
    public void insertData(Object obj) {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            if (obj instanceof Ticket) {
                String sql = "insert into tickets(idticket, passenger,flight) values(?,?,?);";
                int resultSet = 0;
                System.out.println(((Ticket) obj).getTicketID());
                System.out.println(((Ticket) obj).getPassenger());
                System.out.println(((Ticket) obj).getFlight());
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, ((Ticket) obj).getTicketID());
                preparedStatement.setString(2,  ((Ticket) obj).getPassenger());
                preparedStatement.setString(3, ((Ticket) obj).getFlight());
                resultSet=preparedStatement.executeUpdate();
                System.out.println("A new record was inserted successfully!");
                System.out.println(resultSet);
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteData(Object obj){
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            if (obj instanceof Ticket) {
                String sql="DELETE FROM tickets WHERE idticket = ?;";
                int resultSet = 0;
                System.out.println(((Ticket) obj).getTicketID());
                System.out.println(((Ticket) obj).getPassenger());
                System.out.println(((Ticket) obj).getFlight());
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, ((Ticket) obj).getTicketID());
                resultSet=preparedStatement.executeUpdate();
                System.out.println("Row deleted from database!");
                System.out.println(((Ticket) obj).getTicketID());
                con.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchForticket(String passenger){

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from tickets where passenger = ?";
            ResultSet resultSet;
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,passenger);
            resultSet = preparedStatement.executeQuery();
            System.out.println("Row found from database!");

            while(resultSet.next()) {
                Ticket selectedTicket = new Ticket(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3));
                searcheddata.add(selectedTicket);
                System.out.println(selectedTicket);
                for (int i = 0; i < Tck.getItems().size(); i++) {
                    if (Tck.getItems().get(i).getTicketID().equals(resultSet.getString(1))) {
                        System.out.println("Selected Index : " + i);
                    }
                }
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(1).getClass().getName());
            }
            Tck.setItems(searcheddata);

            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void OnsearchButton() {
        if (searchField.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("search field empty");
            // show the dialog error
            a.show();
        }else{
            searchForticket(searchField.getText());
        }
    }
    // reset button
}
