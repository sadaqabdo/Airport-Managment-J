package controllers;

import airportmanagment.DBConnection;
import airportmanagment.DBMethodes;
import classes.Flight;
import dashboards.TicketsDashboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.scene.control.LocalDateTimeTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.util.*;


public class FlightsController implements Initializable {
    @FXML private VBox vb;
    @FXML private GridPane addGrids;
    @FXML private MenuItem ViewFlightMenu,AddFlightMenu,SearchFlightMenu;
    @FXML private MenuItem ViewTicketMenu,AddTicketMenu,SearchTicketMenu;
    @FXML private TextField sourceSearch, destinationSearch, searchfield;
    @FXML private DatePicker datepickersearch;
    @FXML private ChoiceBox<String> addsource;
    @FXML private ChoiceBox<String> adddestination;
    @FXML private ChoiceBox<String> addterminal;
    @FXML private ChoiceBox<String> addairplane;
    @FXML private ChoiceBox<String> add_pilot;
    @FXML private LocalDateTimeTextField adddepartDate,addarrivingDate;
    @FXML private TableView<Flight> FlightTable;
    @FXML private TableColumn<Flight,String> source,destination,departDate,arrivingDate,duration;
    @FXML private TableColumn<Flight,String> pilot,flightID,airport,terminal,airplane;
    @FXML private Pane flightpnlOverview;
    @FXML private Button button_logout, bt_add, bt_delete, bt_modify, bt_exit;
    @FXML private Button bt_refresh, button_flights, button_tickets, button_employee;

    String query = null;
    //Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    classes.Flight flight = null ;
    Connection connection = DBConnection.getConnection();

    private Stage stage;
    private Scene scene;
    public Parent root;
    private final ObservableList<Flight> data = FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bt_exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            }
        });

        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBMethodes.changeScene(event, "login.fxml", "login",null );
            }
        });
        button_flights.setStyle("-fx-background-color: white;-fx-background-radius:10;-fx-text-fill:Black;");
        button_tickets.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBMethodes.changeTicket(event, "Ticket.fxml", "ticket",null );
            }
        });
        button_employee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBMethodes.changeEmployee(event, "employees.fxml", "employee",null );
            }
        });

        flightID.setCellValueFactory(new PropertyValueFactory<Flight,String>("flightID"));
        source.setCellValueFactory(new PropertyValueFactory<Flight,String>("source"));
        destination.setCellValueFactory(new PropertyValueFactory<Flight,String>("destination"));
        arrivingDate.setCellValueFactory(new PropertyValueFactory<Flight,String>("arrivingDate"));
        departDate.setCellValueFactory(new PropertyValueFactory<Flight,String>("departDate"));
        duration.setCellValueFactory(new PropertyValueFactory<Flight,String>("duration"));
        terminal.setCellValueFactory(new PropertyValueFactory<Flight,String>("terminal"));
        airplane.setCellValueFactory(new PropertyValueFactory<Flight,String>("airplaneID"));
        airport.setCellValueFactory(new PropertyValueFactory<Flight,String>("airportID"));
        pilot.setCellValueFactory(new PropertyValueFactory<Flight,String>("pilotID"));
        buildData();
    }


    public void buildData(){
        try{
            ArrayList<String> sources = new ArrayList<String>();
            ArrayList<String> destinations = new ArrayList<String>();
            List<String> terminals = Arrays.asList("A","B","C","D");
            List<String> airplanes = Arrays.asList("B-147","B-176","C-293","D-321");
            ArrayList<String> pilots = new ArrayList<String>();

            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            Statement st1 = con.createStatement();
            Statement st2 = con.createStatement();
            Statement st3 = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from Flight order by arrivingdate desc;");
            ResultSet r1 = st1.executeQuery("select Distinct source from Flight;");
            ResultSet r2 = st2.executeQuery("select Distinct destination from Flight;");
            ResultSet r3 = st3.executeQuery("select Distinct pilotid from Flight;");

            while(rs.next()){
                Flight f = new Flight();
                f.setFlightID(rs.getString(1));
                f.setSource(rs.getString(2));
                f.setDestination(rs.getString(3));
                f.setDepartDate(rs.getString(9));
                f.setArrivingDate(rs.getString(10));
                f.setDuration(f.duration());
                f.setTerminal(rs.getString(4));
                f.setAirplaneID(rs.getString(5));
                f.setPilotID(Integer.parseInt(rs.getString(6)));
                f.setAirportID(rs.getString(7));
                data.add(f);
            }
            while (r1.next()){
                sources.add(r1.getString(1));
            }
            while (r2.next()){
                destinations.add(r2.getString(1));
            }
            while (r3.next()){
                pilots.add(r3.getString(1));
            }


            FlightTable.setItems(data);

            ObservableList<String> sourceBox = FXCollections.observableList(sources);
            ObservableList<String> destinationBox = FXCollections.observableList(destinations);
            ObservableList<String> pilotsBox = FXCollections.observableList(pilots);
            ObservableList<String> airplanesBox = FXCollections.observableList(airplanes);
            ObservableList<String> terminalsBox = FXCollections.observableList(terminals);
            addsource.setItems(sourceBox);
            adddestination.setItems(destinationBox);
            addairplane.setItems(airplanesBox);
            add_pilot.setItems(pilotsBox);
            addterminal.setItems(terminalsBox);
            con.close();
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
    public void insertData(Object obj){
        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            PreparedStatement preparedStatement=null;

            if (obj != null){
                String sql = "Insert into Flight(flightid,source,destination,departdate," +
                        "arrivingdate,duration,terminal,airportid,pilotid,airplaneid)" +
                        "values(?,?,?,?,?,?,?,?,?,?);";

                int resultSet = 0;
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, ((Flight) obj).getFlightID());
                preparedStatement.setString(2,  ((Flight) obj).getSource());
                preparedStatement.setString(3, ((Flight) obj).getDestination());
                preparedStatement.setString(4, ((Flight) obj).getDepartDate().toString());
                preparedStatement.setString(5, ((Flight) obj).getArrivingDate().toString());
                preparedStatement.setString(6, ((Flight) obj).getDuration());
                preparedStatement.setString(7, ((Flight) obj).getTerminal());
                preparedStatement.setString(8, "null");
                preparedStatement.setInt(9, ((Flight) obj).getPilotID());
                preparedStatement.setString(10, ((Flight) obj).getAirplaneID());

                resultSet=preparedStatement.executeUpdate();
                System.out.println("A new record was inserted successfully!");
                data.add(0,(classes.Flight) obj);
                FlightTable.setItems(data);
                con.close();
                }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Inserting Data");
        }}

    private void searchData(String city){
        ObservableList<Flight> donnee = FXCollections.observableArrayList();

        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            PreparedStatement preparedStatement=null;
            String sql = "Select * from Flight where upper(source) = ? or upper(destination) = ?;";

            ResultSet rs;
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,  city.toUpperCase(Locale.ROOT));
            preparedStatement.setString(2,  city.toUpperCase(Locale.ROOT));
            rs = preparedStatement.executeQuery();

            while(rs.next()){
                Flight f = new Flight();
                f.setFlightID(rs.getString(1));
                f.setSource(rs.getString(2));
                f.setDestination(rs.getString(3));
                f.setDepartDate(rs.getString(9));
                f.setArrivingDate(rs.getString(10));
                f.setDuration(f.duration());
                f.setTerminal(rs.getString(4));
                f.setAirplaneID(rs.getString(5));
                f.setPilotID(Integer.parseInt(rs.getString(6)));
                f.setAirportID(rs.getString(7));
                donnee.add(f);
            }
            refreshTable(donnee);

        }
    catch(Exception e){
        e.printStackTrace();
        System.out.println("Error on Searching Data");
    }

    }
    @FXML
    private void SearchFlightMenuClbck(){
    }
    @FXML
    private void ViewFlightMenuClbck(){
    }
    @FXML
    private void AddFlightMenuClbck(){
        addGrids.setMinWidth(260);
        addGrids.setMaxWidth(460);
    }
    @FXML
    private void SearchTicketMenuClbck(){
    }
    @FXML
    private void ViewTicketMenuClbck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(TicketsDashboard.class.getResource("Ticket.fxml"));
        Stage stage = (Stage) (vb).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void AddTicketMenuClbck(){
        addGrids.setMinWidth(260);
        addGrids.setMaxWidth(460);
    }
    @FXML
    private void onCloseAddBtn(){
        addGrids.setMinWidth(0);
        addGrids.setMaxWidth(0);
    }
    @FXML
    private void onCloseSearchBtn(){    }

    @FXML
    private void bt_modify(){}
    @FXML
    private void bt_delete(){}
    @FXML
    private void bt_refresh(){}

    @FXML
    private void onAddFlight() throws ParseException {
        String source = addsource.getValue();
        String destination = adddestination.getValue();
        String arrivingdate = addarrivingDate.getText();
        String departdate = adddepartDate.getText();
        String terminal = addterminal.getValue();
        Integer pilot = Integer.parseInt(add_pilot.getValue());
        String airplane = addairplane.getValue();

        Flight e = new Flight(source,destination,departdate,arrivingdate,terminal,airplane,pilot);

        insertData(e);
    }
    @FXML
    private void onsearchflight(ActionEvent event) throws ParseException {
        String city = searchfield.getText().strip();
        searchData(city);
    }

    @FXML
    public void getModifyView(MouseEvent mouseEvent) {
        try {
            flight = FlightTable.getSelectionModel().getSelectedItem();
            String query = "UPDATE flight SET "
                    + "source=?,"
                    + "destination=?,"
                    + "departdate=?,"
                    + "arrivingdate= ?," +
                    "terminal= ?," +
                    "airplaneid= ?," +
                    "pilotid= ?" +
                    " WHERE flightid = '" + flight.getFlightID() + "'";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, addsource.getValue());
            preparedStatement.setString(2, adddestination.getValue());
            preparedStatement.setString(3, adddepartDate.getText());
            preparedStatement.setString(4, addarrivingDate.getText());
            preparedStatement.setString(5, addterminal.getValue());
            preparedStatement.setString(6, addairplane.getValue());
            preparedStatement.setInt(7, Integer.parseInt(add_pilot.getValue()));
            preparedStatement.execute();
            buildData();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    @FXML
    private void refreshTable(Object e) {
        data.remove(e);
        FlightTable.setItems(data);
    }
    @FXML
    private void refreshTable() {
        FlightTable.setItems(data);
    }
    @FXML
    private void refreshTable(ObservableList l) {
        FlightTable.setItems(l);
    }

    @FXML
    public void getDeleteView(MouseEvent mouseEvent) {
        try{
            flight = FlightTable.getSelectionModel().getSelectedItem();
            query = "DELETE FROM Flight WHERE flightid  = upper('"+ flight.getFlightID().toUpperCase(Locale.ROOT) +"')";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            refreshTable(flight);
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    void setTextField(Object obj) {

        addsource.setValue(((Flight) obj).getSource());
        adddestination.setValue(((Flight) obj).getDestination());
        adddepartDate.setText(((Flight) obj).getDepartDate().toString());
        addarrivingDate.setText(((Flight) obj).getArrivingDate().toString());
        addterminal.setValue(((Flight) obj).getTerminal());
        addairplane.setValue(((Flight) obj).getAirplaneID());
        add_pilot.setValue(((Flight) obj).getPilotID().toString());

    }

    public void tableview(MouseEvent mouseEvent) {
        try {
            flight = FlightTable.getSelectionModel().getSelectedItem();
            setTextField(flight);
        }catch (Exception e){
            e.getMessage();
        }
    }
}